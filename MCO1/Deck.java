import java.util.*;

/**
 * This is the abstract superclass of all the card deck classes in the game.
 * The deck is a container of any kind of game card.
 * Card generation is not done by this class, but the classes that inherits from it.
 */
public abstract class Deck 
{
    /**
     * This attribute contains the deck's name.
     */
    protected String deckName;

    /**
     * This attribute contains the list of all cards in the deck.
     */
    protected ArrayList<Card> cards;

    /**
     * This constructor initializes the deck's name and the cards' ArrayList object.
     * @param deckName : String
     */
    public Deck(String deckName)
    {
        this.deckName = deckName;
        cards = new ArrayList<Card>();
    }

    /**
     * This getter method returns the deck's name.
     * @return deckName : String
     */
    public String getDeckName()
    {
        return new String(deckName);
    }

    /**
     * This getter method returns the deck size.
     * @return deckSize : int
     */
    public int getDeckSize()
    {
        return cards.size();
    }

    /**
     * This getter method returns an array version of this deck.
     * This method is only used for debugging or MP demo to display the generated cards.
     * @return deck : Card[]
     */
    public Card[] getDeck()
    {
        Card[] deck = new Card[cards.size()];
        for(int i = 0; i < cards.size(); i++)
        {
            deck[i] = cards.get(i);
        }
        return deck;
    }

    /**
     * This method simulates drawing a card from a deck, like how a stack data structure would work.
     * This method removes the first card in the ArrayList and returns it.
     * @return card : Card
     */
    public Card drawCard()
    {
        return cards.remove(0);
    }

    /**
     * This method returns the given card to the last part of the deck.
     * @param card : Card to return to deck
     */
    public void returnCard(Card card)
    {
        cards.add(card);
    }

    @Override
    public String toString()
    {
        String mainString = new String();

        for (Card card : cards) 
        {
                mainString += " | ";
                mainString += card.toString();
        }
        
        return mainString;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        
        Deck compare = (Deck) obj;
        return (
            this.deckName.equals(compare.getDeckName()) &&
            this.getDeckSize() == compare.getDeckSize()
        );
    }
}