public class JunctionSpace extends MagentaSpace
{
    private Space leftSpace;
    private Space rightSpace;

    public JunctionSpace(Path path)
    {
        super(path, -1, null);
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
        String options = new String();
        options += "You have hit a junction. Choose a path:\n";
        options += "[1] " + leftSpace.getPath().getName() + "\n";
        options += "[2] " + rightSpace.getPath().getName() + "\n";
        options += "Your Choice: ";
        int choice = 0;
        while(true)
        {
            choice = player.decision(options);
            if(choice > 0 && choice <= 2)
                break;
        }
        
        if(choice == 1)
        {
            // Left path
            // Roll again
            int spin = player.spin();
            this.setNextSpace(leftSpace);
            player.move(spin);
        }
        else
        {
            // Right path
            // Roll again
            int spin = player.spin();
            this.setNextSpace(rightSpace);
            player.move(spin);
        }
    }

    @Override
    public String toString()
    {
        return new String(
            "[JunctionSpace (" + this.leftSpace.toString() + ";" + this.rightSpace.toString() + ")" + String.valueOf(this.ID) + "]"
        );
    }
}