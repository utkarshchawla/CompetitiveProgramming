import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountComments {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\src.txt"));
        String line = reader.readLine();
        int single = 0;
        int multi = 0;

        while (line != null) {
            while (line.length() > 0 && line.charAt(0) == ' ') line = line.substring(1);
            if (line.contains("//")) {
                single++;
                line = reader.readLine();
                continue;
            }
            if (line.contains("/*")) {
                multi++;
                line = reader.readLine();
                while (line != null && !line.contains("*/")) line = reader.readLine();
            }
            line = reader.readLine();
        }
        System.out.println("Number of single comments is " + single + "\nNumber of multi comments is " + multi);
    }
}