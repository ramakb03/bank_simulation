package bankSimulation;

public class cannotDuplicateAccountTypeException extends Exception {

	private String accountType;
	
	public cannotDuplicateAccountTypeException(String accountType) {
		this.accountType = accountType;
	}
	public String getMessage() {
		return "Cannot create a " + accountType + " account again";
	}
}
