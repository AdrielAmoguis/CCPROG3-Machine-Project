import java.util.Collections;

public class ActionDeck extends Deck
{
    public ActionDeck()
    {
        super("Action Deck");
        generateCards();
    }

    protected void generateCards()
    {
        /*
            Generation Rules:
            1. Generate 50 cards
        */
        final int size = 50;
        for(int i = 0; i < size * 0.4; i++)
            cards.add(new ActionCard(0));
        
        for(int i = 0; i < size * 0.4; i++)
            cards.add(new ActionCard(1));
        
        for(int i = 0; i < size * 0.1; i++)
            cards.add(new ActionCard(2));

        for(int i = 0; i < size * 0.1; i++)
            cards.add(new ActionCard(3));

        Collections.shuffle(cards);
    }
}