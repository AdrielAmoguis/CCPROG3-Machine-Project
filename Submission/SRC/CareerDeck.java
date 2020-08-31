import java.util.*;

/**
 * This class is the container of the CareerCards.
 * It is responsible for career card storage and generation.
 * This class inherits from the Deck class.
 */
public class CareerDeck extends Deck
{
    /**
     * This constructor calls the super constructor to initialize the name of the deck
     * and calls the method generateCards() to generate all career cards.
     */
    public CareerDeck()
    {
        super("Career Deck");
        generateCards();
    }

    /**
     * This method generates the career cards with respect to Machine Project specifications.
     */
    protected void generateCards()
    {
        /*
            Generation Rules for Career Card:
            - Just generate all seven careers
        */
        // This new random object has been created due to the anomaly that the game randomizer does on this class.
        Random rand = new Random(ThatsLife.rollNumber());
        cards.add(new CareerCard("Lawyer", true, 5 + rand.nextInt(4)));
        cards.add(new CareerCard("Accountant", true, 4 + rand.nextInt(4)));
        cards.add(new CareerCard("Computer Consultant", true, 3 + rand.nextInt(5)));
        cards.add(new CareerCard("Doctor", true, 5 + rand.nextInt(4)));
        cards.add(new CareerCard("Server", false, 1 + rand.nextInt(4)));
        cards.add(new CareerCard("Racecar Driver", false, 2 + rand.nextInt(7)));
        cards.add(new CareerCard("Athlete", false, 1 + rand.nextInt(6)));
        // Shuffle Deck
        Collections.shuffle(cards, new Random(ThatsLife.rollNumber()));
    }
}