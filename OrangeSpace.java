public class OrangeSpace extends Space
{
    public OrangeSpace(Path path)
    {
        super(path);
    }

    protected void event(Player player)
    {
        // Draw action card
        ActionCard card = (ActionCard) ThatsLife.getDeck(3).drawCard();

        // Call card event
        card.event(player);
    }

    @Override
    public String toString()
    {
        return new String(
            "[OrangeSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}