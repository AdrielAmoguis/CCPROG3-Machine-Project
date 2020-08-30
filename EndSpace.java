/**
 * This class defines the final space that players will land on, which is the retirement space.
 * This class inherits from the Space class.
 */
public class EndSpace extends Space
{
    /**
     * This constructor calls the super constructor to initialize the superclass attributes.
     * Unlike the other children of the abstract Space class, this class does not belong to a path,
     * and hence calls the superclass constructor with a null value for path.
     */
    public EndSpace()
    {
        super(null);
    }

    /**
     * This method implements the abstract method event() from the super class.
     * This method gets called when a player lands on this Space.
     * This method processes the player's retirement event.
     * @param player
     */
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
        player.rawDebit(player.getLoan(), "Your loans were paid off.");
    }   

    /**
     * This getter method returns the array of players that are in this space.
     * This method is used when obtaining the final ranking after the game finishes.
     * @return Player[]
     */
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