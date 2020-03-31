package com.example.week8;
import java.util.ArrayList;

public class BottleDispenser {


    // The array for the Bottle-objects
    private ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private float money = 0;
    private static BottleDispenser dispenser = new BottleDispenser();

    
    private BottleDispenser() {

    }

    public static BottleDispenser getInstance() {
        return  dispenser;
    }


    public void addBottle(String name, String manufacturer, String total_energy, String volume, float prise) {
		bottle_array.add(new Bottle(name, manufacturer, total_energy, volume, prise ));
	}

	public float getMoney() {
        return money;
    }

    public String addMoney(float sum) {

        this.money += sum;
        return String.format("Klink! Added %.2f€ to the balance!", sum);
    }

    public String buyBottle(Bottle bottle) {
        String returnThis;
        if (this.bottle_array.size() <= 0) {
            returnThis = "Out of bottles";
        } else if (this.money >= bottle.getPrice()) {
            returnThis = "KACHUNK! " + bottle.getName() + " came out of the dispenser!";
            this.money -= bottle.getPrice();
            this.bottle_array.remove(bottle);
        } else {
            returnThis = "Add money first!";
        }
        return  returnThis;
        
    }

    public String listBottles() {
        String returnThis = "";
		int counter = 1;
		for (Bottle bottle : bottle_array) {
		    returnThis += counter + ". Name: " + bottle.getName() + " Size: " + bottle.getVolume() + "	Price: " + bottle.getPrice() + "\n\n";
			counter++;
			
		}
		return returnThis;
	}

    public String returnMoney() {
        float oldMoney = this.money;
        this.money = 0;
        return String.format("Klink klink. Money came out! You got %.2f€ back\n", oldMoney);
        
    }

    public ArrayList generateListOfUniqueBottleNames() {
        ArrayList<String> names = new ArrayList();
        for (Bottle bottle : bottle_array) {
            if (names.contains(bottle.getName() )) {
                continue;
            } else {
                names.add(bottle.getName() );
            }

        }
        return  names;
    }

    public Bottle getBottle(String name, String size) {
        for (Bottle bottle : bottle_array) {
            if (bottle.getName().equals(name) && bottle.getVolume().equals(size)) {
                return bottle;
            }
        }
        return null;
    }

}