import java.util.*;

/**
 * This class is a container for all spaces that belong to the change career path.
 * This path is responsible for generating the sequence of spaces that constitute the change career path,
 * as defined in the Machine Project specifications and as designed by the program author.
 * This class inherits from the Path class.
 */
public class ChangeCareerPath extends Path
{
    /**
     * This constructor calls the super constructor and initializes the instance attributes in the superclass.
     * @param origin - the first space on this path
     * @param dest - the last space on this path
     * @param players - the array of players for use to initializes all spaces
     */
    public ChangeCareerPath(Space origin, Space dest, ArrayList<Player> players)
    {
        super("Change Career Path", origin, dest, players);
    }

    /**
     * This method implements the abstract method generateSpaces() found in the Path class.
     * It generates a predetermined sequence of spaces on the path as designed by the program author
     * based on the Machine Project specifications.
     * @param players - ArrayList of players to be passed on to the MagentaSpaces.
     */
    protected void generateSpaces(ArrayList<Player> players)
    {
        /*
            Generation Rules:
            1. One career choice path (after green space)
            2. One pay day, one pay raise
            3. One blue Space
            4. The rest are orange spaces
        */
        // SET JUNCTION
        Space space = new MagentaSpace(this, 7, players);
        ((JunctionSpace) this.originSpace).setRightSpace(space);
        spaces.add(this.originSpace);
        spaces.add(space);
        //
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 1));
        spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        spaces.add(new BlueSpace(this));
        spaces.add(this.destinationSpace);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        ChangeCareerPath compare = (ChangeCareerPath) obj;
        return compare.getName().equals(this.getName());
    }
}