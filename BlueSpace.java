public class BlueSpace extends Space
{
    public BlueSpace(Path path)
    {
        super(path);
    }    

    protected void event(Player player)
    {
        // Draw blue card

        // Do stuff with the card
    }

    @Override
    public String toString()
    {
        return new String(
            "[BlueSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}