import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    public void readAndWrite(String inputFile, String outputFile) {
        try {
            BufferedReader in;
            BufferedWriter out;
            
            in = new BufferedReader(new FileReader(inputFile) );
            out = new BufferedWriter(new FileWriter(outputFile) );

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                inputLine.trim();
                if (inputLine.length() < 30 && !inputLine.isEmpty() ) {
                    if (inputLine.charAt(0) != ' ' && inputLine.contains("v")) {
                    out.write(inputLine + "\n");
                    }
                }
                
            }
            in.close();
            out.close();
            
        } catch (IOException ex) {
            System.out.println("File not found!");
        }

    }
}
    