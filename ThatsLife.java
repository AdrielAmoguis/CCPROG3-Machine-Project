import java.util.*;

/**
 * Main game class of the game. It contains the main MAP instance of the entire game as well as the instances of the players,
 * and the instances of all decks of cards.
 */
public class ThatsLife 
{
    public static final Scanner kb = new Scanner(System.in);

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

    // List of players
    private ArrayList<Player> players;

    // Turn
    private int turn;

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
        decks[1] = new SalaryDeck((new Random()).nextInt(25));
        decks[2] = new BlueDeck(players);
        decks[3] = new ActionDeck(players);
        decks[4] = new HouseDeck();

        // Initialize Player StartSpace
        for(Player player : players)
        {
            player.getSpace().playerLand(player);
        }
    }

    private void createPlayer()
    {
        // Get player name
        System.out.printf("[%d] Enter new player name: ", this.players.size()+1);
        Player player = new Player(ThatsLife.kb.nextLine());
        this.players.add(player);
    }

    public Map getMap()
    {
        return map;
    }

    public int getTurn()
    {
        return turn;
    }

    public String getPlayerString(int index)
    {
        return this.players.get(index).toString();
    }

    public int startTurn(long randomSeed)
    {
        // Get the player instance
        Player player = players.get(turn);

        // Player Spins for a Move
        int moveSteps = rollNumber(randomSeed);

        // Move the player
        player.move(moveSteps);

        // Update turn
        this.turn = (this.turn + 1) % players.size();

        return getTurn();
    }

    public boolean isOngoing()
    {
        int nPlayers = this.players.size();
        if(map.getEndSpace().getNoOfPlayers() == nPlayers)
            return false;
        return true;
    }

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
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    public static int rollNumber(long seed)
    {
        Random rand = new Random(seed);
        return rand.nextInt(10) + 1;
    }

    public static Deck getDeck(int index)
    {
        return decks[index];
    }
    
}