package june_7;

public class prime {

    public static void main(String[] args) {
        for (int i = 0; i <= 16; i++) {
            System.out.print(i + " ");
            System.out.println(isprime(i));
        }
    }

    public static boolean isprime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        }
        int r = 2;
        while (r < n) {
            if (n % r == 0) return false;
            r++;
        }

        return true;
    }

}
