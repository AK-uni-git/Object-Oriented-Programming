import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Bank() {}

    public void addNormalAccount(String number, int balance) {
        accounts.add(new NormalAccount(number, balance));
        System.out.println("Account created.");
    }

    public void addCreditAccount(String number, int balance, int creditLimit) {
        accounts.add(new CreditAccount(number, balance, creditLimit));
        System.out.println("Account created.");
    }

    public void deposit(String number, int amount) {
        Account account = getAccount(number);
        if(account == null) {
            System.out.println("Error, no account found.");
            return;
        } else {
            account.addMoney(amount);
        }
    }

    public void withdraw(String number, int amount) {
        Account account = getAccount(number);
        if(account == null) {
            System.out.println("Error, no account found.");
            return;
        } else {
            account.deductMoney(amount);
        }
    }

    public void removeAccount(String number) {
        Account account = getAccount(number);
        if(account == null) {
            System.out.println("Error, no account found.");
            return;
        } else {
            accounts.remove(account);
            System.out.println("Account removed.");
        }
        
    }

    public Account getAccount(String number) {
        for (Account account : accounts) {
            if (account.number.equals(number)) {
                return account;
            }
        }
        return null;
    }

    public void printAll() {
        System.out.println("All accounts:");
        for (Account account : accounts) {
            account.printInfo();
        }
    }
}