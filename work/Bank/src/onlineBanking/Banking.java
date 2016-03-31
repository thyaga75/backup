package onlineBanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Banking {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int numberOfCustomers = 0;
		Bank bank = new Bank();
		Customer[] c = bank.getCustomer();

		while (true) {
			System.out.println("Please enter your choice");
			System.out.println("1 : Add Customer");
			System.out.println("2 : Desposit Money");
			System.out.println("3 : Withdraw Money");
			System.out.println("4 : Check Balance");
			System.out.println("5 : Calculate Interest");
			System.out.println("6 : Exit");
			int choice = Integer.parseInt(bufferedReader.readLine());
			switch (choice) {
			case 1:
				System.out.println("Creating an account for new Customer");
				System.out.println("Please enter initial amount to deposit to your account");
				double bal = Double.parseDouble(bufferedReader.readLine());
				System.out.println("Please enter account number");
				String accno = bufferedReader.readLine();
				Account account = new Account(bal, accno);
				System.out.println("Please enter your Name:");
				String name = bufferedReader.readLine();
				Customer customer = new Customer(name, account);
				customer.display();
				c[numberOfCustomers] = customer;
				numberOfCustomers++;
				System.err.println("Number of customers : " + numberOfCustomers);
				for (int i = 0; i < numberOfCustomers; i++) {
					System.err.println("Name of customer : " + c[i].getName());
				}
				break;
			case 2:
				System.out.println("Please Enter Account Number : ");
				accno = bufferedReader.readLine();
				if (numberOfCustomers == 0) {
					System.out.println("No Customer found.");
				} else {
					boolean found = false;

					for (int i = 0; i < numberOfCustomers; i++) {
						Account temp = c[i].getAccount();
						String accountTemp = temp.getAccountNo();
						if (accountTemp.equals(accno)) {
							System.out
									.println("Please enter the amount to be deposited to your account." + accno + ":");
							double dAmount = Double.parseDouble(bufferedReader.readLine());
							temp.deposit(dAmount);
							found = true;
						}
					}
					if (found == false) {
						System.out.println("No Customer found.");
					}
				}
				break;
			case 3:
				System.out.println("Please Enter Account Number : ");
				accno = bufferedReader.readLine();
				if (numberOfCustomers == 0) {
					System.out.println("No Customer found.");
				} else {
					boolean found = false;

					for (int i = 0; i < numberOfCustomers; i++) {
						Account temp = c[i].getAccount();
						String accountTemp = temp.getAccountNo();
						if (accountTemp.equals(accno)) {
							System.out.println(
									"Please enter the amount to be withdrawn from your account." + accno + ":");
							double dAmount = Double.parseDouble(bufferedReader.readLine());
							temp.withDraw(dAmount);
							found = true;
						}
					}
					if (found == false) {
						System.out.println("No Customer found.");
					}
				}
				break;
			case 4:
				System.out.println("Please Enter Account Number : ");
				accno = bufferedReader.readLine();
				if (numberOfCustomers == 0) {
					System.out.println("No Customer found.");
				} else {
					boolean found = false;

					for (int i = 0; i < numberOfCustomers; i++) {
						Account temp = c[i].getAccount();
						String accountTemp = temp.getAccountNo();
						if (accountTemp.equals(accno)) {
							System.out.println(
									"Your total balance of your account - " + accno + " : " + temp.getBalance());
							found = true;
						}
					}
					if (found == false) {
						System.out.println("No Customer found.");
					}
				}
				break;
			case 5:
				System.out.println("Please Enter Account Number : ");
				accno = bufferedReader.readLine();
				if (numberOfCustomers == 0) {
					System.out.println("No Customer found.");
				} else {
					boolean found = false;

					for (int i = 0; i < numberOfCustomers; i++) {
						Account temp = c[i].getAccount();
						String accountTemp = temp.getAccountNo();
						if (accountTemp.equals(accno)) {
							bank.calculateInterest(c[i]);
							found = true;
						}
					}
					if (found == false) {
						System.out.println("No Customer found.");
					}
				}
				break;
			case 6:
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}
}

class Bank {
	private static double interestRate = 8.5;
	private static double transactionFee = 10;
	private Customer[] customers = new Customer[1000];

	public void calculateInterest(Customer customer) {
		Account a = customer.getAccount();
		double bal = a.getBalance();
		double interestAmount = bal * interestRate / 100;
		double totalBalance = bal + interestAmount;
		System.out.println("Interest Amount would be : " + interestAmount
				+ "New total balance in your account would be :" + totalBalance);
	}

	public static double getInterestRate() {
		return interestRate;
	}

	public static double getTransactionFees() {
		return transactionFee;
	}

	public Customer[] getCustomer() {
		return customers;
	}
}

class Account {
	private double balance = 100;
	private String accountNumber;
	private boolean firstTime = true;

	public Account(String acc) {
		accountNumber = acc;
	}

	public Account(double bal, String acc) {
		if (bal >= 100) {
			balance = bal;
		} else {
			balance = 100;
		}
		accountNumber = acc;
	}

	public void deposit(double howMuch) {
		if (howMuch > 0) {
			balance += howMuch;
			System.out.println(howMuch + "was successfully deposited to your account. The new balance is " + balance);
		} else {
			System.err.println("Please ensure that the amount deposited is > 0");
		}
	}

	public void withDraw(double howMuch) {
		if (howMuch > 0) {
			if (firstTime == true) {
				double tempBalance = balance;
				tempBalance = tempBalance - howMuch;
				if (tempBalance >= 100) {
					balance = balance - howMuch;
					System.out.println(
							howMuch + " was successfully withdrawn from your account. The new balance is " + balance);

				} else {
					System.err.println("Insufficient balance to withdraw" + howMuch);
				}
				firstTime = false;
			} else {
				double tempBalance = balance;
				tempBalance = tempBalance - Bank.getTransactionFees();
				if (tempBalance >= 100) {
					balance = balance - howMuch - Bank.getTransactionFees();
					System.out.println(howMuch + " was successfully withdrawn from your account. Transaction fee is : "
							+ Bank.getTransactionFees() + " The new balance is " + balance);

				} else {
					System.err.println("Insufficient balance to withdraw" + howMuch);
				}
			}
		} else {
			System.err.println("Pleae ensure that the amount withdrawn is not neagtive");
		}
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNo() {
		return accountNumber;
	}
}

class Customer {
	private String name;
	private Account account;

	Customer(String n, Account a) {
		name = n;
		account = a;
	}

	public void display() {

		System.out.println("Name of the customer : " + name + " \t Account Number : " + account.getAccountNo()
				+ " \t Account Balance : " + account.getBalance());
	}

	public String getName() {
		return name;
	}

	public Account getAccount() {
		return account;
	}
}
