public class ActionCard extends Card
{
    public final String NAME;
    public final int TYPE;
    
    public ActionCard(int type)
    {
        TYPE = type;
        NAME = generateName();
    }

    private String generateName()
    {
        switch(TYPE)
        {
            case 0:
                switch(ThatsLife.rollNumber() % 6)
                {
                    case 1: return "Tax Refund";
                    case 2: return "Sell an Item";
                    case 3: return "Bonus Payday";
                    case 4: return "Setup School";
                    case 5: return "Write a Book";
                } break;
            case 1:
                switch(ThatsLife.rollNumber() % 7)
                {
                    case 1: return "Buy an Item";
                    case 2: return "Visit a Place";
                    case 3: return "Hiking";
                    case 4: return "Watch a Show";
                    case 5: return "Win a Competition";
                    case 6: return "Traffic Violation";
                } break;
            case 2:
                switch(ThatsLife.rollNumber() % 3)
                {
                    case 1: return "Lawsuit";
                    case 2: return "Christmas Bonus";
                } break;
            case 3:
                switch(ThatsLife.rollNumber() % 3)
                {
                    case 1: return "File a Lawsuit";
                    case 2: return "It's your Birthday";
                } break;
        }
        return null;
    }

    public void event(Player player)
    {
        switch(TYPE)
        {
            case 1: collectFromBank(); break;
            case 2: payTheBank(); break;
            case 3: payThePlayer(); break;
            case 4: collectFromPlayer(); break;
        }
    }

    private void collectFromBank()
    {

    }

    private void payTheBank()
    {

    }

    private void payThePlayer()
    {

    }

    private void collectFromPlayer()
    {

    }

    @Override
    public String toString()
    {
        return (
            "[ActionCard] " + this.NAME + ""
        );
    }
}