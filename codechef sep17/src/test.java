import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = 0;
        while (n != 0){
            ans += n%10;
            ans *= 10;
            n /= 10;
        }
        System.out.println(ans/10);
    }
}
