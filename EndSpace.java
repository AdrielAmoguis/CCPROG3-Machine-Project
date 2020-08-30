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
            player.credit(100000, "You're the first to retire! Retirement pay has been paid.");
        else if(players.size() == 2)
            player.credit(50000, "You retired second! Retirement pay has been paid.");
        else
            player.credit(20000, "You retired last! Retirement pay has been paid.");

        // Collect $10000 for each child he has from the bank
        player.credit(player.getChildren()*10000, "Your children (if any) wants to give back and has given you $10000 each!");

        // Sell the house to the bank for the amount listed
        if(player.getHouse() != null)
        {
            player.credit(player.getHouse().SELL, "You sold your house.");
            player.setHouse(null);
        }

        // Repay all loans
        
    }   

    public Player[] getPlayers()
    {
        Player[] finPlayers = new Player[this.players.size()];
        int i = 0;
        for(Player player : this.players)
        {
            finPlayers[i++] = player;
        }

        return finPlayers;
    }

    @Override
    public String toString()
    {
        return new String(
            "[EndSpace " + String.valueOf(this.ID) + "]"
        );
    }
}