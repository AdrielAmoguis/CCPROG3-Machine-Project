public class mapTestDriver 
{
    public static void main(String[] args)
    {
        ThatsLife game = new ThatsLife(1);
        // Test the Career Path
        System.out.println("================================ CAREER PATH ================================");
        testCareerPath(game);
        System.out.println("================================ COLLEGE PATH ================================");
        testCollegePath(game);
        System.out.println("================================ CHANGE CAREER PATH ================================");
        testChangeCareerPath(game);
        System.out.println("================================ START FAMILY PATH ================================");
        testStartFamilyPath(game);

        ThatsLife.kb.close();
    }

    public static void testCareerPath(ThatsLife game)
    {
        Map map = game.getMap();
        CareerPath careerPath = (CareerPath)map.getPath(0);
        for(int i = 0; i < 112; i++)
        {
            System.out.println(careerPath.getSpace(i).toString());
        }
    }

    public static void testCollegePath(ThatsLife game)
    {
        Map map = game.getMap();
        CollegePath collegePath = (CollegePath)map.getPath(1);
        for(int i = 0; i < 11; i++)
        {
            System.out.println(collegePath.getSpace(i).toString());
        }
    }

    public static void testChangeCareerPath(ThatsLife game)
    {
        Map map = game.getMap();
        ChangeCareerPath changePath = (ChangeCareerPath)map.getPath(3);
        for(int i = 0; i < 11; i++)
        {
            System.out.println(changePath.getSpace(i).toString());
        }
    }

    public static void testStartFamilyPath(ThatsLife game)
    {
        Map map = game.getMap();
        StartFamilyPath famPath = (StartFamilyPath)map.getPath(2);
        for(int i = 0; i < 11; i++)
        {
            System.out.println(famPath.getSpace(i).toString());
        }
    }
}