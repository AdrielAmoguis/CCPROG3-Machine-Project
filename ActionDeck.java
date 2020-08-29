import java.util.*;

public class ActionDeck extends Deck
{
    public ActionCard[] beforeShuffle;

    public ActionDeck(ArrayList<Player> players)
    {
        super("Action Deck");
        beforeShuffle = new ActionCard[50];
        generateCards(players);
    }

    protected void generateCards(ArrayList<Player> players)
    {
        /*
            Generation Rules:   
            1. Generate 50 cards
        */
        final int size = 50;
        for(int i = 0; i < size * 0.4; i++)
            cards.add(new ActionCard(0, players));
        
        for(int i = 0; i < size * 0.4; i++)
            cards.add(new ActionCard(1, players));
        
        for(int i = 0; i < size * 0.1; i++)
            cards.add(new ActionCard(2, players));

        for(int i = 0; i < size * 0.1; i++)
            cards.add(new ActionCard(3, players));

        // Copy the data to the beforeShuffle array before shuffling
        for(int i = 0; i < cards.size(); i++)
            this.beforeShuffle[i] = (ActionCard) this.cards.get(i);

        Collections.shuffle(cards);
    }

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