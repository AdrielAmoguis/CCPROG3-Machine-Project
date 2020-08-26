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

    public Player(String name, StartSpace start)
    {
        this.playerName = new String(name);
        career = null;
        salary = null;
        balance = 200000;
        house = null;
        spouse = false;
        children = 0;
        space = start;
        space.event(this);
        turn();
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

    public String getCareer()
    {
        return this.career.NAME;
    }

    public SalaryCard getSalary()
    {
        return this.salary;
    }

    public Space getSpace()
    {
        return this.space;
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
    }

    public int move(int steps)
    {
        Space bufferSpace = this.space;
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
        return moved;
    }

    public int decision(String[] options)
    {
        System.out.println("Choose from the following options:");
        for (int i = 0; i < options.length; i++) 
        {
            System.out.printf("[%d] %s\n", i+1, options[i]);
        }
        Scanner keyStream = new Scanner(System.in);
        int choice = Integer.parseInt(keyStream.nextLine());
        keyStream.close();

        if(choice < 0 || choice > options.length)
            return -1;

        return choice-1;
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