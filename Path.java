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
        generateSpaces();
        initSpaces();
    }

    private void initSpaces()
    {
        for (int i = 0; i < spaces.size(); i++) 
        {
            if(i < spaces.size()-1)
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

    public Space getSpace(int index)
    {
        return this.spaces.get(index);
    }

    public Space getOriginSpace()
    {
        return this.originSpace;
    }

    public Space getDestSpace()
    {
        return this.destinationSpace;
    }

    public void setStartSpace(Space space)
    {
        this.originSpace = space;
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