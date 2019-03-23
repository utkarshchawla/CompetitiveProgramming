import java.util.Scanner;

public class T {
    public static String base62 = "Z0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY";

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter number");
        long val = scn.nextLong();
        StringBuilder sb = new StringBuilder(base62Encode(val));
        System.out.println("dontsms.me/i/DTUASF/" + sb);

    }

    private static String base62Encode(long value) {
        String s = Long.toString(value);
        s = "91" + s;
        value = Long.parseLong(s);
        StringBuilder sb = new StringBuilder();
        while (value != 0) {
            sb.append(base62.charAt((int) (value % 62)));
            value /= 62;
        }
        while (sb.length() < 6) {
            sb.append(0);
        }
        return sb.toString();
    }
}