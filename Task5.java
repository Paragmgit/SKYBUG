import java.util.Scanner;

class BankAccount {

	private double Balance;

	public BankAccount(double intialBalance) {
		this.Balance = intialBalance;
	}

	public double getBalance() {
		return Balance;
	}

	public void deposite(double amount) {
		Balance += amount;
	}

	public boolean withdraw(double amount) {
		if (amount > Balance) {
			System.out.println("Insuffecient balance");
			return false;
		} else {
			Balance -= amount;
			return true;
		}
	}
}

public class Atm {

	private final BankAccount userAcount;

	public Atm(BankAccount account) {
		this.userAcount = account;
	}

	public void displayMenu() {
		System.out.println("Welcome to the ATM");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			displayMenu();
			System.out.println("Enter Your Choice :");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> checkBalance();
			case 2 -> {
				System.out.print("Enter deposit amount: ");
				double depositAmount = sc.nextDouble();
				deposite(depositAmount);
			}
			case 3 -> {
				System.out.print("Enter withdrawal amount: ");
				double withdrawalAmount = sc.nextDouble();
				withdraw(withdrawalAmount);
			}
			case 4 -> {
				exit = true;
				System.out.println("Thank you for using the ATM.");
			}
			default -> System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
		sc.close();
	}

	private void withdraw(double amount) {
		userAcount.withdraw(amount);
		System.out.println("withdrawal succesful. Update Balance :" + userAcount.getBalance());
	}

	private void deposite(double amount) {
		userAcount.deposite(amount);
		System.out.println("Deposite succesful. Update Balance :" + userAcount.getBalance());
	}

	private void checkBalance() {
		double balance = userAcount.getBalance();
		System.out.println("Your Current Balance is :" + balance);
	}

	public static void main(String[] args) {

		BankAccount bankAccount = new BankAccount(500.0);

		Atm atm = new Atm(bankAccount);

		atm.run();
	}

}
