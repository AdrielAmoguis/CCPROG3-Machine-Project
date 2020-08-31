import java.util.*;

/**
 * This class defines the container for the SalaryCards.
 * This class inherits from the Deck class.
 */
public class SalaryDeck extends Deck
{
    /**
     * This attribute holds the initial number of cards that this deck should have.
     */
    private int numCards;

    /**
     * This constructor calls the superclass constructor.
     * It also instantiates the numCards attribute then generates all cards.
     * @param n : int - the number of cards to generate in this deck.
     */
    public SalaryDeck(int n)
    {
        super("Salary Deck");
        this.numCards = n;
        generateCards();
    }    

    /**
     * This method instantiates and stores SalaryCards to the superclass' cards ArrayList.
     */
    protected void generateCards()
    {
        /*
            Generation Rules for the Salary Deck:
            1. AT LEAST 10 Salary Cards with Varying Salary Amounts
            2. Salary Amounts are Multiples of 10000
            3. Tax Due are Multiples of 1000
            4. Values in each card are randomly generated at the start of each game
        */
        Random rand = new Random(ThatsLife.rollNumber());
        for(int i = 0; i < numCards; i++)
        {
            cards.add(new SalaryCard((double)(1 + rand.nextInt(20)) * 10000));
        }
        Collections.shuffle(cards);
    }
}