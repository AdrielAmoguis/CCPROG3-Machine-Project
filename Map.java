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

        // Create paths
        createCareerPath(startSpace, endSpace, 95);
        createCollegePath(startSpace, paths.get(0).spaces.get(3), 14);
        createChangeCareerPath(paths.get(0).spaces.get(26), paths.get(0).spaces.get(33), 11);
        createStartFamPath(paths.get(0).spaces.get(46), paths.get(0).spaces.get(54), 12);
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
}