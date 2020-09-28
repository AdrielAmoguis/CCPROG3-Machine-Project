package thatslife;
import java.util.Collections;

/**
 * This class defines the container for all house cards.
 * This class inhertis from the Deck class.
 */
public class HouseDeck extends Deck
{
	/**
	 * This is the UID for serializing into a binary object.
	 */
	private static final long serialVersionUID = ThatsLife.serializeUID;
	
    /**
     * This constructor calls the superclass constructor to initialize superclass attributes.
     * This constructor then calls the generateCards() method to populate the deck.
     */
    public HouseDeck()
    {
        super("House Deck");
        generateCards();
    }    

    /**
     * This method instantiates and stores all house cards based on the given Machine Project specifications.
     */
    protected void generateCards()
    {
        /*
            Generation Rules:
            1. Make up our own houses
        */
        cards.add(new HouseCard("Bungalow", (1 + ThatsLife.rollNumber() % 6)*100000, (ThatsLife.rollNumber() % 5)*100000));
        cards.add(new HouseCard("Apartment", 100000*(ThatsLife.rollNumber() % 4), 100000*(ThatsLife.rollNumber() % 3)));
        cards.add(new HouseCard("Mansion", 100000*(5 + ThatsLife.rollNumber() % 5), 100000*(3 + ThatsLife.rollNumber() % 6)));
        cards.add(new HouseCard("Villa", 100000*(6 + ThatsLife.rollNumber() % 4), 100000*(4 + ThatsLife.rollNumber() % 4)));
        cards.add(new HouseCard("Country Side", 100000*(2 + ThatsLife.rollNumber() % 4), 100000*(2 + ThatsLife.rollNumber() % 3)));
        cards.add(new HouseCard("Penthouse", 900000, 700000));
        Collections.shuffle(cards);
    }
}