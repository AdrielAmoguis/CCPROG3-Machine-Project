package thatslife;
import java.util.*;

/**
 * This class is the container that initializes and holds all ActionCards.
 */
public class ActionDeck extends Deck
{
	/**
	 * This is the UID for serializing into a binary object.
	 */
	private static final long serialVersionUID = ThatsLife.serializeUID;
	
    /**
     * This attribute holds all the ActionCards before they were shuffled.
     */
    public ActionCard[] beforeShuffle;

    /**
     * This constructor initializes the ActionCards
     * @param players : ArrayList of Player - this list is not stored on this deck, but is just used to initialize the cards.
     * @param numCards : The number of cards to generate.
     */
    public ActionDeck(ArrayList<Player> players, int numCards)
    {
        super("Action Deck");
        beforeShuffle = new ActionCard[numCards];
        generateCards(players);
    }

    /**
     * This is an implementation of the abstract method from the Deck class that generates all the cards, based on the
     * specifications described in the Machine Project specifications.
     * @param players : ArrayList of Player - to be passed onto the cards.
     */
    protected void generateCards(ArrayList<Player> players)
    {
        /*
            Generation Rules:   
            1. Generate 50 cards
        */
    	final int size = beforeShuffle.length;
        for(int i = 0; i < size * 0.4; i++)
            cards.add(new ActionCard(0, players));
        
        for(int i = 0; i < size * 0.4; i++)
            cards.add(new ActionCard(1, players));
        
        for(int i = 0; i < size * 0.1; i++)
            cards.add(new ActionCard(2, players));

        for(int i = 0; i < size * 0.1; i++)
            cards.add(new ActionCard(3, players));

        // Copy the data to the beforeShuffle array before shuffling
        for(int i = 0; i < size; i++)
            this.beforeShuffle[i] = (ActionCard) this.cards.get(i);

        Collections.shuffle(cards);
    }

    /**
     * This method overrides the superclass method for drawing cards.
     * This is implemented as there is a possibility for all 50 cards to all used up.
     * When this occurs, this method detects the empty cards ArrayList then refills
     * it with the same cards that were generated at the start of the game then shuffles the deck.
     * @return toReturn : Card (ActionCard)
     */
    @Override
    public Card drawCard()
    {
        Card toReturn = cards.remove(0);

        // Refill if exhausted
        if(cards.size() == 0)
        {
            for(int i = 0; i < beforeShuffle.length; i++)
            {
                cards.add(beforeShuffle[i]);
            }
            Collections.shuffle(cards);
        }

        return toReturn;
    }

    /**
     * This method generates a String array that contains all the string representations of all the cards.
     * This method is only for use as indicated in the Machine Project specifications just to display card
     * generation and does not impact the operation of the game.
     * @return cardsData : String[]
     */
    public String[] getStrCards()
    {
        String[] master = new String[this.cards.size()];
        for(int i = 0; i < this.cards.size(); i++)
        {
            master[i] = ((ActionCard)this.cards.get(i)).toString();
        }
        return master;
    }
}