import java.util.*;

public class Player 
{
    private String playerName;

    private CareerCard career;
    private SalaryCard salary;
    private double balance;

    private House house;
    private boolean spouse;
    private ArrayList<Child> children;

    private Space space;

    public Player(String name)
    {
        this.playerName = new String(name);
        balance = 200000;
        house = null;
        spouse = false;
        children = new ArrayList<Child>();
        space = null;
    }

    public String getName()
    {
        return new String(this.playerName);
    }

    public double getBalance()
    {
        return balance;
    }

    public void credit(double amount)
    {
        this.balance += amount;
    }

    public boolean debit(double amount)
    {
        if(this.balance < amount)
            return false;
        
        this.balance -= amount;
        return true;
    }

    public void setCareer(CareerCard career)
    {
        this.career = career;
    }

    public String getCareer()
    {
        return this.career.NAME;
    }

    public void setHouse(House house)
    {
        this.house = house;
    }

    public void setSpouse(boolean hasSpouse)
    {
        this.spouse = hasSpouse;
    }

    public void addChild(Child child)
    {
        this.children.add(child);
    }

    // MOVE

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
        return this.playerName.equals(((Player) obj).getName());
    }
}