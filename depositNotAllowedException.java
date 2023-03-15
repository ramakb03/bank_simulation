package bankSimulation;

public class depositNotAllowedException extends Exception {

	private Currency amount;
	public depositNotAllowedException(Currency amount) {
		this.amount = amount;
	}
	public String getMessage() {
		return "Cannot deposit into a CD account";
	}
}
