import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int start = (int) solver(n);
        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i <= n; i++) {
            ans = Math.min(ans, (int) solver(i));
        }
//        list.sort(null);
        System.out.println(ans);

    }

//    public static int solver(int n, boolean prime[]) {
//        int rv = 0;
//        for (int i = n - 1; i >= 2; i--) {
//            if (prime[i] && n % i == 0) {
//                rv = i;
//                break;
//            }
//        }
//
//        return n - rv + 1;
//    }

    public static long solver(long n) {
        long temp = n;
        long maxPrime = -1;
        while (n % 2 == 0) {
            maxPrime = 2;
            n >>= 1;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }
        if (n > 2)
            maxPrime = n;

        if (maxPrime == temp) {
            maxPrime = 1;
        }
        return temp - maxPrime + 1;
    }

}
