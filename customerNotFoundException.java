package bankSimulation;

public class customerNotFoundException extends Exception {

	String first;
	String last;
	
	public customerNotFoundException(String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	public String getMessage() {
		return first + " " + last + " is not registered in this bank.";
	}
}
