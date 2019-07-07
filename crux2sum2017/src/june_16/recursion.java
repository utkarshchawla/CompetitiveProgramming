package june_16;


public class recursion {

    public static void main(String[] args) {

        PDIskips(6);
        // System.out.println(factorial(5));
        // System.out.println(powerpoor(3, 7));
//        System.out.println(powergood(2, 12));
    }

    public static void PDIskips(int n) {
        if (n == 0) {
            return;
        }
        if (n % 2 != 0) {
            System.out.println("hi " + n);

        }
        PDIskips(n - 1);
        if (n % 2 == 0) {
            System.out.println("bye " + n);

        }
    }

    // public static void PDDskips2(int n){
    //
    // if(n == -1){
    // return;
    // }
    //
    // System.out.println("hi " + n);
    // PDDskips2(n - 2);
    // n++;
    // System.out.println("bye " + n);
    //
    // }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int fnm1 = factorial(n - 1);
        return n * fnm1;
    }

    public static int powerpoor(int x, int n) {

        if (n == 0) {
            return 1;
        }

        int xpnm1 = powerpoor(x, n - 1);
        return x * xpnm1;

    }

    public static int powergood(int x, int n) {
        int p = 0;

        if (n == 0) {
            return 1;
        }

        int xpnm1 = powergood(x, n / 2);
        p = xpnm1 * xpnm1;
        if (n % 2 != 0) {
            p = p * x;
        }

        return p;
    }

}
