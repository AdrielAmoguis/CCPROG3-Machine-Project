public class CareerCard extends Card
{
    public final String NAME;
    public final boolean DEGREE;

    private int maxRaise;

    public CareerCard(String name, boolean degree, int maxRaise)
    {
        this.NAME = name;
        this.DEGREE = degree;
        this.maxRaise = maxRaise;
    }

    public void event(Player player)
    {
        
    }
}