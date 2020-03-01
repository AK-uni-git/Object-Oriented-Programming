import java.util.Scanner;

public class Mainclass {
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int selection = 0;
		boolean notStopped = true;
        String accountNumber;
        String accountBalance;
        String creditLimit;
		

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
                    accountBalance = in.nextLine();
                    System.out.println("Account number: " + accountNumber);
                    System.out.println("Amount of money: " + accountBalance);
	        		break;
				case 2:
                    System.out.print("Give an account number: ");
                    accountNumber = in.nextLine();
                    System.out.print("Amount of money to deposit: ");
                    accountBalance = in.nextLine();
                    System.out.print("Give a credit limit: ");
                    creditLimit = in.nextLine();
                    System.out.println("Account number: " + accountNumber);
                    System.out.println("Amount of money: " + accountBalance);
                    System.out.println("Credit: " + creditLimit);
                    break;
                case 3:
                    System.out.print("Give an account number: ");
                    accountNumber = in.nextLine();
                    System.out.print("Amount of money to deposit: ");
                    accountBalance = in.nextLine();
                    System.out.println("Account number: " + accountNumber);
                    System.out.println("Amount of money: " + accountBalance);
                    break;
                case 4:
                    System.out.print("Give an account number: ");
                    accountNumber = in.nextLine();
                    System.out.print("Amount of money to withdraw: ");
                    accountBalance = in.nextLine();
                    System.out.println("Account number: " + accountNumber);
                    System.out.println("Amount of money: " + accountBalance);
                    break;
                case 5:
                    System.out.print("Give the account number of the account to delete: ");
                    accountNumber = in.nextLine();
                    System.out.println("Account number: " + accountNumber);
                    break;
                case 6:
                    System.out.print("Give the account number of the account to print information from: ");
                    accountNumber = in.nextLine();
                    System.out.println("Account number: " + accountNumber);
                    break;
                case 7:
                    System.out.println("Prints every account");
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