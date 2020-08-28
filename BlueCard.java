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
        this.amount = 0;

        if(matchingCareer.equalsIgnoreCase("lawsuit"))
        {
            Random rand = new Random(ThatsLife.rollNumber());
            this.amount = 10000*(5 + rand.nextInt(11));
        }
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
            player.credit(15000);
            paid = true;
        }
        if(!paid && !isMatch(player))
        {
            for (Player otherPlayer : players) 
            {
                if(otherPlayer.getCareer().NAME.equals(player.getCareer().NAME))
                {
                    paid = true;
                    player.debit(15000);
                    otherPlayer.credit(15000);
                }    
            }
        }
        if(!paid)
        {
            player.debit(15000);
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
        player.debit(this.amount);
    }

    private void salaryTaxDue(Player player)
    {
        player.debit(player.getSalary().getTaxDue());
    }

    private void tipTheServer(Player player)
    {
        int randNum = ThatsLife.rollNumber();
        player.debit(randNum*10000);
    }

    private void skiAccident(Player player)
    {
        player.debit(10000);
    }

    private void computerRepair(Player player)
    {
        int randNum = ThatsLife.rollNumber();
        if(randNum % 2 == 0)
            player.debit(5000);
        else
            player.debit(10000);
    }

    private void worldCup(Player player)
    {
        player.debit(this.players.size() * 5000);
    }

    private void f1Race(Player player)
    {
        player.debit(player.getSalary().getSalary());
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