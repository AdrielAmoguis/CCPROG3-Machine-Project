import java.util.*;

public class MagentaSpace extends Space
{
    public final int TYPE;
    private ArrayList<Player> allPlayers;
    
    public MagentaSpace(Path path, int type, ArrayList<Player> players)
    {
        super(path);
        TYPE = type;
        this.allPlayers = players;
    }

    public String getType()
    {
        switch(TYPE)
        {
            case 0: return "College Career Choice";
            case 1: return "Job Search";
            case 2: return "Buy House";
            case 3: return "Get Married";
            case 4: return "Have Baby";
            case 5: return "Have Twins";
            case 6: return "Graduation";
            case 7: return "Career Choice";
        }

        return "INVALID";
    }

    protected void event(Player player)
    {
        switch(TYPE)
        {
            case 0: collegeCareerChoice(player); break;
            case 1: jobSearch(player); break;
            case 2: buyHouse(player); break;
            case 3: getMarried(player); break;
            case 4: haveBaby(player); break;
            case 5: haveTwins(player); break;
            case 6: graduate(player); break;
            case 7: careerChoice(player); break;
        }

        // Roll Again
        int spin = ThatsLife.rollNumber(player.spin());
        player.move(spin);
    }

    // EVENT FUNCTIONS
    private void collegeCareerChoice(Player player)
    {
        
    }

    private void jobSearch(Player player)
    {

    }

    private void buyHouse(Player player)
    {

    }

    private void getMarried(Player player)
    {
        if(!(player.isMarried()))
        {
            player.setSpouse(true);
            int spin = ThatsLife.rollNumber(player.spin());
            if (spin % 2 == 1)
            {
                player.credit(5000*(allPlayers.size()-1));
                for (Player otherPlayer : allPlayers) 
                {
                    if(!(player.equals(otherPlayer)))
                        otherPlayer.debit(5000);    
                }
            }
            else
            {
                player.credit(10000*(allPlayers.size()-1));
                for (Player otherPlayer : allPlayers) 
                {
                    if(!(player.equals(otherPlayer)))
                        otherPlayer.debit(10000);    
                }
            }
        }
    }
    
    private void haveBaby(Player player)
    {
        if(player.isMarried())
        {
            player.credit(5000*(allPlayers.size()-1));
            for (Player otherPlayer : allPlayers) 
            {
                if(!(player.equals(otherPlayer)))
                    otherPlayer.debit(5000);    
            }
        }
    }

    private void haveTwins(Player player)
    {
        if(player.isMarried())
        {
            player.credit(10000*(allPlayers.size()-1));
            for (Player otherPlayer : allPlayers) 
            {
                if(!(player.equals(otherPlayer)))
                    otherPlayer.debit(10000);    
            }
        }
    }

    private void graduate(Player player)
    {
        System.out.println("Contratulations on your graduation, " + player.getName() + "!");
    }

    private void careerChoice(Player player)
    {
        
    }

    @Override
    public String toString()
    {
        return new String(
            "[MagentaSpace (" + this.getType() + ") " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}