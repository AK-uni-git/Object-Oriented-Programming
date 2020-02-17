
import java.util.ArrayList;

public class BottleDispenser {

    private int bottles;

    // The array for the Bottle-objects
    private ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private double money;

    
    public BottleDispenser() {

        this.bottles = 5;
        this.money = 0;

        // Add Bottle-objects to the array
        for(int i = 0; i<bottles; i++) {
            // Use the default constructor to create new Bottles
            bottle_array.add( new Bottle());
        }
    }

    public void addMoney() {

        this.money += 1;
        System.out.println("Klink! Added more money!");
    }

    public void buyBottle() {

        if(this.money >= 1.80) {
            System.out.println("KACHUNK! Pepsi Max came out of the dispenser!");
            this.money -= 1.80;
            this.bottles -= 1;
            this.bottle_array.remove(this.bottles - 1);
        } else {
            System.out.println("Add money first!");
        }
        
    }

    public void listBottles() {
		int counter = 1;
		for (Bottle bottle : bottle_array) {
			System.out.println(counter + ". Name: " + bottle.getName() + "\n	Size: " + bottle.getVolume() + "	Price: " + bottle.getPrice());
			counter++;
			
		}
	}

    public void returnMoney() {

        this.money = 0;
        System.out.println("Klink klink. Money came out!");
    }

}