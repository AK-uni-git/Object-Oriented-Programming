import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Mainclass {

	public static void main(String args[]) {

        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Give a name to the dog: ");
        Dog dog1 = new Dog(askInput(reader));
        System.out.print("What does a dog say: ");
        dog1.speak(askInput(reader));

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String askInput(BufferedReader reader) {
        try {
            String line;
            line = reader.readLine();
            return line;
    
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Fail";
    }

}


