
import java.util.Scanner;

class Mainclass {

	public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);

        Dog dog1 = new Dog(reader);
        dog1.speak(reader);

        reader.close();
    }
    

}


