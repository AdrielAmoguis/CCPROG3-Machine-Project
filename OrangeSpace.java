public class OrangeSpace extends Space
{
    public OrangeSpace(Path path)
    {
        super(path);
    }

    protected void event(Player player)
    {
        // Draw action card
        ActionCard card = (ActionCard) ThatsLife.DECKS[3].drawCard();

        // Do stuff with the card
    }
}