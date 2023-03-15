package bankSimulation;
import java.util.Scanner;
import java.util.ArrayList;

public class Program {

	public static ArrayList<Customer> bank = new ArrayList<Customer>();
	public static int numCustomers = 0; 
	public static final double savingsRate =  0.6;
	public static final double cdRate = 0.4;
	
	public static void main(String[] args) throws Exception {

		char choice;
		String first, last, type;
		
		Scanner input = new Scanner(System.in);
	
		//prints options 
		showOptions(); 
		
		choice = input.next().charAt(0);
		
		while(choice != 'Q') {
		
			switch(choice) {
	
			default: 
				System.err.println("Your entry is invalid. Please try again.");
				break;
	
			case 'O':
				System.out.println("Enter first name followed by last name:");
				first = input.next();
				last = input.next();
				
				try {
					bank.add(becomeNewMember(first, last)); 	
				}
				catch(customerAlreadyRegisteredException e) {
					System.err.println(e.getMessage());
					break;
				}
				break;
				
			case 'B':
				System.out.println("Enter first name followed by last name:");
				first = input.next();
				last = input.next();
				
			System.out.println("Which account balance would you like to search for?");
			type = input.next();
			try {
				searchAccountBalance(first, last, type);
				}
			
			catch(accountDoesNotExistException e) {
				System.err.println(e.getMessage());
				break;
				}
			catch(customerNotFoundException f) {
				System.err.println(f.getMessage());
				break;
			}
			break;
			
			case 'W':
				
				System.out.println("Enter first name followed by last name:");
				first = input.next();
				last = input.next();
				System.out.println("Which account would you like to withdraw from?");
				type = input.next();
				System.out.println("How much would you like to withdraw?");
				Currency amountToWithdraw = new Currency(input.nextInt());
					
			try {
			
			withdraw(first, last, type, amountToWithdraw);
				}
			catch(withdrawNotAllowedYetException g) {
				System.err.println(g.getMessage());
				break;
			
				}
			catch(accountOverdrawnException f) {
				System.err.println(f.getMessage());
				break;
				}
			catch(accountDoesNotExistException e) {
				System.err.println(e.getMessage());
				break;
				}
			catch(customerNotFoundException h) {
				System.err.println(h.getMessage());
				break;
			}
		
			break;
			
			case 'D':
	
				System.out.println("Enter first name followed by last name:");
				first = input.next();
				last = input.next();
				System.out.println("Which account would you like to deposit into ?");
			    type = input.next();
				System.out.println("How much would you like to deposit?");
				Currency amountToDeposit = new Currency(input.nextInt());
				
			
			try {
				deposit(first, last, type, amountToDeposit);
				
				}
			catch(depositNotAllowedException f) {
					System.err.println(f.getMessage());
					break;
				}
			catch(accountDoesNotExistException e) {
				System.err.println(e.getMessage());
				break;
				}
			catch(customerNotFoundException g) {
				System.err.println(g.getMessage());
				break;
			}
			break;
			
			case 'C':	
		
				System.out.println("Enter first name followed by last name:");
				first = input.next();
				last = input.next();
				System.out.println("Which account type would you like to open?");
			    type = input.next();
			    System.out.println("What's your initial deposit amount?");
			    Currency amount = new Currency(input.nextInt());
			
			try {
			openAccount(first, last,type, amount);
		
				}
			catch(cannotDuplicateAccountTypeException e) {
				System.err.println(e.getMessage());
				break;
			}
			catch(customerNotFoundException f) {
				System.err.println(f.getMessage());
				break;
			}
			break;
		}
		
		System.out.println("What would you like to do next?");
		choice = input.next().charAt(0);
		}
		exit();
	}
	
	//prints options to console
	public static void showOptions() {
		
		System.out.println("Choose from the following:" 
				+ "\n" + "O: Become a new customer of the bank"
				+ "\n" + "B: Search for an account balance"
				+ "\n" + "W: Withdraw from an account"
				+ "\n" + "D: Deposit into an account"
				+ "\n" + "C: Open an account for a user"
				+ "\n" + "Q: Exit the program");
		
	}
	
	/* method becomeNewMember() receives String first (name) and last (name)
	 * it adds and returns a Customer object to the Customer arrayList
	 * throws a customerAlreadyExistException,
	 * if the first and last name match
	 * those of any other Customer object in the ArrayList
	 */
	
	public static Customer becomeNewMember(String first, String last) 
			throws customerAlreadyRegisteredException {
		for(int i = 0; i < numCustomers; i++) {
			if(bank.get(i).getFirstName().equalsIgnoreCase(first)
					&& bank.get(i).getLastName().equalsIgnoreCase(last)) {
				throw new customerAlreadyRegisteredException(first, last);
			}
		}
		numCustomers++;
		return new Customer(first, last);
	}
	
	/*
	 * method searchAccountBalance() receives 3 parameters
	 * a String first (name)
	 * a String last (name),
	 * and a String type,
	 * for which account balance to search for
	 * method throws an accountDoesNotExistException,
	 * if account hasn't been created yet,
	 * and a customerNotFoundException,
	 * if no Customer object from the ArrayList
	 * has that first and last name
	 */
	
	public static void searchAccountBalance(String first, String last, String type) 
			throws accountDoesNotExistException, customerNotFoundException {
		
		int counter = 0;
		
		Currency c = new Currency();
		for(int i = 0; i < numCustomers; i++) {
			if(first.equalsIgnoreCase(bank.get(i).getFirstName())
					&& last.equalsIgnoreCase(bank.get(i).getLastName())) {
				counter++;
				bank.get(i).balance(c, type);
			}
		}
			if(counter == 0) {
				throw new customerNotFoundException(first, last);
			}
	}
	
	/*
	 * method withdraw() allows to withdraw from an account
	 * it  receives 4 parameters:
	 * a String first (name)
	 * a String last (name)
	 * a String type,
	 * for which account to withdraw from,
	 * and a Currency object amount,
	 * for how much to withdraw
	 * method throws an accountDoesNotExcistException,
	 * if the account hasn't been created yet,
	 * a withdrawNotAlolowedYetException,
	 * if type is "CD"
	 * and customerNotFoundException, 
	 * if no Customer was registered under such a name
	 */
	public static void withdraw(String first, String last, String type, Currency amount) 
			throws accountDoesNotExistException, withdrawNotAllowedYetException,
			accountOverdrawnException, customerNotFoundException {
	
		int counter = 0;
		for(int i = 0; i < numCustomers; i++) {
			if((bank.get(i).getFirstName().equalsIgnoreCase(first)) 
					&& bank.get(i).getLastName().equalsIgnoreCase(last)) {
				bank.get(i).withdraw(amount, type);
				counter++;
			
			}
		}
			if(counter == 0) {
				throw new customerNotFoundException(first, last);
			}
	}
	/*
	 * method deposit() allows to deposit 
	 * money into an account
	 * it receives 4 parameters,
	 * a String first (name),
	 * a Sting last (name),
	 * a String type,
	 * for which account to deposit into,
	 * and a Currency object money,
	 * for how much to deposit,
	 * method throws a depositNotAllowedException,
	 * if type is "CD",
	 * an accuntDoesNotExistException,
	 * if account wasn't created for this Customer object
	 * and a customerNotFoundException,
	 * if the first and last names given 
	 * do not match any from the ArrayList
	 */
	public static void deposit(String first, String last, String type, Currency money) 
			throws depositNotAllowedException, 
			accountDoesNotExistException, customerNotFoundException {
		
		int counter = 0;
		Customer customer;
		for(int i = 0; i < numCustomers; i++) {
			if((bank.get(i).getFirstName().equalsIgnoreCase(first)) 
					&& bank.get(i).getLastName().equalsIgnoreCase(last)) {
				
				counter++;
				bank.get(i).deposit(money, type);
			}
		}
			if(counter == 0) {
				throw new customerNotFoundException(first, last);
			}
	}
	
	/*
	 * method openAccount() allows to open an account
	 * with $0
	 * it receives 3 parameters:
	 * a String first (name)
	 * a String last (name),
	 * a String type,
	 * for which account to open,
	 * it throws a cannotDuplicateAccountTypeException,
	 * if this account type was already opened for this customer,
	 * and a customerNotFoundException,
	 * if the first and last names d not match those of any
	 * Customer from the Customer ArrayList
	 */
	public static void openAccount(String first, String last, String type, Currency currency) 
			throws cannotDuplicateAccountTypeException, 
			customerNotFoundException {
		
		Customer customer;
		Account account;

		int counter = 0;
		
		for(int i = 0; i < numCustomers; i++) {
			if((bank.get(i).getFirstName().equalsIgnoreCase(first)) 
					&& bank.get(i).getLastName().equalsIgnoreCase(last)) {
			
				customer = bank.get(i);
				counter++;
				
				switch(type) {
				case "Checking" :
					 account = new Checking(currency);
					 customer.addAccount(account);
					return;
				case "Savings" :
					account = new Savings(currency, savingsRate);
					customer.addAccount(account);
					return;
				case "CD":
					account = new CD(currency, cdRate);
					customer.addAccount(account);
					return;
				}
			}
		}
			if(counter == 0) {
				throw new customerNotFoundException(first, last);
			}
	}
	
	/*
	 * method allows to exit program.
	 * prints a message saying "Goodbye!"
	 */
	public static void exit() {
		System.out.println("Goodbye!");
		System.exit(1);
	}
}
