public class MagentaSpace extends Space
{
    public final int TYPE;
    
    public MagentaSpace(Path path, int type)
    {
        super(path);
        TYPE = type;
    }

    public String getType()
    {
        switch(TYPE)
        {
            case 0: return "College Career Choice";
            case 1: return "Job Search";
            case 2: return "Buy House";
            case 3: return "Get Married";
            case 4: return "Have Baby";
            case 5: return "Have Twins";
            case 6: return "Graduation";
            case 7: return "Career Choice";
        }

        return "INVALID";
    }

    protected void event(Player player)
    {
        switch(TYPE)
        {
            case 0: collegeCareerChoice(player); break;
            case 1: jobSearch(player); break;
            case 2: buyHouse(player); break;
            case 3: getMarried(player); break;
            case 4: haveBaby(player); break;
            case 5: haveTwins(player); break;
            case 6: graduate(player); break;
            case 7: careerChoice(player); break;
        }
    }

    // EVENT FUNCTIONS
    private void collegeCareerChoice(Player player)
    {

    }

    private void jobSearch(Player player)
    {

    }

    private void buyHouse(Player player)
    {

    }

    private void getMarried(Player player)
    {

    }
    
    private void haveBaby(Player player)
    {

    }

    private void haveTwins(Player player)
    {

    }

    private void junction(Player player)
    {
        
    }

    private void graduate(Player player)
    {
        
    }

    private void careerChoice(Player player)
    {

    }

    @Override
    public String toString()
    {
        return new String(
            "[MagentaSpace (" + this.getType() + ") " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}