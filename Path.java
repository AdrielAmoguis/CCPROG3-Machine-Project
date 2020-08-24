import java.util.*;

public class Path 
{
    protected ArrayList<Space> spaces;
    protected Space originSpace;
    protected Space destinationSpace;
    
    public Path(Space origin, Space dest, int len)
    {
        this.originSpace = origin;
        this.destinationSpace = dest;
        this.spaces = new ArrayList<Space>(len);
    }

    public int getPathLen()
    {
        return spaces.size();
    }

    public Space getSpace(int id)
    {
        Space result = null;
        for (Space keySpace : spaces) 
        {
            if(keySpace.ID == id)
                result = keySpace;
        }

        return result;
    }

    public Space getOriginSpace()
    {
        return this.originSpace;
    }

    public Space getDestSpace()
    {
        return this.destinationSpace;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        Path compare = (Path) obj;
        
        return (
            this.originSpace.equals(compare.getOriginSpace()) &&
            this.destinationSpace.equals(compare.getDestSpace())
        );
    }
}