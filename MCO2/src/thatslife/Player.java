package thatslife;
/**
 * This is the Player class. All user interaction takes place in this class.
 * This player object is stored and instantiated in the ThatsLife class. References to this may also be found in some of the deck classes.
 */
public class Player 
{
    /**
     * This attribute holds the total playerIDs in the game.
     * Player ids are just used for the player equals method.
     */
    private static int id = 0;

    /**
     * This attribute holds this player's ID.
     */
    private int playerID;

    /**
     * This attribute holds the player's name.
     */
    private String playerName;

    /**
     * This attribute holds the player's current career card.
     */
    private CareerCard career;

    /**
     * This attribute holds the player's current salary card.
     */
    private SalaryCard salary;

    /**
     * This attribute holds the player's money balance.
     */
    private double balance;

    /**
     * This attribute holds the player's total loan value including the interest.
     */
    private double loan;

    /**
     * This attribute holds the boolean value of the player's graduation status.
     */
    private boolean graduate;

    /**
     * This attribute holds the player's house, if he owns one.
     */
    private HouseCard house;

    /**
     * This attribute holds the a boolean value that tells if the player is married or not.
     */
    private boolean spouse;

    /**
     * This attribute holds the value for how many children the player has.
     */
    private int children;

    /**
     * This attribute holds the space where the player is currently on.
     */
    private Space space;

    /**
     * This constructor initializes default values for the player attributes as described in the Machine Project specifications.
     * @param name : String
     */
    public Player(String name)
    {
        this.playerID = Player.id++;
        this.playerName = new String(name);
        career = null;
        salary = null;
        balance = 200000;
        house = null;
        spouse = false;
        children = 0;
        loan = 0;
    }

    // GETTERS
    /**
     * This getter method returns this player's name.
     * @return playerName : String
     */
    public String getName()
    {
        return this.playerName;
    }

    /**
     * This getter method returns the player's current money balance.
     * @return balance : double
     */
    public double getBalance()
    {
        return this.balance;
    }

    /**
     * This getter method returns the player's current career card.
     * @return careerCard : CareerCard
     */
    public CareerCard getCareer()
    {
        return this.career;
    }

    /**
     * This getter method returns the player's current salary card.
     * @return salaryCard : SalaryCard
     */
    public SalaryCard getSalary()
    {
        return this.salary;
    }

    /**
     * This getter method returns space that the player is currently standing on.
     * @return space : Space
     */
    public Space getSpace()
    {
        return this.space;
    }

    /**
     * This getter method returns the house card that the player has.
     * @return house : HouseCard
     */
    public HouseCard getHouse()
    {
        return this.house;
    }

    /**
     * This getter method returns the number of children the player has.
     * @return children : int
     */
    public int getChildren()
    {
        return this.children;
    }

    /**
     * This getter method returns the player's current loan amount.
     * @return loan : double
     */
    public double getLoan()
    {
        return this.loan;
    }  

    /**
     * This getter method returns the player's college academic status.
     * @return graduate : boolean
     */
    public boolean getGraduate()
    {
        return this.graduate;
    }

    /**
     * This getter method returns the player's unique ID number.
     * @return playerID : int
     */
    public int getPlayerID()
    {
        return this.playerID;
    }

    /**
     * This getter method returns true if the player is married. False otherwise.
     * @return isMarried : boolean
     */
    public boolean isMarried()
    {
        return this.spouse;
    }

    /**
     * This getter method returns true if the player isn't standing on the game's last space, an instance of EndSpace.
     * @return isActive : boolean
     */
    public boolean isActive()
    {
        if(this.space instanceof EndSpace)
            return false;
        return true;
    }

    // Balance operations
    /**
     * This operational method adds a double amount to the player's current balance. It also display's the purpose of that credit.
     * @param amount - the double value to be added to the player's current balance.
     * @param desc - the description to be dispalyed when crediting the amount.
     */
    public void credit(double amount, String desc)
    {
        ThatsLife.getSessionJFXController().displayPrompt(String.format("\n[%s] You were credited $%.2f : %s\n", this.playerName, amount, desc));
        this.balance += amount;
    }

    /**
     * This operational method subtracts a given double amount from the player's current balance. It also display's the purpose of the debit.
     * If the given amount is greater than the 
     * player's balance, then it calls the loan() method until the player has the right balance then subtracts.
     * @param amount - the double value to be added to the player's current balance
     * @param desc - the description to be displayed when debiting the amount.
     */
    public void debit(double amount, String desc)
    {
    	ThatsLife.getSessionJFXController().displayPrompt(String.format("\n[%s] You were debited $%.2f : %s\n", this.playerName, amount, desc));
        while (this.balance < amount)
        {
            // Do a loan
        	ThatsLife.getSessionJFXController().displayPrompt(String.format("[%s] You do not have enough funds for this transaction. You loaned $20000 from the bank.\n", this.playerName));
            loan();
        }
        
        this.balance -= amount;
    }

    /**
     * This operational method subtracts a given double amount from the player's current balance. It also display's the purpose of that debit.
     * Unlike the debit() method, this does not call the loan() method when the player has insufficient balance. It subtracts it either way.
     * @param amount - the double value to be added to the player's current balance
     * @param desc - the description to be displayed when debiting the amount.
     */
    public void rawDebit(double amount, String desc)
    {
    	ThatsLife.getSessionJFXController().displayPrompt(String.format("\n[%s] You were debited $%.2f : %s\n", this.playerName, amount, desc));
        this.balance -= amount;
    }

    // SETTERS
    /**
     * This setter method sets the player's salary card.
     * @param salary : SalaryCard
     */
    public void setSalary(SalaryCard salary) 
    {
        this.salary = salary;
        this.salary.event(this);
    }

    /**
     * This setter method sets the player's career card.
     * @param career : CareerCard
     */
    public void setCareer(CareerCard career) 
    {
        this.career = career;
        this.career.event(this);
    }

    /**
     * This setter method sets the player's house card.
     * @param house : HouseCard
     */
    public void setHouse(HouseCard house) 
    {
        this.house = house;
    }

    /**
     * This setter method sets the player's marital status.
     * @param spouse : boolean
     */
    public void setSpouse(boolean spouse)
    {
        this.spouse = spouse;
    }

    /**
     * This setter method sets the player's college academic status..
     * @param g : boolean
     */
    public void setGraduate(boolean g)
    {
        this.graduate = g;
    }

    /**
     * This setter method increments the player's children count.
     */
    public void addChild()
    {
        this.children++;
    }

    // Movement Methods
    /**
     * This setter method sets the player's current space.
     * This method should only be called when manually overriding.
     * This method does not call the space's event.
     * @param space : Space
     */
    public void setSpace(Space space)
    {
        this.space = space;
    }

    /**
     * This operational method moves the player by the number of steps as parameter.
     * This method automatically calls the space's event on the space that it lands on.
     * This method also stops moving the player when it comes across a MagentaSpace.
     * @param steps : int - number of steps to move
     * @return moved : int - number of steps actually moved
     */
    public int move(int steps)
    {
        ThatsLife.getSessionJFXController().displayPrompt(String.format("Moving %d spaces!\n", steps));
        this.space.playerLeave(this);
        int moved = 0;
        for (int i = 0; i < steps; i++)
        {
            if(this.space instanceof MagentaSpace && i != 0)
            {
                ThatsLife.getSessionJFXController().displayPrompt("You landed on a Magenta Space! You stopped moving.");
                break;
            }

            if(this.space instanceof EndSpace)
            {
            	ThatsLife.getSessionJFXController().displayPrompt("You reached the end of your career. Welcome to retirement!");
                break;
            }
            this.space = this.space.getNextSpace();
            moved = i + 1;
        }
        ThatsLife.getSessionJFXController().displayPrompt(String.format("\nMoved %d spaces!\n", moved));
        this.space.playerLand(this);
        return moved;
    }

    /**
     * This method prompts the user to make a decision, based on a string as parameter.
     * @param options : String - a String that holds the options to be prompted to the player
     * @return choice : int - a numerical value that the player enters
     */
    public int decision(String prompt, String[] options)
    {
        return ThatsLife.getSessionJFXController().displayDecision(prompt, options);
    }

    /**
     * This method prompts the user that it will generate a random number using the randomizer method in ThatsLife.
     * It then rolls a random number and returns it.
     * @return n : int
     */
    public int spin()
    {
        int n = ThatsLife.rollNumber();
        
        ThatsLife.getSessionJFXController().displayPrompt(String.format("[Spin] Obtained the number %d!", n));
        
        return n;
    }

    /**
     * This method executes the loan() function n times.
     * @param n - number of times to loan
     */
    public void doLoan(int n)
    {
        for(int i = 0; i < n; i++)
            loan();
    }

    /**
     * This method makes the player file a loan. The loan attribute is incremented by 25000, while the player's balance is credited
     * 20000.
     */
    private void loan()
    {
        this.loan += 25000;
        this.balance += 20000;
    }

    /**
     * This method allows the player to pay off his loan before the game ends.
     * The player is presented this decision before the start of his turn.
     * @param override - if this is true, the method will debit the player regardless of his balance
     * @return paid : boolean - is true when the loan has been paid
     */
    public boolean payLoan(boolean override)
    {
        // Check if the player has enough funds
        if(this.balance < this.loan && !override)
            return false;
        
        // Pay off the loan
        this.rawDebit(this.loan, "You have paid off your loan!");
        this.loan = 0;

        return true;
    }

    /**
     * Converts the player data and consolidates them into a singe usable string.
     * @return data : String
     */
    @Override
    public String toString()
    {
        return (
            "[" + this.playerName + "] \nBalance = $" + String.valueOf(this.balance) + "\n" +
            "Loan: $" + String.valueOf(this.loan) + "\n" +
            "Career: " + (this.career != null ? this.career.toString() : "No Career Set") + "\n" +
            "Salary: " + (this.salary != null ? this.salary.toString() : "No Salary Set") + "\n" +
            "Married : " + String.valueOf(this.spouse) + "\n" +
            "House : " + (this.house != null ? this.house.toString() : "No House") + "\n" +
            "Children : "  + String.valueOf(this.children) + "\n" +
            "Current Space : " + this.space.toString()
        );
    }

    /**
     * Checks for object equality by checking player name and space.
     * @return isEqual : boolean
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        return this.playerName.equals(((Player) obj).getName()) && this.space.equals(((Player)obj).getSpace()) && this.playerID == ((Player)obj).getPlayerID();
    }
}