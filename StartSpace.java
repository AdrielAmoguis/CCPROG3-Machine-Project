public class StartSpace extends Space
{
    private Space collegeStart;
    private Space careerStart;

    public StartSpace()
    {
        super(null);
    }

    public void setCollegeStart(Space space)
    {
        this.collegeStart = space;
    }

    public void setCareerStart(Space space)
    {
        this.careerStart = space;
    }

    public void event(Player player)
    {
        while(true)
        {
            String options = new String("\n[" + player.getName() + "]\n\n");
            options += "Pick your initial path:\n";
            options += "[1] Take the Career Path\n";
            options += "[2] Take the College Path\n";
            options += "Your Choice: ";
            int choice = player.decision(options) - 1;
            if(choice == 0)
            {
                player.setSpace(careerStart);
                player.getSpace().playerLand(player);
                players.remove(player);
                break;
            }
            else if(choice == 1)
            {
                player.setSpace(collegeStart);
                player.getSpace().playerLand(player);
                players.remove(player);
                break;
            }
        }
        
    }

    @Override
    public String toString()
    {
        return new String(
            "[StartSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}