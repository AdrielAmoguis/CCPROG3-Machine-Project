public class CareerPath extends Path
{
    public final String NAME = new String("Career Path");

    public CareerPath(Space origin, Space dest, int len)
    {
        super(origin, dest, len);
    }

    protected void generateSpaces()
    {
        /*
            Generation Rules:
            1. Green spaces are generated every pathLen/15 spaces.
            2. There is a GetMarried space at space = 15
            3. The rest are orange spaces
        */
        int factor = getPathLen()/15;
        for(int i = 1; i < getPathLen(); i++)
        {
            if(spaces.get(i) == null)
            {
                // DEFINE JUNCTIONS
                if(i == 26)
                    spaces.set(i, new MagentaSpace(this, 6));
                else if(i == 46)
                    spaces.set(i, new MagentaSpace(this, 6));
                if(i % factor == 0)
                    spaces.set(i, new GreenSpace(this, ThatsLife.rollNumber()));
                else if(i == 15)
                    spaces.set(15, new MagentaSpace(this, 3));
                else
                    spaces.set(i, new OrangeSpace(this));
            }
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