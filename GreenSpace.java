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

    @Override
    protected void event(Player player)
    {
    }

    @Override
    public String toString()
    {
        return new String(
            "[GreenSpace " + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}