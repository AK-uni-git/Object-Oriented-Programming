

public class BottleDispenser {

    private int bottles;

    // The array for the Bottle-objects
    private Bottle[] bottle_array;
    private int money;

    
    public BottleDispenser() {

        this.bottles = 50;
        this.money = 0;

        // Initialize the array
        this.bottle_array = new Bottle[bottles];

        // Add Bottle-objects to the array
        for(int i = 0; i<bottles; i++) {
            // Use the default constructor to create new Bottles
            bottle_array[i] = new Bottle();
        }
    }

    public void addMoney() {

        this.money += 1;
        System.out.println("Klink! Added more money!");
    }

    public void buyBottle() {

        if(this.money >= 1) {
            System.out.println("KACHUNK! Pepsi Max came out of the dispenser!");
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