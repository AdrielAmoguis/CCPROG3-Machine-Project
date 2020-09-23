package thatslife;
import java.util.*;
/**
 * This class defines the ActionCard object.
 * The ActionCard is a card with an event that makes the player do something.
 */
public class ActionCard extends Card
{
    /**
     * This attribute contain's the player's name.
     */
    public final String NAME;

    /**
     * This attribute contains the card's type, which ranges for the following values:
     * 0 - Make the player collect from the bank this card's value
     * 1 - Make the player pay the bank this card's value
     * 2 - Make the player pay another player this card's value
     * 3 - Make the player collect money from another player this card's value
     */
    public final int TYPE;

    /**
     * This attribute contains the card's monetary value, to be used by its events.
     */
    public final double AMOUNT;

    /**
     * This attribute contains the ArrayList of all players in the game.
     */
    private ArrayList<Player> allPlayers;
    
    /**
     * This constructor initializes and randomly assigns this card its name and amount.
     * The list of players is needed when the active player needs to choose another player to do an action.
     * @param type : int
     * @param players : ArrayList of Player
     */
    public ActionCard(int type, ArrayList<Player> players)
    {
        TYPE = type;
        NAME = generateName();
        this.allPlayers = players;

        // Generate for the amount
        Random rand = new Random(ThatsLife.rollNumber());
        AMOUNT = 10000*(1 + rand.nextInt(13));
    }

    /**
     * This method randomly generates this instance's name based on the card type.
     * @return cardName : String
     */
    private String generateName()
    {
        switch(TYPE)
        {
            case 0:
                switch(ThatsLife.rollNumber() % 6)
                {
                    case 0:
                    case 1: return "Tax Refund";
                    case 2: return "Sell an Item";
                    case 3: return "Bonus Payday";
                    case 4: return "Setup School";
                    case 5: return "Write a Book";
                } break;
            case 1:
                switch(ThatsLife.rollNumber() % 7)
                {
                    case 0:
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
                    case 0:
                    case 1: return "Lawsuit";
                    case 2: return "Christmas Bonus";
                } break;
            case 3:
                switch(ThatsLife.rollNumber() % 3)
                {
                    case 0:
                    case 1: return "File a Lawsuit";
                    case 2: return "It's your Birthday";
                } break;
        }
        return null;
    }

    /**
     * This event executes the actions to be done by this card.
     * This implements the abstract method in the Card class that automatically
     * gets called when a player lands on this space.
     * @param player : Player to be performed events on.
     */
    public void event(Player player)
    {
        switch(TYPE)
        {
            case 0: collectFromBank(player); break;
            case 1: payTheBank(player); break;
            case 2: payThePlayer(player); break;
            case 3: collectFromPlayer(player); break;
        }
    }

    /**
     * This method prompts the player to choose another player to perform an action on.
     * @param exclude : Player to exclude from the decision
     * @return player : Player that was chosen
     */
    private Player choosePlayer(Player exclude)
    {
        String prompt = new String("Choose a player (check message prompt for purpose)");
        String[] options = new String[allPlayers.size() - 1];
        
        int j = 0;
        for(Player player : this.allPlayers)
        {
        	if(!player.equals(exclude))
        	{
        		options[j++] = player.getName();
        	}
        }
        
        int result = ThatsLife.getSessionJFXController().displayDecision(prompt, options);
        Player choice = null;
        
        for(int i = 0; i < this.allPlayers.size(); i++)
        	if(options[result].equals(allPlayers.get(i).getName()))
        		choice = allPlayers.get(i);
      
        return choice;
    }

    /**
     * This method is the event that get triggered when the type is 0
     * @param player : Player
     */
    private void collectFromBank(Player player)
    {
        System.out.printf("\n\n[You drew an Action Card!] The bank pays you %.2f for %s.\n", this.AMOUNT, this.NAME);
        player.credit(this.AMOUNT, "Action card value credited.");
    }

    /**
     * This method is the event that gets triggered when the type is 1
     * @param player : Player
     */
    private void payTheBank(Player player)
    {
        System.out.printf("\n\n[You drew an Action Card!] You pay the bank %.2f for %s.\n", this.AMOUNT, this.NAME);
        player.debit(this.AMOUNT, "Action card value debited.");
    }

    /**
     * This method is the event that gets triggered when the type is 2
     * @param player : Player
     */
    private void payThePlayer(Player player)
    {
        System.out.printf("\n\n[You drew an Action Card!] You pay a player %.2f for %s.\n", this.AMOUNT, this.NAME);

        Player chosen = choosePlayer(player);
        
        player.debit(this.AMOUNT, "You paid a player the value of the this Action Card.");
        chosen.credit(this.AMOUNT, player.getName() + " has paid you.");
    }

    /**
     * This method is the event that gets triggered when the type is 3
     * @param player : Player
     */
    private void collectFromPlayer(Player player)
    {
        System.out.printf("\n\n[You drew an Action Card!] You collect %.2f from a player for %s.\n", this.AMOUNT, this.NAME);

        Player chosen = choosePlayer(player);
        
        player.credit(this.AMOUNT, "You received the value of this Action Card from another player.");
        chosen.debit(this.AMOUNT, player.getName() + " has collected funds from you.");
    }

    /**
     * This method converts this ActionCard data to its string representation.
     * @return data : String
     */
    @Override
    public String toString()
    {
        return (
            "[ActionCard] " + this.NAME + " | Amount = " + String.valueOf(this.AMOUNT)
        );
    }
}