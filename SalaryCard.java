public class SalaryCard extends Card
{
    private double salary;
    private double taxDue;
    
    public SalaryCard(double salary, double taxDue)
    {
        this.salary = salary;
        this.taxDue = taxDue;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public double getTaxDue()
    {
        return this.taxDue;
    }

    public void setTaxDue(double taxDue)
    {
        this.taxDue = taxDue;
    }

    public void event(Player player) {}

    @Override
    public String toString()
    {
        return (
            "SalaryCard : " + String.valueOf(this.salary) + " Salary; TaxDue : " + String.valueOf(this.taxDue)
        );
    }
}