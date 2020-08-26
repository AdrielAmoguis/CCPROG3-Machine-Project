public class StartSpace extends Space
{
    private Space collegeStart;
    private Space careerStart;

    public StartSpace(Space career, Space college)
    {
        super(null);
        this.collegeStart = college;
        this.careerStart = career;
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
}