import java.util.*;

public class StartFamilyPath extends Path
{
    public StartFamilyPath(Space origin, Space dest, int len, ArrayList<Player> players)
    {
        super("Start a Family Path", origin, dest, len, players);
    }

    protected void generateSpaces(ArrayList<Player> players)
    {
        /*
            Generation Rules:
            1. Get Married
            2. Buy a House
            3. Have Baby or Have Twins
            4. Blue Space
            5. Orange Space
        */
        
        // SET JUNCTION
        Space space = new MagentaSpace(this, 3, players);
        ((JunctionSpace) this.originSpace).setRightSpace(space);
        spaces.add(this.originSpace);
        spaces.add(space);
        //
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 2, players));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 4, players));
        spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 5, players));
        spaces.add(new BlueSpace(this));
        spaces.add(this.destinationSpace);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        
        StartFamilyPath compare = (StartFamilyPath) obj;
        return (
            compare.getName().equals(this.getName())
        );
    }
}