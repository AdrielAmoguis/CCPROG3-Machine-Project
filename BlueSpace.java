public class BlueSpace extends Space
{
    public BlueSpace(Path path)
    {
        super(path);
    }    

    protected void event(Player player)
    {
        // Draw blue card
        BlueCard card = (BlueCard) ThatsLife.DECKS[2].drawCard();

        // Do stuff with the card
    }
}