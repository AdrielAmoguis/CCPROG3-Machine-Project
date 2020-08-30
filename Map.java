import java.util.*;

/**
 * Main Map class. This class instantiates and holds all the paths and is the structure of the game.
 * The game map is not randomly generated. It follows a design by the program author. Only space events
 * are randomized.
 */
public class Map 
{
    /**
     * This attribute stores all the paths for the game.
     */
    private ArrayList<Path> paths;

    /**
     * This attribute stores the very first space (player insertion point) of the game.
     */
    private StartSpace startSpace;

    /**
     * This attribute stores the very last space (retirement space) of the game.
     */
    private EndSpace endSpace;

    /**
     * This constructor instantiates all of the paths by calling other private methods within this class.
     * This constructor also instantiates both the start and end spaces.
     * It takes the players parameter of ArrayList<Player> and uses it to initialize the paths and is not stored within this instance.
     * @param players
     */
    public Map(ArrayList<Player> players)
    {
        paths = new ArrayList<Path>();

        // Create the EndSpace
        endSpace = new EndSpace();
        startSpace = new StartSpace();

        // Create Career & College paths
        createCareerPath(startSpace, endSpace, players);
        createCollegePath(startSpace, paths.get(0).getSpace(6), players);
        // Initialize startSpace
        startSpace.setCareerStart(paths.get(0).getSpace(1));
        startSpace.setCollegeStart(paths.get(1).getSpace(1));
        // Create the StartFamilyPath
        createStartFamPath(paths.get(0).getSpace(54), paths.get(0).getSpace(73), players);
        // Create Change Career Path
        createChangeCareerPath(paths.get(0).getSpace(21), paths.get(0).getSpace(40), players);
    }

    private void createCareerPath(Space startSpace, Space endSpace, ArrayList<Player> players)
    {
        paths.add(new CareerPath(startSpace, endSpace, players));
    }

    private void createCollegePath(Space startSpace, Space dest, ArrayList<Player> players)
    {
        paths.add(new CollegePath(startSpace, dest, players));
    }

    private void createStartFamPath(Space origin, Space dest, ArrayList<Player> players)
    {
        paths.add(new StartFamilyPath(origin, dest, players));
    }

    private void createChangeCareerPath(Space origin, Space dest, ArrayList<Player> players)
    {
        paths.add(new ChangeCareerPath(origin, dest, players));
    }

    /**
     * This getter method returns the path instance given an index of the paths ArrayList.
     * @param index
     * @return Path
     */
    public Path getPath(int index)
    {
        return this.paths.get(index);
    }

    /**
     * This getter method returns the instance of the StartSpace
     * @return startSpace : StartSpace
     */
    public StartSpace getStartSpace()
    {
        return this.startSpace;
    }

    /**
     * This getter method returns the instance of the EndSpace
     * @return endSpace : EndSpace
     */
    public EndSpace getEndSpace()
    {
        return this.endSpace;
    }

    /**
     * This method converts the entire map (all paths) into their string representation and returns it.
     * @return mapString : String
     */
    public String getMapDisplayString()
    {
        String mainString = new String("----=====| MAP |=====----\n");

        for(Path path : paths)
        {
            mainString += path.getName() + "\n\n";
            for(int i = 0; i < path.getPathLen(); i++)
            {
                mainString += "[" + String.valueOf(i) + "] " + path.getSpace(i).toString() + "\n"; 
            }
            mainString += "---------------------------\n\n";
        }

        return mainString;
    }
}