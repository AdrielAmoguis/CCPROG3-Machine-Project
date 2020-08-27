public class OrangeSpace extends Space
{
    public OrangeSpace(Path path)
    {
        super(path);
    }

    protected void event(Player player)
    {
        // Draw action card

        // Do stuff with the card
    }

    @Override
    public String toString()
    {
        return new String(
            "[OrangeSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}