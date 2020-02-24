import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mainclass {
    
    
    public static void main(String[] args) {
        Character character = new King();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int selection = 0;
		boolean notStopped = true;
		
		

		while (notStopped) {
			menu();
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
                    character = characterSelection(character, in);
	        		break;
				case 2:
                    character.fight();
	        		break;
	        	default:
	        		System.out.println("Unknown choice. Please write an integer.\n");
	        		break;
	        }
        }
        try {
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private static Character characterSelection(Character character, BufferedReader in) {
        int selection = 0;
        boolean notStopped = true;
        while (notStopped) {
            characterMenu();
	        try {
	            selection = Integer.parseInt(in.readLine());
	        } catch(IOException ex) {
	            System.err.println("Wrong input!");
	        }
	        switch (selection) {
	        	case 1:
                    character = new King();
                    notStopped = false;
	        		break;
	        	case 2:
                    character = new Knight();
                    notStopped = false;
	        		break;
				case 3:
                    character = new Queen();
                    notStopped = false;
	        		break;
	        	case 4:
                    character = new Troll();
                    notStopped = false;
	        		break;
	        	default:
	        		System.out.println("Unknown choice. Please write an integer.\n");
	        		break;
	        }
        }
        character = weaponSelection(character, in);
        return character;
    }

    private static Character weaponSelection(Character character, BufferedReader in) {
        int selection = 0;
        boolean notStopped = true;
        while (notStopped) {
            weaponMenu();
	        try {
	            selection = Integer.parseInt(in.readLine());
	        } catch(IOException ex) {
	            System.err.println("Wrong input!");
	        }
	        switch (selection) {
	        	case 1:
                    character.weapon = new Knife();
                    notStopped = false;
	        		break;
	        	case 2:
                    character.weapon = new Axe();
                    notStopped = false;
	        		break;
				case 3:
                    character.weapon = new Sword();
                    notStopped = false;
	        		break;
	        	case 4:
                    character.weapon = new Club();
                    notStopped = false;
	        		break;
	        	default:
	        		System.out.println("Unknown choice. Please write an integer.\n");
	        		break;
	        }
        }
        return character;
    }

    private static void menu() {
        System.out.println("*** BATTLE SIMULATOR ***");
        System.out.println("1) Create a character");
        System.out.println("2) Fight with a character");
        System.out.println("0) Quit");
        System.out.print("Your choice: ");
    }
    private static void characterMenu() {
        System.out.println("Choose your character: ");
        System.out.println("1) King");
        System.out.println("2) Knight");
        System.out.println("3) Queen");
        System.out.println("4) Troll");
        System.out.print("Your choice: ");
    }
    private static void weaponMenu() {
        System.out.println("Choose your weapon: ");
        System.out.println("1) Knife");
        System.out.println("2) Axe");
        System.out.println("3) Sword");
        System.out.println("4) Club");
        System.out.print("Your choice: ");
    }
}