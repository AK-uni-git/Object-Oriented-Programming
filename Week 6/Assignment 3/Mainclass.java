import java.util.Scanner;

public class Mainclass {
    
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner in = new Scanner(System.in);
        int selection = 0;
		boolean notStopped = true;
        String accountNumber;
        int accountBalance;
        int creditLimit;
		

		while (notStopped) {
			menu();
	        try {
	            selection = Integer.parseInt(in.nextLine());
	        } catch(Exception ex) {
	            System.err.println("Wrong input!");
	        }
	        switch (selection) {
	        	case 0:
	        		notStopped = false;
	        		break;
	        	case 1:
                    System.out.print("Give an account number: ");
                    accountNumber = in.nextLine();
                    System.out.print("Amount of money to deposit: ");
                    accountBalance = Integer.parseInt(in.nextLine());
                    bank.addNormalAccount(accountNumber, accountBalance);
	        		break;
				case 2:
                    System.out.print("Give an account number: ");
                    accountNumber = in.nextLine();
                    System.out.print("Amount of money to deposit: ");
                    accountBalance = Integer.parseInt(in.nextLine());
                    System.out.print("Give a credit limit: ");
                    creditLimit = Integer.parseInt(in.nextLine());
                    bank.addCreditAccount(accountNumber, accountBalance, creditLimit);
                    break;
                case 3:
                    System.out.print("Give an account number: ");
                    accountNumber = in.nextLine();
                    System.out.print("Amount of money to deposit: ");
                    accountBalance = Integer.parseInt(in.nextLine());
                    bank.deposit(accountNumber, accountBalance);
                    break;
                case 4:
                    System.out.print("Give an account number: ");
                    accountNumber = in.nextLine();
                    System.out.print("Amount of money to withdraw: ");
                    accountBalance = Integer.parseInt(in.nextLine());
                    bank.withdraw(accountNumber, accountBalance);
                    break;
                case 5:
                    System.out.print("Give the account number of the account to delete: ");
                    accountNumber = in.nextLine();
                    bank.removeAccount(accountNumber);
                    break;
                case 6:
                    System.out.print("Give the account number of the account to print information from: ");
                    accountNumber = in.nextLine();
                    bank.getAccount(accountNumber);
                    break;
                case 7:
                    System.out.println("All accounts:");
	        		break;
	        	default:
	        		System.out.println("Invalid choice.");
	        		break;
	        }
        }
        in.close();

    }


    private static void menu() {
        System.out.println("\n*** BANK SYSTEM ***");
        System.out.println("1) Add a regular account");
        System.out.println("2) Add a credit account");
        System.out.println("3) Deposit money");
        System.out.println("4) Withdraw money");
        System.out.println("5) Remove an account");
        System.out.println("6) Print account information");
        System.out.println("7) Print all accounts");
        System.out.println("0) Quit");
        System.out.print("Your choice: ");
    }

}