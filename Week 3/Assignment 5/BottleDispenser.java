
import java.util.ArrayList;

public class BottleDispenser {


    // The array for the Bottle-objects
    private ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private float money;

    
    public BottleDispenser() {
        this.money = 0;
    }

    public void addBottle(String name, String manufacturer, String total_energy, String volume, float prise) {
		bottle_array.add(new Bottle(name, manufacturer, total_energy, volume, prise ));
	}

    public void addMoney() {

        this.money += 1;
        System.out.println("Klink! Added more money!");
    }

    public void buyBottle(int bottle_id) {

        Bottle bottle = bottle_array.get(bottle_id - 1);
        if (this.bottle_array.size() <= 0) {
            System.out.println("Out of bottles");
        } else if (this.money >= bottle.getPrice()) {
            System.out.println("KACHUNK! " + bottle.getName() + " came out of the dispenser!");
            this.money -= bottle.getPrice();
            this.bottle_array.remove(bottle_id - 1);
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

        System.out.printf("Klink klink. Money came out! You got %.2f€ back\n", money);
        this.money = 0;
        
    }

}