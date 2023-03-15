package bankSimulation;
import java.util.ArrayList;
public class Customer {

	//instance variables 
	private int numAccounts = 0; 
	private String first;
	private String last;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	/*
	 * creates a new Customer object
	 * that has a String first
	 * and  String last,
	 * that represent the name of the customer
	 */
	public Customer(String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	/*
	 * method adds an account to ArrayList
	 * but throws a cannotDuplicateAccountException
	 * when the account already exists
	 */
	public void addAccount(Account account) throws cannotDuplicateAccountTypeException {
		//make sure type isn't repeated 
		for(int i = 0; i < numAccounts; i++) {
			if(account.getType().equalsIgnoreCase(accounts.get(i).getType())) {
				throw new cannotDuplicateAccountTypeException(account.getType());
			}
		}
		accounts.add(account);
		numAccounts++;
	}
	
	//getter for first (name)
	public String getFirstName() {
		return first;
	}
	
	//getter for last (name)
	public String getLastName() {
		return last;
	}
	
	/*
	 * method receives 3 parameters:
	 * a Currency object money,
	 * that represents the amount of money to be deposited,
	 * and a String type,
	 * to specify which account to deposit into
	 * Throws an accountDoesNotExistException,
	 * when the account hasn't been created yet
	 * and a depositNotAllowedException,
	 * if type is "CD"
	 */
	public void deposit(Currency money, String type) 
			throws accountDoesNotExistException, 
			depositNotAllowedException {
		
	
		int counter = 0;
			Account a;
			for(int i = 0; i < numAccounts; i++) { 
				if(accounts.get(i).getType().equalsIgnoreCase(type)) {
					counter++;
					a = accounts.get(i);
					a.deposit(money);
				}
			}
					if(counter == 0) {
						throw new accountDoesNotExistException(type); 
						}
	}
	
	/*
	 * method receives 2 parameters:
	 * a Currency object money,
	 * for how much is to be withdrawn
	 * and a String type,
	 * for which account to withdraw from
	 * Throws an accountDoesNotExistException,
	 * a withdawNotAllowedYetException,
	 * if type is "CD",
	 * and an accountOverdrawnException,
	 * if the funds available aren't enough
	 */
	public void withdraw(Currency money, String type)
			throws accountDoesNotExistException,
			accountOverdrawnException,
			withdrawNotAllowedYetException {
		
		int counter = 0;
		Account a;
		for(int i = 0; i < numAccounts; i++) {
			if(accounts.get(i).getType().equalsIgnoreCase(type)) {
				a = accounts.get(i);
				counter++;
				a.withdraw(money);
			}
		}
				if(counter == 0){
					throw new accountDoesNotExistException(type); 
				}		
	}
	
	/*
	 * method receives 2 parameters:
	 * a Currency object money
	 * and  a String type
	 * method sets money to the specified account's balance
	 * method throws an accountDoesNotExistException,
	 * if account isn't created yet,
	 */
	public void balance(Currency money, String type) 
			throws accountDoesNotExistException {
		
		int counter = 0;
		Account a;
		
		for(int i = 0; i < numAccounts; i++) {
			if(accounts.get(i).getType().equalsIgnoreCase(type)) {
				a = accounts.get(i);
				counter++;
				money = a.getBalance();
				System.out.println(a);
			}
		}
			
				if(counter == 0) {
					throw new accountDoesNotExistException(type); 
			}
				
	}
	
	//string representation of Customer object
	public String toString() {
		String s = "";
		for(int i = 0; i < numAccounts; i++) {
			s += accounts.get(i).getType() + " ";
		}
		return first + " " + last + " opened "
				+ numAccounts + " account(s): " + s;
	}
}
