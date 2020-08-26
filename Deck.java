import java.util.*;

public abstract class Deck 
{
    protected String deckName;
    protected ArrayList<Card> cards;

    public Deck(String deckName)
    {
        cards = new ArrayList<Card>();
        generateCards();
    }

    public String getDeckName()
    {
        return new String(deckName);
    }

    public int getDeckSize()
    {
        return cards.size();
    }

    public Card drawCard()
    {
        Card drawn = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return drawn;
    }

    public void returnCard(Card card)
    {
        cards.add(0, card);
    }

    protected abstract void generateCards();

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