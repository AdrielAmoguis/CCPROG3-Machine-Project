public class CollegePath extends Path
{
    public final String NAME = "College Path";
    
    public CollegePath(Space origin, Space dest, int len)
    {
        super(origin, dest, len);
    }

    protected void generateSpaces()
    {
        /*
            Generation Rules:
            1. Second to the last space is a graduation space
            2. College Career Choice along the way
            3. The rest are orange spaces
        */
        for(int i = 1; i < getPathLen(); i++)
        {
            if(spaces.get(i) == null)
            {
                if(i == getPathLen()-2)
                    spaces.set(i, new MagentaSpace(this, 6));
                else if(i == getPathLen()/2)
                    spaces.set(i, new MagentaSpace(this, 0));
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
        
        CollegePath compare = (CollegePath) obj;
        if(this.originSpace.equals(compare.getOriginSpace()) && this.destinationSpace.equals(compare.getDestSpace()))
            return true;
        return false;
    }
}