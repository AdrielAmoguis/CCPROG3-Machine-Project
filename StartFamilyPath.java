public class StartFamilyPath extends Path
{
    public final String NAME = "Start a Family Path";    

    public StartFamilyPath(Space origin, Space dest, int len)
    {
        super(origin, dest, len);
    }

    protected void generateSpaces()
    {
        /*
            Generation Rules:
            1. Get Married
            2. Buy a House
            3. Have Baby or Have Twins
            4. Blue Space
            5. Orange Space
        */

        for(int i = 1; i < getPathLen(); i++)
        {
            if(spaces.get(i) == null)
            {
                if(i == 1)
                    spaces.set(i, new MagentaSpace(this, 3));
                else if(i == getPathLen()/2)
                    spaces.set(i, new MagentaSpace(this, 2));
                else if(i == getPathLen()/2 + getPathLen()/4)
                    spaces.set(i, new MagentaSpace(this, 4 + (ThatsLife.rollNumber()%2)));
                else if(i == getPathLen()-2)
                    spaces.set(i, new BlueSpace(this));
                else
                    spaces.set(i, new OrangeSpace(this));
            }
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        
        StartFamilyPath compare = (StartFamilyPath) obj;
        return (
            compare.NAME.equals(this.NAME)
        );
    }
}