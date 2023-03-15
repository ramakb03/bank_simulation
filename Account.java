package bankSimulation;

public abstract class Account {
	
	protected Currency initialDeposit; 	//stores balance of the account
	protected String type; //type of account 
	
	/* creates an account with an initial deposit of initAmount
	 * and initializes this.type to type(parameter)
	 */
	public Account(Currency initialDeposit, String type) {
		
		this.initialDeposit = initialDeposit;
		this.type = type;
	}
	
	//getter for type
	public String getType() {
		return type;
	}
	
	//abstract methods to be implemented by subclasses
	public abstract void withdraw(Currency money) throws withdrawNotAllowedYetException, accountOverdrawnException ; //withdraws money from account
	
	public abstract void deposit(Currency money) throws depositNotAllowedException ; //deposits money into account
	
	abstract Currency getBalance(); //returns balance in account, a Currency obj
	
}
