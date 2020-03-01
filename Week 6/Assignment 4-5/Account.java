
abstract class Account {
    protected String number;
    protected int balance;


    protected abstract String getAccountNumber();

    protected abstract int getBalance();

    protected abstract void addMoney(int amount);

    protected abstract void deductMoney(int amount);

    protected abstract void printInfo();
    
}


class NormalAccount extends Account{

    public NormalAccount(String number, int balance) {

        this.number = number;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.number;
    }

    public int getBalance() {
        return this.balance;
    }

    public void addMoney(int amount) {
        this.balance += amount;
    }

    public void deductMoney(int amount) {
        if( (this.balance - amount) < 0) {
            System.out.println("Not enough money!");
        } else {
            this.balance -= amount;
        }
        
    }

    public void printInfo() {
        System.out.println("Account number: " + this.number + " Amount of money: " + this.balance);
    }
}

class CreditAccount extends Account{

    private int creditLimit = 0;
    public CreditAccount(String number, int balance, int creditLimit) {

        this.number = number;
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    public String getAccountNumber() {
        return this.number;
    }

    public int getBalance() {
        return this.balance;
    }

    public void addMoney(int amount) {
        this.balance += amount;
    }

    public void deductMoney(int amount) {
        if( (this.balance + creditLimit - amount) < 0) {
            System.out.println("Not enough money!");
        } else {
            this.balance -= amount;
        }
        
    }

    public void printInfo() {
        System.out.println("Account number: " + this.number + " Amount of money: " + this.balance + " Credit limit: " + this.creditLimit);
    }
}


