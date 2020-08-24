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
}