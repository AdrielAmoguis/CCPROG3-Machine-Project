public class BlueSpace extends Space
{
    public BlueSpace(Path path)
    {
        super(path);
    }    

    protected void event(Player player)
    {
        // Draw blue card
        BlueCard card = ThatsLife.DECKS[2].drawCard();

        // Do stuff with the card
    }
}