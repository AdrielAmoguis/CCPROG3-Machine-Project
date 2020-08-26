import java.util.Collections;

public class BlueDeck extends Deck
{
    public BlueDeck()
    {
        super("Blue Deck");
        generateCards();
    }   
    
    protected void generateCards()
    {
        /*
            Generation Rules:
            1. Preset generation
        */
        cards.add(new BlueCard("Lawsuit", "Lawyer"));
        cards.add(new BlueCard("Salary Tax Due", "Accountant"));
        cards.add(new BlueCard("Tip the Server", "Server"));
        cards.add(new BlueCard("Ski Accident", "Doctor"));
        cards.add(new BlueCard("Computer Repair", "Computer Consultant"));
        cards.add(new BlueCard("World Cup", "Athlete"));
        cards.add(new BlueCard("F1 Race", "Racecar Driver"));
        Collections.shuffle(cards);
    }
}