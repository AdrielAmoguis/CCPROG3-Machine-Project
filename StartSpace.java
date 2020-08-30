/**
 * This class defines the StartSpace, the starting point (insertion point) of all players in the game.
 * This class inherits from the Space class.
 */
public class StartSpace extends Space
{
    /**
     * This attribute contains the collegeStart space (first space in College path)
     */
    private Space collegeStart;

    /**
     * This attribute contains the careerStart space (first space in career path)
     */
    private Space careerStart;

    /**
     * This constructor calls the superclass constructor.
     */
    public StartSpace()
    {
        super(null);
    }

    /**
     * Updates the value stored to the new value of where college starts.
     * @param space
     */
    public void setCollegeStart(Space space)
    {
        this.collegeStart = space;
    }

    /**
     * Updates the value stoed to the new value of where career starts.
     */
    public void setCareerStart(Space space)
    {
        this.careerStart = space;
    }

    /**
     * This implements the abstract event() method in the superclass.
     * This method is called when a player triggers this event.
     * This method prompts the user for the initial path, then sets that user to go to that direction.
     * @param player
     */
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
                player.doLoan(2);
                System.out.println("You chose college! You loaned $40000 from the bank.");
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