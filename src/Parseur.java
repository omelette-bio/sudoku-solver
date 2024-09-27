import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Parseur {
    public static int[] Parse(String[] filename) {
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            int[] res = new int[81];
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Pattern p = Pattern.compile(",\s");
                String[] elements = p.split(data);
                for (String element : elements) {
                    res[i++]= Integer.parseInt(element);
                }
            }
            myReader.close();
            return res;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new int[0];
    }
}