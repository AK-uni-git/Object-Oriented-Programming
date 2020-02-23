import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndWriteIO {

    ReadAndWriteIO() {}

    public void readFile() {
        try {
            BufferedReader in;
            in = new BufferedReader(new FileReader("input.txt"));
            String inputLine;
            while((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
            
        } catch (IOException ex) {
            System.out.println("File not found!");
        }

    }
    
}
    