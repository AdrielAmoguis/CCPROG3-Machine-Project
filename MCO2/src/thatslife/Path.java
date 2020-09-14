package thatslife;
import java.util.*;

/**
 * This class defines the structure blocks of the game, the paths.
 * Paths are made up of spaces.
 */
public abstract class Path 
{
    /**
     * This attribute holds all of the spaces that belong to this path.
     */
    protected ArrayList<Space> spaces;

    /**
     * This attribute stores the first space of the path.
     */
    protected Space originSpace;

    /**
     * This attribute stores the last space of the path.
     */
    protected Space destinationSpace;

    /**
     * This attribute stores the path name.
     */
    private String name;
    
    /**
     * This constructor instantiates all attributes of this class, given the parameters.
     * The players ArrayList is not stored within this instance but used to initialize the MagentaSpaces.
     * @param name : String - name of the path
     * @param origin : Space - starting point of the path
     * @param dest : Space - ending point of the path
     * @param players : ArrayList of Player - list of players
     */
    public Path(String name, Space origin, Space dest, ArrayList<Player> players)
    {
        this.name = name;
        this.originSpace = origin;
        this.destinationSpace = dest;
        this.spaces = new ArrayList<Space>();
        generateSpaces(players);
        initSpaces();
    }

    /**
     * This is the method that brings all the spaces together.
     * It links all the spaces to their next space on the path, except for the path's destination space.
     */
    private void initSpaces()
    {
        for (int i = 0; i < spaces.size(); i++) 
        {
            if(i < spaces.size()-1)
            {
                spaces.get(i).setNextSpace(spaces.get(i+1));
            }
        }
    }

    /**
     * This getter method returns the size of this path.
     * @return size : int
     */
    public int getPathLen()
    {
        return spaces.size();
    }

    /**
     * This getter method returns the instance of the space with the given index in the spaces ArrayList
     * @param index : int - index of the space to grab
     * @return space : Space
     */
    public Space getSpace(int index)
    {
        return this.spaces.get(index);
    }

    /**
     * This getter method returns the instance of this path's origin space.
     * @return space : Space
     */
    public Space getOriginSpace()
    {
        return this.originSpace;
    }

    /**
     * This getter method returns the instance of this path's end space.
     * @return space : Space
     */
    public Space getDestSpace()
    {
        return this.destinationSpace;
    }

    /**
     * This getter method returns the name of this path instance.
     * @return name : String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * This setter method sets this path instance's starting space.
     * @param space : Space - the space to set as this path's starting space
     */
    public void setStartSpace(Space space)
    {
        this.originSpace = space;
    }

    /**
     * This abstract method is left unimplemented for the child classes to implement.
     * This method should contain the generation method for the child classes to follow.
     * The players ArrayList parameter is to instantiate the MagentaSpaces.
     * @param players : Players ArrayList - the players of the game
     */
    protected abstract void generateSpaces(ArrayList<Player> players);

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        Path compare = (Path) obj;
        
        return (
            this.originSpace.equals(compare.getOriginSpace()) &&
            this.destinationSpace.equals(compare.getDestSpace())
        );
    }
}