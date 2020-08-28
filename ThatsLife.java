import java.util.*;

/**
 * Main game class of the game. It contains the main MAP instance of the entire game as well as the instances of the players,
 * and the instances of all decks of cards.
 */
public class ThatsLife 
{
    public static Scanner kb;
    /**
     * This static final variable contains the main map instance of the entire game.
     */
    private Map map;

    /**
     * This static array contains all the instances for all deck types.
     * Index 0 - DECK
     * Index 1 - DECK
     * Index 2 - DECK
     * Index 3 - DECK
     */
    private static Deck[] decks;

    // List of players
    private ArrayList<Player> players;

    /**
     * A game is instantiated given the number of players for the game. The constructor initializes all the players, the map, and all card decks.
     * @param numPlayers An integer value of the number of players for the new instance of the game.
     */
    public ThatsLife(int numPlayers)
    {    
        kb = new Scanner(System.in);

        // Declare Players ArrayList instance
        this.players = new ArrayList<Player>();

        // Create players
        for(int i = 0; i < numPlayers; i++)
            createPlayer();

        // Create the MAP
        map = new Map(this.players);

        // Set the players to the starting space
        for (Player player : this.players)
        {
            player.setSpace(map.getStartSpace());    
        }

        // Create all decks
        decks = new Deck[4];
        decks[0] = new CareerDeck();
        decks[1] = new SalaryDeck((new Random()).nextInt(25));
        decks[2] = new BlueDeck(players);
        decks[3] = new ActionDeck(players);
    }

    private void createPlayer()
    {
        // Get player name
        System.out.printf("Enter new player name: ");
        Player player = new Player(ThatsLife.kb.nextLine());
        this.players.add(player);
    }

    public Map getMap()
    {
        return map;
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