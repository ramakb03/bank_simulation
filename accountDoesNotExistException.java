package bankSimulation;

public class accountDoesNotExistException extends Exception {

	String accountType;
	
	public accountDoesNotExistException(String accountType) {
		
		this.accountType = accountType;
	}
	public String getMessage() {
		return  accountType + " account does not exist for this customer.";
	}
}
