public class BlueSpace extends Space
{
    public BlueSpace(Path path)
    {
        super(path);
    }    

    protected void event(Player player)
    {
        // Draw blue card
        BlueCard card = (BlueCard) ThatsLife.getDeck(2).drawCard();

        // Call the card event
        card.event(player);
    }

    @Override
    public String toString()
    {
        return new String(
            "[BlueSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}