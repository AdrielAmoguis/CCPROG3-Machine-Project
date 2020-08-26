public class ChangeCareerPath extends Path
{
    public final String NAME = "Change Career Path";

    public ChangeCareerPath(Space origin, Space dest, int len)
    {
        super(origin, dest, len);
    }

    protected void generateSpaces()
    {
        /*
            Generation Rules:
            1. One career choice path (after green space)
            2. One pay day, one pay raise
            3. One blue Space
            4. The rest are orange spaces
        */
        for(int i = 1; i < getPathLen(); i++)
        {
            if(spaces.get(i) == null)
            {
                if(i == 2)
                    spaces.set(i, new GreenSpace(this, 1));
                else if(i == 4)
                    spaces.set(i, new GreenSpace(this, 9));
                else if(i == getPathLen()/2)
                    spaces.set(i, new MagentaSpace(this, 7));
                else if(i == getPathLen()/4 + getPathLen()/2)
                    spaces.set(i, new BlueSpace(this));
                else
                    spaces.set(i, new OrangeSpace(this));
            }
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        ChangeCareerPath compare = (ChangeCareerPath) obj;
        return compare.NAME.equals(this.NAME);
    }
}