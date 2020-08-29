import java.util.*;

public class CareerDeck extends Deck
{
    public CareerDeck()
    {
        super("Career Deck");
        generateCards();
    }

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