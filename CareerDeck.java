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
        cards.add(new CareerCard("Lawyer", true, 4 + ThatsLife.rollNumber() % 5));
        cards.add(new CareerCard("Accountant", true, 3 + ThatsLife.rollNumber() % 5));
        cards.add(new CareerCard("Computer Consultant", true, 2 + ThatsLife.rollNumber() % 6));
        cards.add(new CareerCard("Doctor", true, 4 + ThatsLife.rollNumber() % 5));
        cards.add(new CareerCard("Server", false, ThatsLife.rollNumber() % 5));
        cards.add(new CareerCard("Racecar Driver", false, 1 + ThatsLife.rollNumber() % 8));
        cards.add(new CareerCard("Athlete", false, ThatsLife.rollNumber() % 7));
        // Shuffle Deck
        Collections.shuffle(cards, new Random(ThatsLife.rollNumber()));
    }
}