package bankSimulation;

public class accountOverdrawnException extends Exception {

	private Currency currency; //amount customer wants to withdraw in cents
	
	public accountOverdrawnException(Currency currency) {
		this.currency = currency;
	}
	public String getMessage() {
		//when account balance < currency that you want to withdraw
		return "Cannot withdraw $" + currency.getValue() / 100 + " from this account.";
	}
}
