import java.util.*;

/**
 * This class defines MagentaSpace, a type of space that requires the player to stop moving and execute its events.
 * This class inherits from the abstract Space class.
 */
public class MagentaSpace extends Space
{
    /**
     * This attribute stores the type of MagentaSpace this instance is. Types are:
     * 0 - College Career Choice
     * 1 - Job Search
     * 2 - Buy House
     * 3 - Get Married
     * 4 - Have Baby
     * 5 - Have Twins
     * 6 - Graduation
     * 7 - Career Choice
     */
    public final int TYPE;

    /**
     * This attritute holds the main instance for the players ArrayList.
     */
    private ArrayList<Player> allPlayers;
    
    /**
     * This constructor calls the superclass constructor to initialize superclass attributes.
     * It initializes the type and players as given as parameters.
     * @param path - the path this space belongs to
     * @param type - the classification of this space
     * @param players - the main players ArrayList
     */
    public MagentaSpace(Path path, int type, ArrayList<Player> players)
    {
        super(path);
        TYPE = type;
        this.allPlayers = players;
    }

    /**
     * This getter method returns the space's name, depending on the type.
     * @return String
     */
    public String getType()
    {
        switch(TYPE)
        {
            case 0: return "College Career Choice";
            case 1: return "Job Search";
            case 2: return "Buy House";
            case 3: return "Get Married";
            case 4: return "Have Baby";
            case 5: return "Have Twins";
            case 6: return "Graduation";
            case 7: return "Career Choice";
        }

        return "INVALID";
    }

    /**
     * This method implements the abstract event() method in the superclass.
     * This method gets called when the player lands on this space.
     * For this class, this method calls the appropriate event method depending on the type.
     * @param player : Player - player to execute the event on
     */
    protected void event(Player player)
    {
        switch(TYPE)
        {
            case 0: collegeCareerChoice(player); break;
            case 1: jobSearch(player); break;
            case 2: buyHouse(player); break;
            case 3: getMarried(player); break;
            case 4: haveBaby(player); break;
            case 5: haveTwins(player); break;
            case 6: graduate(player); break;
            case 7: careerChoice(player); break;
        }

        // Roll Again
        System.out.println("Move Again!");
        int spin = player.spin();
        player.move(spin);
    }

    // EVENT FUNCTIONS
    private void collegeCareerChoice(Player player)
    {
        // Draw top two cards from Career Deck and Salary Deck
        CareerCard[] cCards = new CareerCard[2];
        int i = 0;
        do
        {   
            cCards[i] = (CareerCard) ThatsLife.getDeck(0).drawCard();
            if(cCards[i].DEGREE)
                i++;
            else
                ThatsLife.getDeck(0).returnCard(cCards[i]);
        } while(i < 2);

        SalaryCard[] sCards = new SalaryCard[2];
        sCards[0] = (SalaryCard) ThatsLife.getDeck(1).drawCard();
        sCards[1] = (SalaryCard) ThatsLife.getDeck(1).drawCard();

        // Have the player choose
        String options = new String();
        options += "Select from the two Career Cards:\n";
        options += "[1] " + cCards[0].toString() + "\n";
        options += "[2] " + cCards[1].toString() + "\n";
        options += "Your Choice: ";
        int choice;
        while (true)
        {
            choice = player.decision(options);
            if(choice > 0 && choice < 3)
                break;
        }
        // Lock the career and return the other one
        player.setCareer(cCards[choice-1]);
        if(choice == 1)
            ThatsLife.getDeck(0).returnCard(cCards[0]);
        else
            ThatsLife.getDeck(0).returnCard(cCards[1]);

        // Repeat for Salary

        // Have the player choose
        options = new String();
        options += "Select from the two Salary Cards:\n";
        options += "[1] " + sCards[0].toString() + "\n";
        options += "[2] " + sCards[1].toString() + "\n";
        options += "Your Choice: ";
        while (true)
        {
            choice = player.decision(options);
            if(choice > 0 && choice < 3)
                break;
        }
        // Lock the career and return the other one
        player.setSalary(sCards[choice-1]);
        if(choice == 1)
            ThatsLife.getDeck(1).returnCard(sCards[0]);
        else
            ThatsLife.getDeck(1).returnCard(sCards[1]);
    }

    private void jobSearch(Player player)
    {
        // Draw from Career and Salary
        CareerCard cCard;
        SalaryCard sCard = (SalaryCard) ThatsLife.getDeck(1).drawCard();

        while(true)
        {
            cCard = (CareerCard) ThatsLife.getDeck(0).drawCard();
            if(cCard.DEGREE == player.getGraduate())
                break;
        }

        // Display the Cards to the player
        String options = new String();
        options += "[JOB SEARCH] Accept new Career?\n";
        options += cCard.toString() + "\n";
        options += sCard.toString() + "\n";
        options += "[1] Yes | [2] No\n";
        options += "Your Choice: ";
        int choice;
        while (true)
        {
            choice = player.decision(options);
            if(choice > 0 && choice < 3)
                break;
        }

        // Lock the cards
        if(choice == 2)
        {
            // Return cards
            ThatsLife.getDeck(0).returnCard(cCard);
            ThatsLife.getDeck(1).returnCard(sCard);
        }
        else
        {
            // Switch Career
            CareerCard activeCareer = player.getCareer();
            SalaryCard activeSalary = player.getSalary();

            // Overwrite
            player.setCareer(cCard);
            player.setSalary(sCard);

            // Return the two cards
            ThatsLife.getDeck(0).returnCard(activeCareer);
            ThatsLife.getDeck(1).returnCard(activeSalary);
        }
    }

    private void buyHouse(Player player)
    {
        if(player.getHouse() == null)
        {
            String options = new String();
        
            // Allow the Player to Select from the House Cards
            ArrayList<HouseCard> houseCards = new ArrayList<HouseCard>();
            for(int i = 0; i < ThatsLife.getDeck(4).getDeckSize(); i++)
                houseCards.add((HouseCard)ThatsLife.getDeck(4).drawCard());

            options += "Select a house to purchase:\n";

            int endIndex = 0;
            for(int i = 0; i < houseCards.size(); i++)
            {
                options += "[" + String.valueOf(i+1) + "] " + houseCards.get(i).toString() + "\n";
                endIndex = i + 1;
            }
            options += "\n[" + String.valueOf(endIndex + 1) + "] Do not purchase a house\n";
            options += "Your Choice: ";

            int choice;
            while (true)
            {
                choice = player.decision(options);
                if(choice > 0 && choice <= houseCards.size() + 1)
                    break;
            }

            if(choice != houseCards.size()+1)
            {
                // Remove from the arraylist player's decision and charge the player
                HouseCard use = houseCards.remove(choice-1);
                player.debit(use.BUY, "You bought a house!");

                // Push to the player
                if(use != null)
                    player.setHouse(use);
            }

            // Return all unused cards to the deck
            for(HouseCard card : houseCards)
            {
                ThatsLife.getDeck(4).returnCard(card);
            }
        }
    }

    private void getMarried(Player player)
    {
        if(!(player.isMarried()))
        {
            player.setSpouse(true);
            System.out.println("\n\nSpin to determine your wedding gift!\nOdd Number : Collect $5000 from each player\nEven Number : Collect $10000 from each player\n\n");
            int spin = player.spin();
            if (spin % 2 == 1)
            {
                player.credit(5000*(allPlayers.size()-1), "You got married! Here's $5000 from each other player for your wedding gift.");
                for (Player otherPlayer : allPlayers) 
                {
                    if(!(player.equals(otherPlayer)))
                        otherPlayer.debit(5000, "Someone got married! You paid them $5000 as a wedding gift.");    
                }
            }
            else
            {
                player.credit(10000*(allPlayers.size()-1), "You got married! Here's $10000 from each other player for your wedding gift.");
                for (Player otherPlayer : allPlayers) 
                {
                    if(!(player.equals(otherPlayer)))
                        otherPlayer.debit(10000, "Someone got married! You paid them $10000 as a wedding gift.");    
                }
            }
        }
        else
            System.out.println("You're already married!");
    }
    
    private void haveBaby(Player player)
    {
        if(player.isMarried())
        {
            player.addChild();
            player.credit(5000*(allPlayers.size()-1), "Your child was born! Everyone gives you $5000 as a gift.");
            for (Player otherPlayer : allPlayers) 
            {
                if(!(player.equals(otherPlayer)))
                    otherPlayer.debit(5000, "Someone just had a child! You pay $5000 as a gift.");    
            }
        }
    }

    private void haveTwins(Player player)
    {
        if(player.isMarried())
        {
            player.addChild(); player.addChild();
            player.credit(10000*(allPlayers.size()-1), "Your twins were born! Everyone gives you $10000 as a gift.");
            for (Player otherPlayer : allPlayers) 
            {
                if(!(player.equals(otherPlayer)))
                    otherPlayer.debit(10000, "Someone just had twins! You pay $10000 as a gift.");    
            }
        }
    }

    private void graduate(Player player)
    {
        System.out.println("Contratulations on your graduation, " + player.getName() + "!");
        player.setGraduate(true);
    }

    private void careerChoice(Player player)
    {
        CareerCard card;
        SalaryCard sCard;
        // Draw a Career Card. Return if it requires a degree.
        boolean valid = false;
        do
        {
            card = (CareerCard) ThatsLife.getDeck(0).drawCard();
            if(!card.DEGREE)
                valid = true;
            else
                ThatsLife.getDeck(0).returnCard(card);
        } while (!valid);

        // Draw a Salary Card
        sCard = (SalaryCard) ThatsLife.getDeck(1).drawCard();

        // Show the cards
        System.out.println("Career Chosen: " + card.toString());
        System.out.println("Salary Chosen: " + sCard.toString());

        // Store the Cards
        player.setCareer(card);
        player.setSalary(sCard);
    }

    @Override
    public String toString()
    {
        return new String(
            "[MagentaSpace (" + this.getType() + ") " + String.valueOf(this.ID) + "]"
        );
    }
}