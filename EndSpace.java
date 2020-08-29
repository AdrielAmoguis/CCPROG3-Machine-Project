public class EndSpace extends Space
{
    public EndSpace()
    {
        super(null);
    }

    public void event(Player player)
    {
        System.out.println("Congratulations on your retirement, " + player.getName() + "!");
        
        // Process Retirement

        // Collect retirement pay from the Bank
        if(players.size() == 1)
            player.credit(100000);
        else if(players.size() == 2)
            player.credit(50000);
        else
            player.credit(20000);

        // Collect $10000 for each child he has from the bank
        player.credit(player.getChildren()*10000);

        // Sell the house to the bank for the amount listed
        if(player.getHouse() != null)
        {
            player.credit(player.getHouse().SELL);
            player.setHouse(null);
        }

        // Repay all loans
        
    }   

    @Override
    public String toString()
    {
        return new String(
            "[EndSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}