public class StartSpace extends Space
{
    public StartSpace()
    {
        super(null);
    }

    public void event(Player player)
    {
        System.out.println("Welcome to the game, " + player.getName() + "!");
    }
}