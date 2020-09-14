package thatslife;
/**
 * This Card class does not do anything but state the abstract method event.
 * It is also defined to allow for polymorphism between card types.
 */
public abstract class Card 
{
    /**
     * This method is called when the card is drawn.
     * @param player : Player
     */
    public abstract void event(Player player);
}