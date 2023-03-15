package bankSimulation;

public class CD extends Account {

	private double rate;
	//inherits Currency object initialDeposit
	
	/*
	 * creates a new Currency object 
	 * that has a Currency object variable,
	 * a type "CD",
	 * and an interest rate
	 */
	public CD (Currency initialAmount, double rate) {
		super(initialAmount, "CD");
		this.rate = rate;
	}
	/*
	 * method throws a depositNotAllowedException
	 */
	public void deposit(Currency amount) throws depositNotAllowedException {
		throw new depositNotAllowedException(amount);
		//not allowed
	}
	
	//method throws a withdrawNotAllowedYetException
	public void withdraw(Currency amount) throws withdrawNotAllowedYetException {
		throw new withdrawNotAllowedYetException(amount);
		//not allowed 
	}
	
	//getter for initialDeposit
	Currency getBalance() {
		return initialDeposit = new Currency(initialDeposit.getValue() + 
				(int)((rate / 100) * initialDeposit.getValue()));
	}
	
	//method returns string representation of object
	public String toString() {
		return initialDeposit.toString();
	}
}
