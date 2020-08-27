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
        String options[] = new String[2];
        options[0] = new String("Take the Career Path");
        options[1] = new String("Take the College Path");
        int choice = player.decision(options);
        if(choice == 0)
            player.setSpace(careerStart);
        else
            player.setSpace(collegeStart);
    }

    @Override
    public String toString()
    {
        return new String(
            "[StartSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}