import java.util.*;

/**
 * Main Map class. This class holds all the paths and basically is the structure of the game.
 */
public class Map 
{
    private ArrayList<Path> paths;
    private StartSpace startSpace;
    private EndSpace endSpace;

    public Map(ArrayList<Player> players)
    {
        paths = new ArrayList<Path>();

        // Create the EndSpace
        endSpace = new EndSpace();
        startSpace = new StartSpace();

        // Create Career & College paths
        createCareerPath(startSpace, endSpace, 112, players);
        createCollegePath(startSpace, paths.get(0).getSpace(6), 12, players);
        // Initialize startSpace
        startSpace.setCareerStart(paths.get(0).getSpace(1));
        startSpace.setCollegeStart(paths.get(1).getSpace(1));
        // Create the StartFamilyPath
        createStartFamPath(paths.get(0).getSpace(54), paths.get(0).getSpace(73), 11, players);
        // Create Change Career Path
        createChangeCareerPath(paths.get(0).getSpace(21), paths.get(0).getSpace(40), 11, players);
    }

    private void createCareerPath(Space startSpace, Space endSpace, int len, ArrayList<Player> players)
    {
        paths.add(new CareerPath(startSpace, endSpace, len, players));
    }

    private void createCollegePath(Space startSpace, Space dest, int len, ArrayList<Player> players)
    {
        paths.add(new CollegePath(startSpace, dest, len, players));
    }

    private void createStartFamPath(Space origin, Space dest, int len, ArrayList<Player> players)
    {
        paths.add(new StartFamilyPath(origin, dest, len, players));
    }

    private void createChangeCareerPath(Space origin, Space dest, int len, ArrayList<Player> players)
    {
        paths.add(new ChangeCareerPath(origin, dest, len, players));
    }

    public Path getPath(int index)
    {
        return this.paths.get(index);
    }

    public StartSpace getStartSpace()
    {
        return this.startSpace;
    }

    public EndSpace getEndSpace()
    {
        return this.endSpace;
    }
}