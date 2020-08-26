public class HouseCard extends Card
{
    public final String NAME;
    public final double BUY;
    public final double SELL;

    public HouseCard(String name, double buyPrice, double sellPrice)
    {
        this.NAME = name;
        this.BUY = buyPrice;
        this.SELL = sellPrice;
    }

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