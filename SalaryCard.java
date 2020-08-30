public class SalaryCard extends Card
{
    private int raised;
    private double salary;
    private double taxDue;
    private double payRaise;
    private Player player;
    
    public SalaryCard(double salary)
    {
        this.raised = 0;
        this.salary = salary;
        this.taxDue = salary/10;
        this.payRaise = 10000*ThatsLife.rollNumber();
    }

    public double getSalary()
    {
        return this.salary;
    }

    public double getTaxDue()
    {
        return this.taxDue;
    }

    public double getPayRaise()
    {
        return this.payRaise;
    }

    public void setTaxDue(double taxDue)
    {
        this.taxDue = taxDue;
    }

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