import java.util.*;

public class Player 
{
    private String playerName;

    private CareerCard career;
    private SalaryCard salary;
    private double balance;
    private double loan;

    private HouseCard house;
    private boolean spouse;
    private int children;

    private Space space;

    public Player(String name)
    {
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
    public String getName()
    {
        return this.playerName;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public CareerCard getCareer()
    {
        return this.career;
    }

    public SalaryCard getSalary()
    {
        return this.salary;
    }

    public Space getSpace()
    {
        return this.space;
    }

    public HouseCard getHouse()
    {
        return this.house;
    }

    public int getChildren()
    {
        return this.children;
    }

    public double getLoan()
    {
        return this.loan;
    }

    public boolean isMarried()
    {
        return this.spouse;
    }

    public boolean isActive()
    {
        if(this.space instanceof EndSpace)
            return false;
        return true;
    }

    // Balance operations
    public void credit(double amount, String desc)
    {
        System.out.printf("You were credited $%f : %s\n", amount, desc);
        this.balance += amount;
    }

    public boolean debit(double amount, String desc)
    {
        if (this.balance < amount)
            return false;
        
        this.balance -= amount;
        return true;
    }

    // SETTERS
    public void setSalary(SalaryCard salary) 
    {
        this.salary = salary;
    }

    public void setCareer(CareerCard career) 
    {
        this.career = career;
    }

    public void setHouse(HouseCard house) 
    {
        this.house = house;
    }

    public void setSpouse(boolean spouse)
    {
        this.spouse = spouse;
    }

    public void addChild()
    {
        this.children++;
    }

    // Movement Methods
    public void setSpace(Space space)
    {
        this.space = space;
    }

    public int move(int steps)
    {
        System.out.printf("Moving %d spaces!\n", steps);
        Space bufferSpace = this.space;
        this.space.playerLeave(this);
        int moved = 0;
        for (int i = 0; i < steps; i++)
        {
            if(bufferSpace instanceof MagentaSpace && i != 0)
                break;
            bufferSpace = bufferSpace.getNextSpace();
            moved = i;
        }
        this.space = bufferSpace;
        System.out.printf("Moved %d spaces!\n", moved);
        this.space.playerLand(this);
        System.out.printf("Current Space: %s\n", this.space.toString());
        return moved;
    }

    public int decision(String options)
    {
        System.out.print(options);
        int choice = Integer.parseInt(ThatsLife.kb.nextLine());

        return choice;
    }

    public int spin()
    {
        System.out.print("[Spin Again] Input any number: ");
        int n = Integer.parseInt(ThatsLife.kb.nextLine());
        return n;
    }

    private void loan()
    {
        this.loan += 25000;
        this.balance += 25000;
    }

    @Override
    public String toString()
    {
        return (
            "[" + this.playerName + "] \nBalance = $" + String.valueOf(this.balance) + "\n" +
            "Career: " + (this.career != null ? this.career.toString() : "No Career Set") + "\n" +
            "Salary: " + (this.salary != null ? this.salary.toString() : "No Salary Set") + "\n" +
            "Married : " + String.valueOf(this.spouse) + "\n" +
            "House : " + (this.house != null ? this.house.toString() : "No House") + "\n" +
            "Children : "  + String.valueOf(this.children) + "\n" +
            "Current Space : " + this.space.toString()
        );
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        return this.playerName.equals(((Player) obj).getName()) && this.space.equals(((Player)obj).getSpace());
    }
}