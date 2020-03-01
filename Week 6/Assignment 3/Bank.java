import java.util.ArrayList;

public class Bank {

    private ArrayList<String> accounts = new ArrayList<String>();

    public Bank() {}

    public void addNormalAccount(String number, int balance) {
        accounts.add("Account number: " + number + " Amount of money: " + balance);
        System.out.println("Adding to bank: " + number + "," + balance);
    }

    public void addCreditAccount(String number, int balance, int creditLimit) {
        accounts.add("Account number: " + number + " Amount of money: " + balance + "Credit limit: " + creditLimit);
        System.out.println("Adding to bank: " + number + "," + balance + "," + creditLimit);
    }

    public void deposit(String number, int amount) {
        System.out.println("Depositing to the account: " + number + " the amount " + amount);
    }

    public void withdraw(String number, int amount) {
        System.out.println("Withdrawing from the account: " + number + " the amount " + amount);
    }

    public void removeAccount(String number) {
        System.out.println("Account removed.");
    }

    public void getAccount(String number) {
        System.out.println("Searching for account: " + number);
    }

    public void printAll() {
        for (String account : accounts) {
            System.out.println(account);
        }
    }
}