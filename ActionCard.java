import java.util.*;

public class ActionCard extends Card
{
    public final String NAME;
    public final int TYPE;
    public final double AMOUNT;

    private ArrayList<Player> players;
    
    public ActionCard(int type, ArrayList<Player> players)
    {
        TYPE = type;
        NAME = generateName();
        this.players = players;

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
            case 1: collectFromBank(player); break;
            case 2: payTheBank(player); break;
            case 3: payThePlayer(player); break;
            case 4: collectFromPlayer(player); break;
        }
    }

    private Player choosePlayer(Player exclude)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Choose player: ");
        int index = Integer.parseInt(kb.nextLine());
        kb.close();

        if(index < 0 || index > this.players.size())
            return null;
        if(exclude.equals(this.players.get(index)))
            return null;

        
        return this.players.get(index);
    }

    private void collectFromBank(Player player)
    {
        System.out.println("You drew an ActionCard! " + this.toString());
        System.out.printf("You have credited $%.2f from the bank.\n", this.AMOUNT);
        player.credit(this.AMOUNT);
    }

    private void payTheBank(Player player)
    {
        System.out.println("You drew an ActionCard! " + this.toString());
        System.out.printf("You paid $%.2lf to the bank.\n", this.AMOUNT);
        player.debit(this.AMOUNT);
    }

    private void payThePlayer(Player player)
    {
        System.out.println("You drew an ActionCard! " + this.toString());

        Player chosen = choosePlayer(player);
        System.out.printf("You have paid $%.2lf to %s.\n", this.AMOUNT, chosen.getName());
        
        player.debit(this.AMOUNT);
        chosen.credit(this.AMOUNT);
    }

    private void collectFromPlayer(Player player)
    {
        System.out.println("You drew an ActionCard! " + this.toString());

        Player chosen = choosePlayer(player);
        System.out.printf("You have received $%.2lf from %s.\n", this.AMOUNT, chosen.getName());
        
        player.credit(this.AMOUNT);
        chosen.debit(this.AMOUNT);
    }

    @Override
    public String toString()
    {
        return (
            "[ActionCard] " + this.NAME + " | Amount = " + String.valueOf(this.AMOUNT)
        );
    }
}