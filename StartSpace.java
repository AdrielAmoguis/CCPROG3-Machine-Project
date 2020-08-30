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
        System.out.println("Welcome to the game!");
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
                this.setNextSpace(careerStart);
                players.remove(player);
                player.move(player.spin());
                break;
            }
            else if(choice == 1)
            {
                this.setNextSpace(collegeStart);
                players.remove(player);
                player.move(player.spin());
                break;
            }
        }
        
    }

    @Override
    public String toString()
    {
        return new String(
            "[StartSpace " + String.valueOf(this.ID) + "]"
        );
    }
}