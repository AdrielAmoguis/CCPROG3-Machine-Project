import java.util.*;

public class BlueCard extends Card
{
    public final String NAME;
    private double amount;
    private ArrayList<Player> players;
    private String matchingCareer;

    public BlueCard(String name, String matchingCareer, ArrayList<Player> players)
    {
        this.NAME = name;
        this.matchingCareer = matchingCareer;
        this.players = players;
        this.amount = 10000*(5 + (new Random()).nextInt(11));
    }

    public String getCareer()
    {
        return matchingCareer;
    }

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

    private boolean isMatch(Player player)
    {
        if(this.matchingCareer.equals(player.getCareer().NAME))
            return true;
        return false;
    }

    private void lawsuit(Player player)
    {
        player.debit(this.amount, "You get into a nasty lawsuit!");
    }

    private void salaryTaxDue(Player player)
    {
        player.debit(player.getSalary().getTaxDue(), "You paid your tax dues.");
    }

    private void tipTheServer(Player player)
    {
        int randNum = player.spin();
        player.debit(randNum*10000, "You tipped the server.");
    }

    private void skiAccident(Player player)
    {
        player.debit(10000, "You got into a ski accident and paid for hospital bills!");
    }

    private void computerRepair(Player player)
    {
        int randNum = player.spin();;
        if(randNum % 2 == 0)
            player.debit(5000, "Computer damages aren't as bad. Your paid for its repair.");
        else
            player.debit(10000, "Your computer has been badly damaged. You paid for its repair.");
    }

    private void worldCup(Player player)
    {
        player.debit(this.players.size() * 5000, "You watch the world cup!");
    }

    private void f1Race(Player player)
    {
        player.debit(player.getSalary().getSalary()*0.1, "You watch the Formula One race.");
    }

    @Override
    public String toString()
    {
        return (
            "[Blue Card] " + this.NAME + ", Matches " + this.matchingCareer
        );
    }

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