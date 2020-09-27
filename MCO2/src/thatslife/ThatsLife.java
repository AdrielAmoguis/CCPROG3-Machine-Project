package thatslife;

import controllers.GameWindowController;
import java.util.*;
import java.time.*;
import java.io.*;

/**
 * That's Life (inspired by the board game "The Game of Life")
 * This class is the master That's Life game class. It holds all the life cycles of all the classes.
 */
public class ThatsLife implements java.io.Serializable
{
	public static final long serializeUID = 22552965L;
	/**
	 * This is the UID for serializing into a binary object.
	 */
	private static final long serialVersionUID = serializeUID;

	/**
	 * This is the supported file extension for save games
	 */
	public static final String FILEEXT = "lifesav";
	
	/**
	 * The controller instance assigned to this instance of the game
	 */
	private static GameWindowController controller;
	
    /**
     * This static attribute contains some game arguments that some of the game classes would take.
     * An example of such argument is the norng argument, which inhibits the use of RNG when dealing
     * with player spin. As such, the player will enter a number rather than spin for a random one.
     */
    public static ArrayList<String> args = new ArrayList<String>();

    /**
     * This is the central randomizer to be used by the entire game. Keeping just one randomizer object will use the same source
     * of entropy (which is system time in nanoseconds). Having the same entropy would imply a more uniformly distributed probability
     * for random number generation.
     */
    private static Random rand = new Random(LocalTime.now().toNanoOfDay());

    /**
     * This static final variable contains the main map instance of the entire game.
     */
    private Map map;

    /**
     * This static array contains a mirror of all the instances for all deck types.
     * Index 0 - Career Card Deck
     * Index 1 - Salary Card Deck
     * Index 2 - Blue Card Deck
     * Index 3 - Action Card Deck
     * Index 4 - House Card Deck
     */
    private static Deck[] decks;
    
    /**
     * The actual instances of all decks
     */
    private Deck[] actualDecks;

    /**
     * This attribute holds the instances of all the players.
     */
    private ArrayList<Player> players;

    // Turn
    /**
     * This attribute holds the current player who has the turn for the game.
     */
    private int turn;

    /**
     * This attribute holds the integer that determines if all players have had their first turns already.
     */
    private int firstMove;

    /**
     * A game is instantiated given the number of players for the game. The constructor initializes all the players, the map, and all card decks.
     * @param playerNames An ArrayList of the player names to be used to instantiate the game. playerNames.size() will be used to determine the number of players.
     */
    public ThatsLife(ArrayList<String> playerNames)
    {
    	controller = null;
    	
        // Declare Players ArrayList instance
        this.players = new ArrayList<Player>();

        for(int i = 0; i < playerNames.size(); i++)
        {
        	this.players.add(new Player(playerNames.get(i)));
        }

        // Initialize the turn
        turn = 0;

        // Create the MAP
        map = new Map(this.players);

        // Set the players to the starting space
        for (Player player : this.players)
        {
            player.setSpace(map.getStartSpace());    
        }

        // Create all decks
        boolean found = false;
        
        actualDecks = new Deck[5];
        
        actualDecks[0] = new CareerDeck();
        
        for(String arg : args)
        {        	
        	if(arg.startsWith("salaryCards"))
        	{
        		String nCards = arg.substring("salaryCards=".length());
        		actualDecks[1] = new SalaryDeck(Integer.parseInt(nCards));
        	}
        }
        if(!found)
        	actualDecks[1] = new SalaryDeck(10 + (new Random()).nextInt(25));
        
        actualDecks[2] = new BlueDeck(players);
        
        // Action Card Generation from Args
        
        for(String arg : args)
        {        	
        	if(arg.startsWith("actionCards"))
        	{
        		String nCards = arg.substring("actionCards=".length());
        		actualDecks[3] = new ActionDeck(players, Integer.parseInt(nCards));
        	}
        }
        if(!found)
        	actualDecks[3] = new ActionDeck(players, 50);
        
        actualDecks[4] = new HouseDeck();
        
        ThatsLife.decks = actualDecks;

        // Initialize Player StartSpace
        firstMove = 0;
    }
    
    /**
     * This constructor includes the JFX GameWindowController instance as parameter.
     * It calls the previous contructor.
     * @param playerNames An ArrayList of type String that contains the player names
     * @param c The instance of the controller to be used for this game instance.
     */
    public ThatsLife(ArrayList<String> playerNames, GameWindowController c)
    {
    	this(playerNames);
    	
    	ThatsLife.controller = c;
    }

    /**
     * This method returns the map instance for this instance of the game.
     * @return map : Map
     */
    public Map getMap()
    {
        return map;
    }

    /**
     * This method returns the value for which player's turn it currently is.
     * @return turn : int
     */
    public int getTurn()
    {
        return turn;
    }

    /**
     * This method returns a player's information, based on the Player class' toString method.
     * @param index - The index of the player in the player array. Must be 0 - nPlayers - 1.
     * @return playerData : String
     */
    public String getPlayerString(int index)
    {
        return this.players.get(index).toString();
    }
    
    /**
     * This method returns an array of the player's past transactions.
     * @param index - The index of the player in the list of players
     * @return Transaction[] - The array of the player's past transactions.
     */
    public Transaction[] getPlayerTransactions(int index)
    {
    	return players.get(index).getTransactions();
    }
    
    /**
     * This method returns the number of players in the game.
     * @return The number of players in the active game.
     */
    public int getNumPlayers()
    {
    	return this.players.size();
    }
    
    /**
     * This method returns the instances for all card decks in the game.
     * @return card decks
     */
    
    public Deck[] getDecks()
    {
    	return this.actualDecks;
    }

    /**
     * This method initiates a player's turn. It returns the player index for the next turn.
     * @return nextTurn : int
     */
    public int startTurn(int n)
    {
        // Get the player instance
        Player player = players.get(turn);
        boolean moved = false;

        // Check if first move
        if(firstMove++ < players.size())
        {
            player.getSpace().playerLand(player);
            moved = true;
        }

        // Check if player finished
        if(!(player.getSpace() instanceof EndSpace) && !moved)
        {
            // Check if player has loans
            if(player.getLoan() > 0 && player.getBalance() >= player.getLoan())
            {
               // Display loan and ask player if they would like to pay
            	String prompt = new String(String.format("You have an existing loan of $%.2f. You have enough money to pay off your loans. Would you like to pay off your loans?", player.getLoan()));
            	String[] choices = new String[2];
            	choices[0] = new String("Yes");
            	choices[1] = new String("No");
            	
            	// Display Decision Box
            	int decision = ThatsLife.controller.displayDecision(prompt, choices);
            	
            	// Pay off the loan if decision = 0
            	if(decision == 0)
            		player.payLoan(false);
            }

            // Prompt the player
            if(!ThatsLife.args.contains("norng"))
                ThatsLife.controller.displayPrompt("\n[Spin to Move] Press button to spin for a number and move. ");
            else
            	ThatsLife.controller.displayPrompt("\n[NORNG] Random Number Generator Inhibited. Input custom spin number: ");

            // Player Spins for a Move
            int moveSteps = n;

            // Move the player
            player.move(moveSteps);

            moved = true;
        }
        else if(player.getSpace() instanceof EndSpace)
        	ThatsLife.controller.displayPrompt(String.format("[%s] You have already retired!\n", player.getName()));

        // Update turn
        this.turn = (this.turn + 1) % players.size();

        return getTurn();
    }

    /**
     * This method checks if the game is still ongoing by checking the final space of the map if it holds all the players.
     * It returns a boolean value that represents the game state.
     * @return isOnGoing : boolean
     */
    public boolean isOngoing()
    {
        int nPlayers = this.players.size();
        if(map.getEndSpace().getNoOfPlayers() == nPlayers)
            return false;
        return true;
    }

    /**
     * This method returns the single String that contains the final ranking for all players after the game.
     * This method should only be called once the isOnGoing() method return false.
     * @return rank : String
     */
    public String declareRanking()
    {
        Player[] finalRank = map.getEndSpace().getPlayers();

        // Sort the player ranking (sort by balance) - using Insertion Sort
        // Insertion sort by Rajat Mishra. Reference: https://www.geeksforgeeks.org/insertion-sort/
        int n = finalRank.length; 
        for (int i = 1; i < n; ++i) 
        { 
            Player key = finalRank[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && finalRank[j].getBalance() < key.getBalance()) 
            { 
                finalRank[j + 1] = finalRank[j]; 
                j = j - 1; 
            } 
            finalRank[j + 1] = key; 
        }
        
        String rank = new String();
        for(int i = 0; i < finalRank.length; i++)
        {
            rank += "[" + String.valueOf(i+1) + "] " + finalRank[i].toString() + "\n\n";
        }
        return rank;
    }
    
    /**
     * This method adds arguments to the game's static arguments class variable.
     * These arguments are used to inhibit/customize certain game behaviors.
     * @param arg : String - argument to add.
     */
    public static void addGameArgs(String arg)
    {
        ThatsLife.args.add(arg);
    }

    /**
     * This is the main random number generator for the game. It "spins" and generates a number from [1,10].
     * @return An integer corresponding to the randomly generated number.
     */
    public static int rollNumber()
    {
        return rand.nextInt(10) + 1;
    }

    /**
     * This method returns the instance of the card deck given the index.
     * 0 - Career Deck
     * 1 - Salary Deck
     * 2 - Blue Deck
     * 3 - Action Deck
     * 4 - House Deck
     * @param index : int - index of the deck
     * @return deck : Deck
     */
    public static Deck getDeck(int index)
    {
        return decks[index];
    }
    
    /**
     * This method sets the session deck list.
     * @param deck : The deck set to use
     */
    public static void setDeck(Deck[] deck)
    {
    	ThatsLife.decks = deck;
    }
    
    /**
     * This method allows the user to save the instance of the game in a binary file unique to this program implementation.
     * @param game The instance of the game.
     * @param filepath The filepath for the save location.
     * @return Boolean representation if the game was successfully saved or otherwise.
     */
    public static boolean saveGame(ThatsLife game, String filepath)
    {
    	try
    	{
    		FileOutputStream f = new FileOutputStream(filepath);
    		ObjectOutputStream out = new ObjectOutputStream(f);
    		
    		out.writeObject(game);
    		
    		out.close();
    		f.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error saving game state: " + e.toString());
    		return false;
    	}
    	
    	return true;
    }
    
    /**
     * This method allows the user to load a serialized instance of a game and continue playing it.
     * @param filepath The filepath for the saved game binary file.
     * @return Returns the instance of the ThatsLife game.
     */
    public static ThatsLife loadGame(String filepath) throws Exception
    {
    	ThatsLife game = null;
    	try
    	{
    		FileInputStream f = new FileInputStream(filepath);
    		ObjectInputStream in = new ObjectInputStream(f);
    		
    		game = (ThatsLife)in.readObject();
    		
    		in.close();
    		f.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error loading game save: " + e.toString());
    	}
    	
    	return game;
    }
    
    /**
     * This sets the session's JavaFX controller.
     * @param c : The JFX controller class to set.
     */
    public static void setSessionJFXController(GameWindowController c)
    {
    	ThatsLife.controller = c;
    }
    
    /**
     * This returns the reference to the instance of the game's JavaFX controller.
     * @return : The game's assigned JFX controller class.
     */
    public static GameWindowController getSessionJFXController()
    {
    	return ThatsLife.controller;
    }
}