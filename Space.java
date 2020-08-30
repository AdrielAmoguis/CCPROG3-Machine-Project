import java.util.*;

/**
 * This class defines the very building-block of the game, the Space.
 */
public abstract class Space 
{
    /**
     * This attribute statically stores the count of how many spaces have been created. This is used
     * for the Space ID system.
     */
    protected static int count = 0;

    /**
     * This attribute stores the path where the space belongs.
     */
    private Path path;

    /**
     * This attribute stores this instance's space ID.
     */
    public final int ID;

    /**
     * This attribute stores the list of players standing on this space at a time.
     */
    protected ArrayList<Player> players;

    private Space nextSpace;

    public Space(Path path)
    {  
        Space.count++;
        this.ID = Space.count;
        this.path = path;
        players = new ArrayList<Player>();
    }

    public void playerLand(Player player)
    {
        this.players.add(player);   
        event(player);     
    }

    public void playerLeave(Player player)
    {
        this.players.remove(player);
    }

    // ABSTRACT METHOD
    /**
     * This method is to be implemented by child classes of this class.
     * It will be called by the playerLand() method upon a player lands on this instance.
     */
    protected abstract void event(Player player);

    /**
     * This setter method sets this space's next space.
     * This is called by the initSpaces() method in the Path class.
     * @param space
     */
    public void setNextSpace(Space space)
    {
        this.nextSpace = space;
    }

    /**
     * This getter method returns the instance for the next space from this space instance.
     * @return
     */
    public Space getNextSpace()
    {
        return this.nextSpace;
    }

    /**
     * This getter method returns the number of players on this space.
     * @return
     */
    public int getNoOfPlayers()
    {
        return this.players.size();
    }

    /**
     * This getter method returns the path this space belongs.
     * @return path
     */
    public Path getPath()
    {
        return this.path;
    }

    @Override
    public String toString()
    {
        return new String(
            "[Space " + String.valueOf(this.ID) + "]"
        );
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        Space compare = (Space) obj;
        
        return (
            this.ID == compare.ID
        );
    }
}