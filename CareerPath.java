import java.util.*;

public class CareerPath extends Path
{
    public final String NAME = new String("Career Path");

    public CareerPath(Space origin, Space dest, int len)
    {
        super(origin, dest, len);
        generateSpaces();
    }

    private void generateSpaces()
    {
        // Generate green spaces every len/15 spaces
        int factor = getPathLen()/15;
        for(int i = 1; i < getPathLen(); i += factor)
        {
            spaces.set(i, new GreenSpace(this, ThatsLife.rollNumber()));
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        CareerPath compare = (CareerPath) obj;
        if(compare.NAME.equals(this.NAME))
            return true;
        return false;
    }
}