package thatslife;

public class Transaction 
{
	/**
	 * Holds the number of transactions in the program runtime
	 */
	private static int count = 0;
	
	/**
	 * Is the unique integer ID of an instance of a transaction.
	 */
	public final int ID;
	
	/**
	 * The description/purpose of the transaction.
	 */
	public final String DESC;
	
	/**
	 * The amount of the transaction. Negative value = debited, positive or zero = credited.
	 */
	public final double AMT;
	
	/**
	 * This constructor creates the instance of transaction by receiving the transaction description and amount as parameters.
	 * @param desc This is the description or purpose of the transaction.
	 * @param amt This is the amount of the transaction. A negative number means debit, while a positive number means credit.
	 */
	public Transaction(String desc, double amt)
	{
		this.ID = Transaction.count++;
		this.DESC = desc;
		this.AMT = amt;
	}
	
	/**
	 * Provides a specific string representation for the transaction.
	 * @return The string representation for the instance.
	 */
	@Override
	public String toString()
	{
		return (
			String.format("[Transaction ID %d] %s %f", this.ID, AMT >= 0 ? "Credit" : "Debit", this.AMT)
		);
	}
	
	/**
	 * Compares two transactions via their unique transaction integer IDs.
	 * @param obj The object to compare to.
	 * @return Boolean value that represents the result of the equality.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		
		return ((Transaction) obj).ID == this.ID;
	}
}
