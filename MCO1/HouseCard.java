/**
 * This class holds the data for the houses in the game.
 * This class inherits from the Card class.
 */
public class HouseCard extends Card
{
    /**
     * This attribute stores the name of the house.
     */
    public final String NAME;

    /**
     * This attribute stores the buy price of the house.
     */
    public final double BUY;

    /**
     * This attribute stores the sell price of the house.
     */
    public final double SELL;

    /**
     * This constructor initializes this instance's attributes as given by the constructor parameters.
     * @param name : String - house name
     * @param buyPrice : double - house buy price
     * @param sellPrice : double - house sell price
     */
    public HouseCard(String name, double buyPrice, double sellPrice)
    {
        this.NAME = name;
        this.BUY = buyPrice;
        this.SELL = sellPrice;
    }

    /**
     * This method is unimplemented since there is no event to be done when the player draws this card.
     */
    public void event(Player player) {}

    @Override
    public String toString()
    {
        return (
            "[HOUSE] " + this.NAME + " | BUY: " + String.valueOf(this.BUY) + "; SELL: " + String.valueOf(this.SELL)
        );
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        HouseCard compare = (HouseCard) obj;
        return (
            this.NAME.equals(compare.NAME) &&
            this == compare
        );
    }
}