import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/*  SOURCES:
        https://stackoverflow.com/questions/15667125/read-content-from-files-which-are-inside-zip-file
        https://stackoverflow.com/questions/4473256/reading-text-files-in-a-zip-archive
*/

public class ReadAndWriteIO {

    ReadAndWriteIO() {
    }

    public void readFile(String inputFile) {
        try {
            ZipFile zipFile = new ZipFile(inputFile);

            Enumeration<? extends ZipEntry> entries = zipFile.entries();
        
            while(entries.hasMoreElements()){
                ZipEntry entry = entries.nextElement();
                InputStream stream = zipFile.getInputStream(entry);
                BufferedReader in = new BufferedReader(new InputStreamReader(stream, "UTF-8") );
                String inputLine;
                while((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
                in.close();
            }
            
            zipFile.close();
            
            
        } catch (IOException ex) {
            System.out.println("File not found!");
        }

    }
    
}
    