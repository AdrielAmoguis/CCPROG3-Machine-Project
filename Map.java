import java.util.*;

/**
 * Main Map class. This class holds all the paths and basically is the structure of the game.
 */
public class Map 
{
    private ArrayList<Path> paths;
    private StartSpace startSpace;
    private EndSpace endSpace;

    public Map()
    {
        paths = new ArrayList<Path>();

        // Create the EndSpace
        endSpace = new EndSpace();
        startSpace = new StartSpace();

        // Create Career & College paths
        createCareerPath(startSpace, endSpace, 112);
        createCollegePath(startSpace, paths.get(0).getSpace(6), 12);
        // Initialize startSpace
        startSpace.setCareerStart(paths.get(0).getSpace(1));
        startSpace.setCollegeStart(paths.get(1).getSpace(1));
        // Create the StartFamilyPath
        createStartFamPath(paths.get(0).getSpace(54), paths.get(0).getSpace(73), 11);
        // Create Change Career Path
        createChangeCareerPath(paths.get(0).getSpace(21), paths.get(0).getSpace(40), 11);
    }

    private void createCareerPath(Space startSpace, Space endSpace, int len)
    {
        paths.add(new CareerPath(startSpace, endSpace, len));
    }

    private void createCollegePath(Space startSpace, Space dest, int len)
    {
        paths.add(new CollegePath(startSpace, dest, len));
    }

    private void createStartFamPath(Space origin, Space dest, int len)
    {
        paths.add(new StartFamilyPath(origin, dest, len));
    }

    private void createChangeCareerPath(Space origin, Space dest, int len)
    {
        paths.add(new ChangeCareerPath(origin, dest, len));
    }

    public Path getPath(int index)
    {
        return this.paths.get(index);
    }
}