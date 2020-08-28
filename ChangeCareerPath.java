import java.util.*;

public class ChangeCareerPath extends Path
{
    public ChangeCareerPath(Space origin, Space dest, int len, ArrayList<Player> players)
    {
        super("Change Career Path", origin, dest, len, players);
    }

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