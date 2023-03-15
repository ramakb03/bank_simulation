package bankSimulation;

public class withdrawNotAllowedYetException extends Exception {

	private Currency amount;
	
	public withdrawNotAllowedYetException(Currency amount) {
		this.amount = amount;
	}
	public String getMessage() {
		return "Cannot withdraw $" + (double) amount.getValue() / 100 + " from this account yet.";
	}
}
