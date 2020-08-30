import java.util.*;

/**
 * This class is a container for all spaces that belong to the career path.
 * This path is responsible for generating the sequence of spaces that constitute the career path,
 * as defined in the Machine Project specifications and as designed by the program author.
 * This class inherits from the Path class.
 */
public class CareerPath extends Path
{
    /**
     * This constructor calls the super constructor and initializes the instance attributes in the superclass.
     */
    public CareerPath(Space origin, Space dest, int len, ArrayList<Player> players)
    {
        super("Career Path", origin, dest, len, players);
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
                Follow the predetermined map
        */
        spaces.add(this.originSpace);
        spaces.add(new MagentaSpace(this, 7, players));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 3, players));
        for(int i = 0; i < 4; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 1));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new BlueSpace(this));
        spaces.add(new OrangeSpace(this));
        // JUNCTION (Change Career Choice)
        JunctionSpace junction = new JunctionSpace(this);
        Space junctionLeft = new OrangeSpace(this);
        junction.setLeftSpace(junctionLeft);
        spaces.add(junction);
        spaces.add(junctionLeft);
        // End of junction
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 1));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new BlueSpace(this));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 1, players));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 1));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new BlueSpace(this));
        spaces.add(new OrangeSpace(this));
        // JUNCTION (Start a Family)
        junction = new JunctionSpace(this);
        junctionLeft = new OrangeSpace(this);
        junction.setLeftSpace(junctionLeft);
        spaces.add(junction);
        spaces.add(junctionLeft);
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 1));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new BlueSpace(this));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 2, players));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 3, players));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 1));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        spaces.add(new OrangeSpace(this));
        spaces.add(new BlueSpace(this));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 4, players));
        spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 5, players));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 5; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 2, players));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new GreenSpace(this, 0));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new BlueSpace(this));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        // MAKE SURE TO ADD THE LAST SPACE
        spaces.add(this.destinationSpace);

        // Initialize second to the last space
        spaces.get(spaces.size()-2).setNextSpace(spaces.get(spaces.size()-1));
    }

    @Override
    public boolean equals(Object obj)
    {
        CareerPath compare = (CareerPath) obj;
        if(compare.getName().equals(this.getName()))
            return true;
        return false;
    }
}