import java.util.*;

public abstract class Path 
{
    protected ArrayList<Space> spaces;
    protected Space originSpace;
    protected Space destinationSpace;
    
    public Path(Space origin, Space dest, int len)
    {
        this.originSpace = origin;
        this.destinationSpace = dest;
        this.spaces = new ArrayList<Space>(len);
        this.spaces.set(0, origin);
        this.spaces.set(spaces.size()-1, destinationSpace);
        generateSpaces();
        initSpaces();
    }

    private void initSpaces()
    {
        for (int i = 0; i < spaces.size(); i++) 
        {
            if(!(spaces.get(i) instanceof EndSpace))
            {
                spaces.get(i).setNextSpace(spaces.get(i+1));
            }
            else
                spaces.get(i).setNextSpace(null);
        }
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

    protected abstract void generateSpaces();

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