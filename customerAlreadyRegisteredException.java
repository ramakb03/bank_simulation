package bankSimulation;

public class customerAlreadyRegisteredException extends Exception {

	private String first, last;
	
	public customerAlreadyRegisteredException(String first, String last) {
		this.first = first;
		this.last = last;
	}
	public String getMessage() {
		return first + " " + last + " is already a customer of this bank. ";
	}
}
