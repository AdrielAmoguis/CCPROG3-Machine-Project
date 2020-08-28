import java.util.*;

public class CareerPath extends Path
{
    public CareerPath(Space origin, Space dest, int len, ArrayList<Player> players)
    {
        super("Career Path", origin, dest, len, players);
    }

    protected void generateSpaces(ArrayList<Player> players)
    {
        /*
            Generation Rules:
                Follow the predetermined map
        */
        spaces.add(this.originSpace);
        for(int i = 0; i < 3; i++)
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
        spaces.add(new MagentaSpace(this, 5, players));
        spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 6, players));
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