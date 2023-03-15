package bankSimulation;

public class Savings extends Account {
	
	private double rate; //interest rate
	//inherits initialDeposit (Currency object)
	
	/*
	 * creates a new Savings object 
	 * that has a Currency object variable,
	 * a type "Savings"
	 * and an interest rate
	 */
	public Savings(Currency initial, double rate) {
		super(initial,"Savings");
		this.rate = rate;
		
	}
	/*
	 * method adds Currency amount to initialDeposit
	 */
	public void deposit(Currency amount) {

		initialDeposit = initialDeposit.add(amount);
	}
	
	/*
	 * method withdraws Currency amount from initialDeposit
	 * throws an accountoverdrawnException
	 * when the funds available aren't sufficient 
	 * to allow desired operation
	 */
	public void withdraw(Currency amount) throws accountOverdrawnException {

		if(initialDeposit.getValue() - amount.getValue() < 0) {
			throw new accountOverdrawnException(amount);
		}
		initialDeposit = initialDeposit.subtract(amount);
	}
	
	/* getter for initialDaeposit
	 * Takes into account the interest rate
	 */
	Currency getBalance() {
		//returns the balance in the account after rate applies
		//aka Currency object
		return initialDeposit = new Currency(initialDeposit.getValue() + 
				(int)((rate / 100) * initialDeposit.getValue()));
		
	}
	/* returns string representation
	 * of balance in the Savings account
	 */
	
	public String toString() {
		return initialDeposit.toString();
	}
}
