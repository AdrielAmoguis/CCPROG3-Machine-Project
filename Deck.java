import java.util.*;

public abstract class Deck 
{
    protected String deckName;
    protected ArrayList<Card> cards;

    public Deck(String deckName)
    {
        cards = new ArrayList<Card>();
    }

    public String getDeckName()
    {
        return new String(deckName);
    }

    public int getDeckSize()
    {
        return cards.size();
    }

    public Card[] getDeck()
    {
        Card[] deck = new Card[cards.size()];
        for(int i = 0; i < cards.size(); i++)
        {
            deck[i] = cards.get(i);
        }
        return deck;
    }

    public Card drawCard()
    {
        return cards.remove(0);
    }

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