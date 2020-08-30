import java.util.*;

public abstract class Space 
{
    protected static int count = 0;
    private Path path;

    public final int ID;
    protected ArrayList<Player> players;

    private Space nextSpace;

    public Space(Path path)
    {  
        Space.count++;
        this.ID = Space.count;
        this.path = path;
        players = new ArrayList<Player>();
    }

    public void playerLand(Player player)
    {
        this.players.add(player);   
        event(player);     
    }

    public void playerLeave(Player player)
    {
        this.players.remove(player);
    }

    // ABSTRACT METHOD
    protected abstract void event(Player player);

    public void setNextSpace(Space space)
    {
        this.nextSpace = space;
    }

    public Space getNextSpace()
    {
        return this.nextSpace;
    }

    public int getNoOfPlayers()
    {
        return this.players.size();
    }

    public Path getPath()
    {
        return this.path;
    }

    @Override
    public String toString()
    {
        return new String(
            "[Space " + String.valueOf(this.ID) + "]"
        );
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        Space compare = (Space) obj;
        
        return (
            this.ID == compare.ID
        );
    }
}