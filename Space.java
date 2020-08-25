import java.util.*;

public abstract class Space 
{
    protected static int count = 0;
    private Path path;

    public final int ID;
    private ArrayList<Player> players;

    public Space(Path path)
    {  
        Space.count++;
        this.ID = Space.count;
        this.path = path;
        players = new ArrayList<Player>();
    }

    public Space(Player[] players, Path path)
    {
        this(path);
        for (Player player : players) {
            this.players.add(player);
        }
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

    @Override
    public String toString()
    {
        return new String(
            "[Space " + String.valueOf(this.ID) + "] Players = " + players.toString()
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