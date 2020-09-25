package thatslife;
/**
 * This space inherits from the Space class and prompts the user to draw a BlueCard, upon playerLand.
 */
public class BlueSpace extends Space
{
	/**
	 * This is the UID for serializing into a binary object.
	 */
	private static final long serialVersionUID = ThatsLife.serializeUID;
	
    /**
     * This constructor calls the super constructor.
     * @param path - the path that this space is on.
     */
    public BlueSpace(Path path)
    {
        super(path);
    }    

    /**
     * This method implements the abstract method in the Space class.
     * This method gets called when a player lands on this space.
     */
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
            "[BlueSpace " + String.valueOf(this.ID) + "]"
        );
    }
}