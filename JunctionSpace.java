public class JunctionSpace extends MagentaSpace
{
    private Space leftSpace;
    private Space rightSpace;

    public JunctionSpace(Path path)
    {
        super(path, -1);
    }

    public Space getLeftSpace()
    {
        return this.leftSpace;
    }

    public Space getRightSpace()
    {
        return this.rightSpace;
    }

    public void setLeftSpace(Space space)
    {
        this.leftSpace = space;
    }

    public void setRightSpace(Space space)
    {
        this.rightSpace = space;
    }

    protected void event(Player player)
    {
        setPlayerPath(player);
    }

    private void setPlayerPath(Player player)
    {
        
    }

    @Override
    public String toString()
    {
        return new String(
            "[JunctionSpace (" + this.leftSpace.toString() + ";" + this.rightSpace.toString() + ")" + String.valueOf(this.ID) + "] Players = " + players.toString()
        );
    }
}