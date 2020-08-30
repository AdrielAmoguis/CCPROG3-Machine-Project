public class GreenSpace extends Space
{
    public final int TYPE;

    public GreenSpace(Path path, int type)
    {
        super(path);
        if(type==0)
            TYPE = 0;
        else
            TYPE = 1;
    }

    public String getType()
    {
        return TYPE == 0 ? "Pay Day" : "Pay Raise";
    }

    protected void event(Player player)
    {
        // Pay day
        if(this.TYPE == 0)
        {
            player.credit(player.getSalary().getSalary(), "What day is it? It's Pay Day!");
        }
        else // Pay Raise
        {
            player.getSalary().payRaise();
        }
    }

    @Override
    public String toString()
    {
        return new String(
            "[GreenSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}