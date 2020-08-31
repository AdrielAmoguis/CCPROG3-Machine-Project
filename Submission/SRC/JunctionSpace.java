/**
 * This class defines the JunctionSpace, which is a MagentaSpace that prompts the user to decide where to go.
 * This class inherits from the MagentaSpace class.
 */
public class JunctionSpace extends MagentaSpace
{
    /**
     * This attribute holds the leftSpace, or option 1 for the junction.
     */
    private Space leftSpace;

    /**
     * This attribute holds the rightSpace, or option 2 for the junction.
     */
    private Space rightSpace;

    /**
     * This constructor calls the superclass constructor to initialize all superclass attributes.
     * It passes the path, -1 for the type, and null for the players ArrayList.
     * @param path - the path that this junction mainly belongs on
     */
    public JunctionSpace(Path path)
    {
        super(path, -1, null);
    }

    /**
     * This getter method returns the leftSpace.
     * @return leftSpace : Space
     */
    public Space getLeftSpace()
    {
        return this.leftSpace;
    }

    /**
     * This getter method returns the rightSpace
     * @return rightSpace : Space
     */
    public Space getRightSpace()
    {
        return this.rightSpace;
    }

    /**
     * This setter method sets the leftSpace attribute.
     * This is called in map generation.
     * @param space : Space - space to set as left space
     */
    public void setLeftSpace(Space space)
    {
        this.leftSpace = space;
    }

    /**
     * This setter method sets the rightSpace attribute.
     * This is caleld in map generation.
     * @param space : Space - space to set as right space
     */
    public void setRightSpace(Space space)
    {
        this.rightSpace = space;
    }

    /**
     * This method implements the abstract method event() in the superclass of the superclass.
     * This method is called when a player lands on this junction space.
     * This method triggers the player to make a decision about the junction.
     * @param player : Player - player to execute event
     */
    protected void event(Player player)
    {
        setPlayerPath(player);
    }

    /**
     * This setter method is to be called by the event method.
     * This method prompts the user for a decision on the junction the sets that player on that path.
     * @param player : Player - player to set path
     */
    private void setPlayerPath(Player player)
    {
        String options = new String();
        options += "You have hit a junction. Choose a path:\n";
        options += "[1] " + leftSpace.getPath().getName() + "\n";
        options += "[2] " + rightSpace.getPath().getName() + "\n";
        options += "Your Choice: ";
        int choice = 0;
        while(true)
        {
            choice = player.decision(options);
            if(choice > 0 && choice <= 2)
                break;
        }
        
        if(choice == 1)
        {
            // Left path
            // Roll again
            int spin = player.spin();
            this.setNextSpace(leftSpace);
            player.move(spin);
        }
        else
        {
            // Right path
            // Roll again
            int spin = player.spin();
            this.setNextSpace(rightSpace);
            player.move(spin);
        }
    }

    @Override
    public String toString()
    {
        return new String(
            "[JunctionSpace (" + this.leftSpace.toString() + ";" + this.rightSpace.toString() + ")" + String.valueOf(this.ID) + "]"
        );
    }
}