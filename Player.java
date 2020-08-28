import java.util.*;

public class Player 
{
    private String playerName;

    private CareerCard career;
    private SalaryCard salary;
    private double balance;

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
    }

    public void turn()
    {
        // Roll Number
        int nMove = ThatsLife.rollNumber();
        // Move n steps
        this.move(nMove);
        // Execute playerLand
        this.space.playerLand(this);
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

    public boolean isMarried()
    {
        return this.spouse;
    }

    // Balance operations
    public void credit(double amount)
    {
        this.balance += amount;
    }

    public boolean debit(double amount)
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
        // Calls the space event
        space.playerLand(this);
    }

    public int move(int steps)
    {
        Space bufferSpace = this.space;
        this.space.playerLeave(this);
        int moved = 0;
        for (int i = 0; i < steps; i++)
        {
            if(!(bufferSpace instanceof MagentaSpace))
            {
                bufferSpace = bufferSpace.getNextSpace();
                moved = i;
            }
            else break;
        }
        this.space = bufferSpace;
        this.space.playerLand(this);
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
        System.out.print("Input any number: ");
        Scanner kb = new Scanner(System.in);
        int n = Integer.parseInt(kb.nextLine());
        kb.close();
        return n;
    }

    @Override
    public String toString()
    {
        return (
            "[" + this.playerName + "] Balance = " + String.valueOf(this.balance)
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