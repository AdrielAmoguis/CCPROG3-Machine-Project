import java.util.*;

/**
 * This class is the container that initializes and holds all ActionCards.
 */
public class BlueDeck extends Deck
{
    /**
     * This constructor initializes all Blue Cards and defines the deck's name.
     * @param players : the array list of players
     */
    public BlueDeck(ArrayList<Player> players)
    {
        super("Blue Deck");
        generateCards(players);
    }
    
    /**
     * This method generates the cards in this deck.
     * @param players - ArrayList of players
     */
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