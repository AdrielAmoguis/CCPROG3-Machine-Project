import java.util.*;
import java.time.*;

/**
 * <h1>That's Life (inspired by the board game "The Game of Life")</h1>
 * This class is the master That's Life game class. It holds all the life cycles of all the classes.
 */
public class ThatsLife 
{
    /**
     * Since it is recommended by the Java community to use a single scanner for all user inputs, this is it.
     * Even the Main Driver Class has to use this scanner. This is because there are instances where when multiple scanners are being used
     * and being closed, the InputStream in Java closes, hence, not allowing other scanners to function properly.
     * 
     * This scanner should be closed before the driver class closes.
     */
    public static final Scanner kb = new Scanner(System.in);

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
     * This static array contains all the instances for all deck types.
     * Index 0 - Career Card Deck
     * Index 1 - Salary Card Deck
     * Index 2 - Blue Card Deck
     * Index 3 - Action Card Deck
     * Index 4 - House Card Deck
     */
    private static Deck[] decks;

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
     * @param numPlayers An integer value of the number of players for the new instance of the game.
     */
    public ThatsLife(int numPlayers)
    {    
        // Declare Players ArrayList instance
        this.players = new ArrayList<Player>();

        // Create players
        for(int i = 0; i < numPlayers; i++)
            createPlayer();

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
        decks = new Deck[5];
        decks[0] = new CareerDeck();
        decks[1] = new SalaryDeck(10 + (new Random()).nextInt(25));
        decks[2] = new BlueDeck(players);
        decks[3] = new ActionDeck(players);
        decks[4] = new HouseDeck();

        // Initialize Player StartSpace
        firstMove = 0;
    }

    /**
     * This method instantiates the player object and stores it into the main players ArrayList which is found as a private instance variable for this class.
     */
    private void createPlayer()
    {
        // Get player name
        System.out.printf("[%d] Enter new player name: ", this.players.size()+1);
        Player player = new Player(ThatsLife.kb.nextLine());
        this.players.add(player);
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
     * This method initiates a player's turn. It returns the player index for the next turn.
     * @return nextTurn : int
     */
    public int startTurn()
    {
        // Get the player instance
        Player player = players.get(turn);

        // Check if first move
        if(firstMove++ < players.size())
            player.getSpace().playerLand(player);

        // Check if player finished
        if(!(player.getSpace() instanceof EndSpace))
        {
            // Player Spins for a Move
            int moveSteps = rollNumber();

            // Move the player
            player.move(moveSteps);
        }
        else
            System.out.printf("[%s] You have already retired!\n", player.getName());

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
        String rank = new String();
        for(int i = 0; i < finalRank.length; i++)
        {
            rank += "[" + String.valueOf(i+1) + "] " + finalRank[i].toString() + "\n";
        }
        return rank;
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
    
}