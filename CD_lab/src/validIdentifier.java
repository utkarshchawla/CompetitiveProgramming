import javax.lang.model.SourceVersion;
import java.util.Scanner;

public class validIdentifier {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the string to be checked: ");
        String str = s.next();

        if (str.length() == 0 || SourceVersion.isKeyword(str)) {
            System.out.println("Invalid");
            return;
        }

        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            System.out.println("Invalid");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                    || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || str.charAt(i) == '$' || str.charAt(i) == '_') {
                continue;
            } else {
                System.out.println("Invalid");
                return;
            }
        }

        System.out.println("Valid");
    }
}
