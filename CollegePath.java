import java.util.*;

public class CollegePath extends Path
{
    public CollegePath(Space origin, Space dest, int len, ArrayList<Player> players)
    {
        super("College Path", origin, dest, len, players);
    }

    protected void generateSpaces(ArrayList<Player> players)
    {
        /*
            Generation Rules:
            1. Second to the last space is a graduation space
            2. College Career Choice along the way
            3. The rest are orange spaces
        */
        spaces.add(this.originSpace);
        for(int i = 0; i < 4; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 6, players));
        for(int i = 0; i < 3; i++)
            spaces.add(new OrangeSpace(this));
        spaces.add(new MagentaSpace(this, 0, players));
        spaces.add(this.destinationSpace);
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