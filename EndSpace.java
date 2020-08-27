public class EndSpace extends Space
{
    public EndSpace()
    {
        super(null);
    }

    public void event(Player player)
    {
        System.out.println("Congratulations on your retirement, " + player.getName() + "!");
    }

    @Override
    public String toString()
    {
        return new String(
            "[EndSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}