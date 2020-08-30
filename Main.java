public class Main 
{
    public static void main(String[] args)
    {
        // Instantiate Game
        int nPlayers = 0;
        try
        {
            nPlayers = Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
            System.out.println("Invalid argument for number of players. Quitting.");
            System.exit(0);
        }
        finally
        {
            if(nPlayers < 2 || nPlayers > 3)
            {
                System.out.println("Incorrect value of number of players. Number of players must range from 2-3, inclusive. Quitting.");
                System.exit(0);
            }
        }
        
        ThatsLife game = new ThatsLife(nPlayers);

        // Check Arguments
        for(int i = 1; i < args.length; i++)
        {
            switch(args[i].toLowerCase())
            {
                case "showactioncards":
                    System.out.println("Showing ActionCard Generation. Before and after shuffle:");
                    System.out.println("Before Shuffle:");
                    ActionCard[] actionCards = ((ActionDeck)ThatsLife.getDeck(3)).beforeShuffle;
                    for(int j = 0; j < actionCards.length; j++)
                    {
                        System.out.println(actionCards[j].toString());
                    }
                    System.out.println("After Shuffle:");
                    String[] aCards = ((ActionDeck)ThatsLife.getDeck(3)).getStrCards();
                    for(String card : aCards)
                    {
                        System.out.println(card);
                    }
                    break;

                case "showcareercards":
                    Card[] careerDeck = ThatsLife.getDeck(0).getDeck();
                    System.out.println("Career Cards:");
                    for(Card card : careerDeck)
                    {
                        System.out.println(((CareerCard)card).toString());
                    }
                    break;
                case "showsalarycards":
                    Card[] salaryDeck = ThatsLife.getDeck(1).getDeck();
                    System.out.println("Salary Cards:");
                    for(Card card : salaryDeck)
                    {
                        System.out.println(((SalaryCard)card).toString());
                    }
                    break;
            }
        }

        // Start Playing
        while(game.isOngoing())
        {
            System.out.println("\nStart Turn!\n");

            System.out.println(game.getPlayerString(game.getTurn()));
            System.out.print("\n[Spin to Move] Press [ENTER] to spin for a number and move. ");
            ThatsLife.kb.nextLine();
            game.startTurn();

            System.out.println("Your turn is over! Next player, press enter to continue. ");
            ThatsLife.kb.nextLine();
        }

        ThatsLife.kb.close();
    }
}