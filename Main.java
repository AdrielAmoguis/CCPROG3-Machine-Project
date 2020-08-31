/**
 * This class instantiates the master/main game class and drives it.
 * This class needs command-line startup arguments to run. Refer to the Javadoc for the main method.
 */
public class Main 
{
    /**
     * This method drives the game to run, using a Command-Line Interface (CLI).<br>
     * This driver method needs startup arguments to run. Refer to those below:<br>
     * REQUIRED ARGS (must be the first argument):<br>
     *  - Number of players (int): Example execution: "java Main 2" = 2 players<br>
     * OPTIONAL ARGS:<br>
     *  - "showactioncards" = Shows the action cards upon generation<br>
     *  - "showcareercards" = Shows the career cards upon generation<br>
     *  - "showsalarycards" = Shows the salary cards upon generation<br>
     *  - "nomap" = inhibits map display per turn<br>
     *  - "norng" = Runs the game without the use of RNG. The user inputs a value every time.<br>
     * Multiple arguments may be used at the same time.<br>
     * @param args - String[]
     */
    public static void main(String[] args)
    {
        // Instantiate Game
        boolean displayMap = true;
        int nPlayers = 0;
        try
        {
            nPlayers = Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
            System.out.println("Invalid argument for number of players. Quitting.");
            System.out.println("Usage: java Main <number of players [2,3]> <optional arguments>");
            System.exit(0);
        }
        finally
        {
            if(nPlayers < 2 || nPlayers > 3)
            {
                System.out.println("Incorrect value of number of players. Number of players must range from 2-3, inclusive. Quitting.");
                System.out.println("Usage: java Main <number of players [2,3]> <optional arguments>");
                System.exit(0);
            }
        }

        System.out.println("\nThat's Life | CCPROG3 Machine Project");
        System.out.println("Program Author: Adriel Isaiah V. Amoguis (CCPROG3 - S13B)");
        System.out.println("Professor: Ms. Shirley Chu\n");
        
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

                case "norng":
                    ThatsLife.addGameArgs(new String("norng"));
                    break;

                case "nomap":
                    displayMap = false;
                    break;

                case "showbluecards":
                    Card[] blueDeck = ThatsLife.getDeck(2).getDeck();
                    System.out.println("Blue Cards:");
                    for(Card card : blueDeck)
                    {
                        System.out.println(((BlueCard)card).toString());
                    }
                    break;
            }
        }

        // Start Playing
        while(game.isOngoing())
        {
            // Print the Map
            if(displayMap)
                System.out.println(game.getMap().toString());

            System.out.println("\nStart Turn!\n");

            System.out.println(game.getPlayerString(game.getTurn()));
            if(!ThatsLife.args.contains("norng"))
                System.out.print("\n[Spin to Move] Press [ENTER] to spin for a number and move. ");
            else
                System.out.print("\n[NORNG] Random Number Generator Inhibited. Input custom spin number: ");
            ThatsLife.kb.nextLine();
            game.startTurn();

            System.out.println("Your turn is over! Next player, press enter to continue. ");
            ThatsLife.kb.nextLine();
        }

        // Get Winners
        String ranking = game.declareRanking();

        System.out.println("--------==========| GAME OVER |==========--------");
        System.out.println("Final Rankings:");
        System.out.println(ranking);

        ThatsLife.kb.close();
        System.out.println("Thank you for playing That's Life!");
        System.out.println("Program Author: Adriel Isaiah V. Amoguis (CCPROG3 - S13B)");
        System.out.println("Professor: Ms. Shirley Chu");
    }
}