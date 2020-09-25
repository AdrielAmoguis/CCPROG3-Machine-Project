package thatslife;
import java.util.*;

/**
 * This class defines the BlueCard object.
 * The BlueCard object simulates the player to experience a "life event".
 */
public class BlueCard extends Card
{
    /**
     * This attribute contains the card's name, which is defined outside of this class.
     */
    public final String NAME;

    /**
     * This attribute contains the card's monetary value, which is generated according to the "lawsuit" specification in the 
     * Machine Project specifications.
     */
    private double amount;

    /**
     * This attribute contains the ArrayList of the players.
     */
    private ArrayList<Player> players;

    /**
     * This attribute contains a string of the career name that this card matches with.
     */
    private String matchingCareer;

    /**
     * This constructor initializes the attributes of this class.
     * @param name - the name of this blue card
     * @param matchingCareer - the career that matches the nature (name) of this blue card
     * @param players - the list of players of the game
     */
    public BlueCard(String name, String matchingCareer, ArrayList<Player> players)
    {
        this.NAME = name;
        this.matchingCareer = matchingCareer;
        this.players = players;
        this.amount = 10000*(5 + (new Random()).nextInt(11));
    }

    /**
     * This getter method returns the card's assigned matchingCareer.
     * @return matchingCareer : String
     */
    public String getCareer()
    {
        return matchingCareer;
    }

    /**
     * This method implements the event() abstract method from the Card class that will automatically be called
     * when the card is drawn.
     * @param player : Player - the player to be performed the event to
     */
    public void event(Player player)
    {
        boolean paid = false;
        if (isMatch(player))
        {
            player.credit(15000, "Your career matches this card!");
            paid = true;
        }
        else if(!paid && !isMatch(player))
        {
            for (Player otherPlayer : players) 
            {
                if(isMatch(otherPlayer) && !otherPlayer.equals(player))
                {
                    paid = true;
                    player.debit(15000, "Your career does not match this card. You give funds to the player with this career.");
                    otherPlayer.credit(15000, "Another player has picked up your matching blue card for your career.");
                }    
            }
        }
        else if(!paid)
        {
            player.debit(15000, "No one has the career on this card. You paid the bank.");
        }


        switch(this.matchingCareer)
        {
            case "Lawyer": lawsuit(player); break;
            case "Accountant": salaryTaxDue(player); break;
            case "Computer Consultant": computerRepair(player); break;
            case "Doctor": skiAccident(player); break; 
            case "Server": tipTheServer(player); break;
            case "Racecar Driver": f1Race(player); break;
            case "Athlete": worldCup(player); break;
        }
    }

    /**
     * This method determines if the player's career matches this card's assigned career.
     * @param player - the player to check
     * @return isMatch : boolean
     */
    private boolean isMatch(Player player)
    {
        if(this.matchingCareer.equals(player.getCareer().NAME))
            return true;
        return false;
    }

    /**
     * This method gets called when the card's matching career is lawyer.
     * @param player : Player - player to lawsuit
     */
    private void lawsuit(Player player)
    {
    	ThatsLife.getSessionJFXController().displayPrompt("[BlueCard] Someone filed a lawsuit against you!");
        player.debit(this.amount, "You get into a nasty lawsuit!");
    }

    /**
     * This method gets called when the card's matching career is accountant.
     * @param player : Player - player to pay tax due
     */
    private void salaryTaxDue(Player player)
    {
    	ThatsLife.getSessionJFXController().displayPrompt("[BlueCard] The government told you to pay your tax dues.");
        player.debit(player.getSalary().getTaxDue(), "You paid your tax dues.");
    }

    /**
     * This method gets called when the card's matching career is server.
     * @param player : Player - player who will tip the server
     */
    private void tipTheServer(Player player)
    {
    	ThatsLife.getSessionJFXController().displayPrompt("[BlueCard] You wanna tip the server in your favorite restaurant.");
        int randNum = player.spin();
        player.debit(randNum*10000, "You tipped the server.");
    }

    /**
     * This method gets called when the card's matching career is doctor.
     * @param player : Player - player who got into a ski accident.
     */
    private void skiAccident(Player player)
    {
    	ThatsLife.getSessionJFXController().displayPrompt("[BlueCard] You got into a ski accident!");
        player.debit(10000, "You got into a ski accident and paid for hospital bills!");
    }

    /**
     * This method gets called when the card's matching career is computer consultant.
     * @param player : Player - player whose computer got damaged
     */
    private void computerRepair(Player player)
    {
    	ThatsLife.getSessionJFXController().displayPrompt("[BlueCard] Your personal computer is broken. How broken is it? [Even - 5000; Odd - 10000]");
        int randNum = player.spin();;
        if(randNum % 2 == 0)
            player.debit(5000, "Computer damages aren't as bad. Your paid for its repair.");
        else
            player.debit(10000, "Your computer has been badly damaged. You paid for its repair.");
    }

    /**
     * This method gets called when the card's matching career is athlete.
     * @param player : Player - player who watched the world cup
     */
    private void worldCup(Player player)
    {
    	ThatsLife.getSessionJFXController().displayPrompt("[BlueCard] You want to watch the world cup!");
        player.debit(this.players.size() * 5000, "You watch the world cup!");
    }

    /**
     * This method gets called when the card's matching career is racecar driver.
     * @param player : Player - player who watched the F1 race
     */
    private void f1Race(Player player)
    {
    	ThatsLife.getSessionJFXController().displayPrompt("[BlueCard] You want to watch the Foruma One race!");
        player.debit(player.getSalary().getSalary()*0.1, "You watch the Formula One race.");
    }

    /**
     * This method converts this instance's data into its string representation.
     * @return String
     */
    @Override
    public String toString()
    {
        return (
            "[Blue Card] " + this.NAME + ", Matches " + this.matchingCareer
        );
    }

    /**
     * This method checks if an object is equal to this instance.
     * @param obj : Object to commpare
     * @return boolean
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        BlueCard compare = (BlueCard) obj;

        return (
            compare.NAME.equals(this.NAME) && compare.matchingCareer.equals(this.matchingCareer)
        );
    }
}