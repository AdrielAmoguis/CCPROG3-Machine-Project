/**
 * This class defines the CareerCard, which inherits from the Card class.
 * This card carries the information about a player's career.
 */
public class CareerCard extends Card
{
    /**
     * This attribute holds the name of the career
     */
    public final String NAME;

    /**
     * This attribute holds the classification of the career, if it needs a degree or not.
     */
    public final boolean DEGREE;

    /**
     * This attribute holds the career's maximum number of times it can have a Pay Raise.
     * This value is randomly generated based on the career given, which is based from the
     * Machine Project specifications.
     */
    private int maxRaise;

    /**
     * This constructor initializes this instance's attributes based on values instantiated outside
     * this class (in the career deck).
     * @param name - The career name
     * @param degree - Degree requirement
     * @param maxRaise - Maximum number of pay raises
     */
    public CareerCard(String name, boolean degree, int maxRaise)
    {
        this.NAME = name;
        this.DEGREE = degree;
        this.maxRaise = maxRaise;
    }

    /**
     * This is an unimplemented method for this class as there is no event to be executed when this card is drawn.
     */
    public void event(Player player)
    {}

    /**
     * This getter method returns the career's maximum number of pay raises.
     * @return maxPayRaise : int
     */
    public int getMaxRaise()
    {
        return this.maxRaise;
    }

    @Override
    public String toString()
    {
        return (
            "[Career] " + this.NAME + " | " + (this.DEGREE ? "Degree Required" : "Degree Not Required") + 
            " | MaxRaise = " + String.valueOf(maxRaise)
        );
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;

        CareerCard compare = (CareerCard) obj;
        return compare.NAME.equals(this.NAME) && compare.maxRaise == this.maxRaise;
    }
}