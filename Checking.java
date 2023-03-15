package bankSimulation;

public class Checking extends Account {
	
	//inherits Currency object initialDeposit
	
	/*
	 * creates a new Savings object
	 * that has a Currency object variable
	 * and a type "Checking"
	 */
	public Checking(Currency initialAmount) {
		super(initialAmount, "Checking");
	}
	
	/*
	 * method withdraws Currency object money from initialDeposit
	 * throws an accountoverdrawnException
	 * when the funds available aren't sufficient 
	 * to allow desired operation
	 */
	public void withdraw(Currency money) 
			throws accountOverdrawnException {
		//exception
		if(initialDeposit.getValue() - money.getValue() < 0) {
			throw new accountOverdrawnException(money);
		}
		initialDeposit = initialDeposit.subtract(money);
	}
	
	/*
	 * method adds Currency amount to initialDeposit
	 */
	
	public void deposit(Currency money) {
		initialDeposit = initialDeposit.add(money);
	}
	
	//returns balance in the account
	Currency getBalance() {
		 return initialDeposit = new Currency(initialDeposit.getValue());
	 }
	
	//string representation of object
	public String toString() {
		return initialDeposit.toString();
	}
}
