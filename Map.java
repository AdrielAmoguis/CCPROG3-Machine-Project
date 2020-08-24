import java.util.*;

/**
 * Main Map class. This class holds all the paths and basically is the structure of the game.
 */
public class Map 
{
    private ArrayList<Path> paths;
    private Space startSpace;
    private Space endSpace;

    public Map()
    {
        paths = new ArrayList<Path>();
        startSpace = new StartSpace();
        endSpace = new EndSpace();
    }
}