/**
 * This class contains the details about a player's salary.
 * This class inherits from the Card class.
 */
public class SalaryCard extends Card
{
    /**
     * This attribute contains the number of times the player has done a Pay Raise.
     */
    private int raised;

    /**
     * This attribute contains the player's current salary
     * This is initially given as the constructor's parameter but this value can increase due to pay raises.
     */
    private double salary;

    /**
     * This attribute contains the player's taxDue value. For this game, it is calculated by getting 10% of the given salary.
     * Afterwards, every pay raise will increment this value by 2000.
     */
    private double taxDue;

    /**
     * This attribute holds the value for the pay raise amount to be added to the salary every pay raise.
     * Pay Raise is obtained through a randomizer.
     */
    private double payRaise;

    /**
     * This attribute holds the player instance.
     */
    private Player player;
    
    /**
     * This constructor instantiates all attributes of this instance.
     */
    public SalaryCard(double salary)
    {
        this.raised = 0;
        this.salary = salary;
        this.taxDue = salary*0.1;
        this.payRaise = 10000*ThatsLife.rollNumber();
    }

    /**
     * This getter method returns the player's current salary value.
     * @return salary : double
     */
    public double getSalary()
    {
        return this.salary;
    }

    /**
     * This getter method returns the player's current tax due value.
     * @return taxDue : double
     */
    public double getTaxDue()
    {
        return this.taxDue;
    }

    /**
     * This getter method returns the player's current pay raise value.
     * @return pRaise : double
     */
    public double getPayRaise()
    {
        return this.payRaise;
    }

    /**
     * This setter method sets the player's tax due value, given the parameter
     * @param taxDue : double - the new tax due
     */
    public void setTaxDue(double taxDue)
    {
        this.taxDue = taxDue;
    }

    /**
     * This operational method when called, performs a pay raise.
     * It returns true when successful, false otherwise.
     * @return isSuccess : boolean
     */
    public boolean payRaise()
    {
        if(this.raised <= player.getCareer().getMaxRaise())
        {
            System.out.println("You got a Pay Raise!");
            this.raised++;
            this.salary += this.payRaise;
            this.taxDue += 2000;

            return true;
        }

        return false;
    }

    /**
     * This method implements the superclass method event().
     * This method gets called when a player draws this instance.
     * @param player - the player to perform this event on
     */
    public void event(Player player) 
    {
        this.player = player;
    }

    @Override
    public String toString()
    {
        return (
            "[SalaryCard] " + String.valueOf(this.salary) + " | TaxDue : " + String.valueOf(this.taxDue) + " | Pay Raise = " + String.valueOf(this.payRaise)
        );
    }
}