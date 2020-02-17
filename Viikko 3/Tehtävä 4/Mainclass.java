import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mainclass {
	public static void main(String[] args) {
		int selection = 0;
		boolean notStopped = true;
		BottleDispenser automaatti = new BottleDispenser();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
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
	        		automaatti.addMoney();
	        		break;
	        	case 2:
	        		automaatti.buyBottle();
	        		break;
	        	case 3:
	        		automaatti.returnMoney();
	        		break;
	        	case 4:
	        		automaatti.listBottles();
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
}
