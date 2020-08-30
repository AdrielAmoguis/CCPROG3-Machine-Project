import java.util.*;

public class ActionCard extends Card
{
    public final String NAME;
    public final int TYPE;
    public final double AMOUNT;

    private ArrayList<Player> allPlayers;
    
    public ActionCard(int type, ArrayList<Player> players)
    {
        TYPE = type;
        NAME = generateName();
        this.allPlayers = players;

        // Generate for the amount
        Random rand = new Random(ThatsLife.rollNumber());
        AMOUNT = 10000*(1 + rand.nextInt(13));
    }

    private String generateName()
    {
        switch(TYPE)
        {
            case 0:
                switch(ThatsLife.rollNumber() % 6)
                {
                    case 0:
                    case 1: return "Tax Refund";
                    case 2: return "Sell an Item";
                    case 3: return "Bonus Payday";
                    case 4: return "Setup School";
                    case 5: return "Write a Book";
                } break;
            case 1:
                switch(ThatsLife.rollNumber() % 7)
                {
                    case 0:
                    case 1: return "Buy an Item";
                    case 2: return "Visit a Place";
                    case 3: return "Hiking";
                    case 4: return "Watch a Show";
                    case 5: return "Win a Competition";
                    case 6: return "Traffic Violation";
                } break;
            case 2:
                switch(ThatsLife.rollNumber() % 3)
                {
                    case 0:
                    case 1: return "Lawsuit";
                    case 2: return "Christmas Bonus";
                } break;
            case 3:
                switch(ThatsLife.rollNumber() % 3)
                {
                    case 0:
                    case 1: return "File a Lawsuit";
                    case 2: return "It's your Birthday";
                } break;
        }
        return null;
    }

    public void event(Player player)
    {
        switch(TYPE)
        {
            case 0: collectFromBank(player); break;
            case 1: payTheBank(player); break;
            case 2: payThePlayer(player); break;
            case 3: collectFromPlayer(player); break;
        }
    }

    private Player choosePlayer(Player exclude)
    {
        int index;
        while(true)
        {
            System.out.println("Choose player:");
            for(int i = 0; i < allPlayers.size(); i++)
            {
                System.out.printf("[%d] %s\n", i+1, allPlayers.get(i).getName());
            }
            System.out.print("Your Choice: ");
            index = Integer.parseInt(ThatsLife.kb.nextLine()) - 1;

            if(!(index < 0 || index >= allPlayers.size()))
                if(!allPlayers.get(index).equals(exclude))
                    break;
        }
        return this.allPlayers.get(index);
    }

    private void collectFromBank(Player player)
    {
        System.out.printf("[You drew an Action Card!] The bank pays you %.2f for %s.\n", this.AMOUNT, this.NAME);
        player.credit(this.AMOUNT, "Action card value credited.");
    }

    private void payTheBank(Player player)
    {
        System.out.printf("[You drew an Action Card!] You pay the bank %.2f for %s.\n", this.AMOUNT, this.NAME);
        player.debit(this.AMOUNT, "Action card value debited.");
    }

    private void payThePlayer(Player player)
    {
        System.out.printf("[You drew an Action Card!] You pay a player %.2f for %s.\n", this.AMOUNT, this.NAME);

        Player chosen = choosePlayer(player);
        
        player.debit(this.AMOUNT, "You paid a player the value of the this Action Card.");
        chosen.credit(this.AMOUNT, player.getName() + " has paid you.");
    }

    private void collectFromPlayer(Player player)
    {
        System.out.printf("[You drew an Action Card!] You collect %.2f from a player for %s.\n", this.AMOUNT, this.NAME);

        Player chosen = choosePlayer(player);
        
        player.credit(this.AMOUNT, "You received the value of this Action Card from another player.");
        chosen.debit(this.AMOUNT, player.getName() + " has collected funds from you.");
    }

    @Override
    public String toString()
    {
        return (
            "[ActionCard] " + this.NAME + " | Amount = " + String.valueOf(this.AMOUNT)
        );
    }
}