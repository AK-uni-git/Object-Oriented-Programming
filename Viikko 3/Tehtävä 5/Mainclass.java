import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mainclass {
	public static void main(String[] args) {
		int selection = 0;
		boolean notStopped = true;
		BottleDispenser dispenser = new BottleDispenser();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		fillDispenser(dispenser);

		while (notStopped) {
			menu();
	        System.out.print("Your choice: ");
	        try {
	            selection = Integer.parseInt(in.readLine());
	        } catch(IOException ex) {
	            System.err.println("Wrong input!");
	        }
	        switch (selection) {
	        	case 0:
	        		notStopped = false;
	        		break;
	        	case 1:
	        		dispenser.addMoney();
	        		break;
				case 2:
					dispenser.listBottles();
					System.out.print("Your choice: ");
					int bottle_id = 0;
					try {
	    	            bottle_id = Integer.parseInt(in.readLine());
	    	        } catch(IOException ex) {
	    	            System.err.println("Virheellinen syöte!");
	    	        }
	        		dispenser.buyBottle(bottle_id);
	        		break;
	        	case 3:
	        		dispenser.returnMoney();
	        		break;
	        	case 4:
	        		dispenser.listBottles();
	        		break;
	        	default:
	        		System.out.println("Unknown choice. Please write an iteger.\n");
	        		break;
	        }
		}
    
		
	}
	private static void menu() {
		String menuText = "\n*** BOTTLE DISPENSER ***\n"
		         		+ "1) Add money to the machine\n"
		         		+ "2) Buy a bottle\n"
		         		+ "3) Take money out\n"
		         		+ "4) List bottles in the dispenser\n"
		         		+ "0) End";
		System.out.println(menuText);
	}

	private static void fillDispenser(BottleDispenser dispenser) {
		dispenser.addBottle("Pepsi Max", "Pepsi", "0.3", "0.5", 1.8f);
		dispenser.addBottle("Pepsi Max", "Pepsi", "0.9", "1.5", 2.2f);
		dispenser.addBottle("Coca-Cola Zero", "Coca Cola Company", "0.3", "0.5", 2.0f);
		dispenser.addBottle("Coca-Cola Zero", "Coca Cola Company", "0.9", "1.5", 2.5f);
		dispenser.addBottle("Fanta Zero", "Coca Cola Company", "0.3", "0.5", 1.95f);
	}
}
