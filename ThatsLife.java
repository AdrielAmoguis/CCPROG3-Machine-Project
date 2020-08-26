import java.util.*;

/**
 * Main game class of the game. It contains the main MAP instance of the entire game as well as the instances of the players,
 * and the instances of all decks of cards.
 */
public class ThatsLife 
{
    /**
     * This static final variable contains the main map instance of the entire game.
     */
    public static final Map MAP;

    /**
     * This static array contains all the instances for all deck types.
     * Index 0 - DECK
     * Index 1 - DECK
     * Index 2 - DECK
     * Index 3 - DECK
     */
    public static final Deck[] DECKS;

    // List of players
    private ArrayList<Player> players;

    /**
     * The default constructor initializes the main MAP and card decks. Sets players to empty ArrayList.
     * @param players Accepts an instance of ArrayList<Player> - this will be the main reference instance to be used.
     */
    public ThatsLife()
    {
        // Declare Players ArrayList instance
        this.players = new ArrayList<Player>();

        // Create the MAP
        MAP = new Map();

        // Create all decks
        DECKS = new Deck[4];
        DECKS[0] = new CareerDeck();
        DECKS[1] = new SalaryDeck((new Random()).nextInt(25));
        DECKS[2] = new BlueDeck();
        DECKS[3] = new ActionDeck();
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

    
}