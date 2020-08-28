import java.util.*;

public class ActionDeck extends Deck
{
    public ActionDeck(ArrayList<Player> players)
    {
        super("Action Deck");
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

        Collections.shuffle(cards);
    }
}