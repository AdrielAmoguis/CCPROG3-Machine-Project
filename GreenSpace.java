/**
 * This class represents the space for Pay Day or Pay Raise.
 * This class inherits from the abstract class Space
 */
public class GreenSpace extends Space
{
    /**
     * This attribute holds the type of GreenSpace this is.
     * 0 - Pay Day
     * Nonzero - Pay Raise
     */
    public final int TYPE;

    /**
     * This constructor calls the superclass constructor, passing it the path this space belongs to.
     * This constructor initializes the value for type, as given by the parameter.
     * @param path - the path that this space belongs to.
     * @param type - the type of GreenSpace this space is.
     */
    public GreenSpace(Path path, int type)
    {
        super(path);
        if(type==0)
            TYPE = 0;
        else
            TYPE = 1;
    }

    /**
     * This getter method returns a string that describes the type of GreenSpace this instance is.
     * @return greenSpaceType : String
     */
    public String getType()
    {
        return TYPE == 0 ? "Pay Day" : "Pay Raise";
    }

    /**
     * This method implements the abstract method event() in the super class.
     * This event gets called when a player lands on this space.
     * @param player - the player that landed.
     */
    protected void event(Player player)
    {
        // Pay day
        if(this.TYPE == 0)
        {
            player.credit(player.getSalary().getSalary(), "What day is it? It's Pay Day!");
        }
        else // Pay Raise
        {
            player.getSalary().payRaise();
        }
    }

    @Override
    public String toString()
    {
        return new String(
            "[GreenSpace " + String.valueOf(this.ID) + "]"
        );
    }
}