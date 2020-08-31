/**
 * This class defines the most common space in the game, the OrangeSpace.
 * This class inherits from the Space class.
 */
public class OrangeSpace extends Space
{
    /**
     * This constructor calls sthe superclass constructor, passing the path parameter.
     * @param path : Path - the path that this space belongs to
     */
    public OrangeSpace(Path path)
    {
        super(path);
    }

    /**
     * This method implements the event() method in the superclass.
     * This method gets called when a player lands on this space.
     * Draws a card from the ActionCard deck and executes its event.
     * @param player : Player - the player to execute the event on
     */
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
            "[OrangeSpace " + String.valueOf(this.ID) + "]"
        );
    }
}