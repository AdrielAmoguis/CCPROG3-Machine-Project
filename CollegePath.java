import java.util.*;

/**
 * This class is a container for all spaces that belong to the college path.
 * This path is responsible for generating the sequence of spaces that constitute the college path,
 * as defined in the Machine Project specifications and as designed by the program author.
 * This class inherits from the Path class.
 */
public class CollegePath extends Path
{
    /**
     * This constructor calls the super constructor and initializes the instance attributes in the superclass.
     */
    public CollegePath(Space origin, Space dest, int len, ArrayList<Player> players)
    {
        super("College Path", origin, dest, len, players);
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
            1. Second to the last space is a graduation space
            2. College Career Choice along the way
            3. The rest are orange spaces
        */
        spaces.add(this.originSpace);
        for(int i = 0; i < 4; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 6, players));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 0, players));
        spaces.add(this.destinationSpace);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        
        CollegePath compare = (CollegePath) obj;
        if(this.originSpace.equals(compare.getOriginSpace()) && this.destinationSpace.equals(compare.getDestSpace()))
            return true;
        return false;
    }
}