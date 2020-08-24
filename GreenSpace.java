public class GreenSpace extends Space
{
    public final int TYPE;

    public GreenSpace(Path path, int type)
    {
        super(path);
        TYPE = type % 10;
    }

    public String getType()
    {
        return TYPE < 8 ? "Pay Day" : "Pay Raise";
    }

    @Override
    protected void event(Player player)
    {
        this.playerLand(player);

        if(getType().equals("Pay Day"))
            payDay(player);
        else
            payRaise(player);
    }

    private void payDay(Player player)
    {
        player.credit()
    }

}