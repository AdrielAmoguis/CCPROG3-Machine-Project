public class JunctionSpace extends MagentaSpace
{
    private Space leftSpace;
    private Space rightSpace;

    public JunctionSpace(Path path, Space left, Space right)
    {
        super(path, -1);
        leftSpace = left;
        rightSpace = right;
    }

    protected void event(Player player)
    {
        setPlayerPath(player);
    }

    private void setPlayerPath(Player player)
    {
        
    }
}