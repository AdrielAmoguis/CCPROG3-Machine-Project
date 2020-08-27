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
        // SET JUNCTION
        Space space = new MagentaSpace(this, 3);
        ((JunctionSpace) this.originSpace).setRightSpace(space);
        spaces.add(this.originSpace);
        spaces.add(space);
        //
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 2));
        for(int i = 0; i < 2; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 4));
        spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 5));
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
            compare.NAME.equals(this.NAME)
        );
    }
}