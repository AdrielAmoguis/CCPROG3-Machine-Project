package thatslife;
/**
 * This Card class does not do anything but state the abstract method event.
 * It is also defined to allow for polymorphism between card types.
 */
public abstract class Card implements java.io.Serializable
{
	/**
	 * This is the UID for serializing into a binary object.
	 */
	private static final long serialVersionUID = 22552965L;

    /**
     * This method is called when the card is drawn.
     * @param player : Player
     */
    public abstract void event(Player player);
}