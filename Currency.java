package bankSimulation;

public class Currency {
	
	//keeps track of money in bank account 
	private int cents;
	
	//creates a Currency object with cents = 0;
	public Currency() {
		cents = 0; 
	}
	
	//creates a new Currency object with this.cents = cents(parameter value)
	public Currency(int cents) {
		this.cents = cents;
	}
	
	//getter for cents
	public int getValue() {
		return cents;
	}
	
	/* add method adds 2 currency objects with each other
	 * it returns a new Currency object
	 */
	public Currency add(Currency rhs) {
		
		return new Currency(this.cents + rhs.cents);
	}
	
	/*
	 * returns a new Currency object that is
	 * the subtraction of 2 other Currency objects
	 */
	public Currency subtract(Currency rhs) {
		
		return new Currency(this.cents - rhs.cents);
	}
	/*
	 * overrides toString()
	 * returns string representation of 
	 * current balance in the Currency object
	 * in dollars
	 */
	public String toString() {
		return "Current balance = $" + ((double)cents / 100);
	}
}
