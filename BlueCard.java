public class BlueCard extends Card
{
    public final String NAME;
    
    private String matchingCareer;

    public BlueCard(String name, String matchingCareer)
    {
        this.NAME = name;
        this.matchingCareer = matchingCareer;
    }

    public String getCareer()
    {
        return matchingCareer;
    }

    public void event(Player player)
    {
        if (!isMatch(player))
            return;

        switch(this.matchingCareer)
        {
            case "Lawyer": lawsuit(player); break;
            case "Accountant": salaryTaxDue(player); break;
            case "Computer Consultant": computerRepair(player); break;
            case "Doctor": skiAccident(player); break; 
            case "Server": tipTheServer(player); break;
            case "Racecar Driver": f1Race(player); break;
            case "Athlete": worldCup(player); break;
        }
    }

    private boolean isMatch(Player player)
    {
        if(this.matchingCareer.equals(player.getCareer()))
            return true;
        return false;
    }

    private void lawsuit(Player player)
    {

    }

    private void salaryTaxDue(Player player)
    {

    }

    private void tipTheServer(Player player)
    {

    }

    private void skiAccident(Player player)
    {

    }

    private void computerRepair(Player player)
    {

    }

    private void worldCup(Player player)
    {

    }

    private void f1Race(Player player)
    {

    }

    @Override
    public String toString()
    {
        return (
            "[Blue Card] " + this.NAME + ", Matches " + this.matchingCareer
        );
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        BlueCard compare = (BlueCard) obj;

        return (
            compare.NAME.equals(this.NAME) && compare.matchingCareer.equals(this.matchingCareer)
        );
    }
}