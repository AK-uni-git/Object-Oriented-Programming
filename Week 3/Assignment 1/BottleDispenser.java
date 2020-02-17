

public class BottleDispenser {

    private int bottles;
    private int money;

    
    public BottleDispenser() {

        this.bottles = 5;
        this.money = 0;
    }

    public void addMoney() {

        this.money += 1;
        System.out.println("Klink! Added more money!");
    }

    public void buyBottle() {

        if(this.money >= 1) {
            System.out.println("KACHUNK! A bottle came out of the dispenser!");
            this.money -= 1;
            this.bottles -= 1;
        } else {
            System.out.println("Add money first!");
        }
        
    }

    public void returnMoney() {

        this.money = 0;
        System.out.println("Klink klink. Money came out!");
    }

}