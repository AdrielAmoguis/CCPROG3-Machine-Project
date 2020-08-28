import java.util.*;

public class BlueDeck extends Deck
{
    public BlueDeck(ArrayList<Player> players)
    {
        super("Blue Deck");
        generateCards(players);
    }
    
    protected void generateCards(ArrayList<Player> players)
    {
        /*
            Generation Rules:
            1. Preset generation
        */
        cards.add(new BlueCard("Lawsuit", "Lawyer", players));
        cards.add(new BlueCard("Salary Tax Due", "Accountant", players));
        cards.add(new BlueCard("Tip the Server", "Server", players));
        cards.add(new BlueCard("Ski Accident", "Doctor", players));
        cards.add(new BlueCard("Computer Repair", "Computer Consultant", players));
        cards.add(new BlueCard("World Cup", "Athlete", players));
        cards.add(new BlueCard("F1 Race", "Racecar Driver", players));
        Collections.shuffle(cards);
    }
}