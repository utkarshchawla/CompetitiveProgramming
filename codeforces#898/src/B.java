import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int a = fr.nextInt();
        int b = fr.nextInt();
        int ax = -1;
        int ay = -1;
        o:
        for (int x = 0; x * a <= n; x++) {
            if((n - x*a)%b == 0){
                ax  = x;
                ay = (n - x*a)/b;
                break o;
            }

//            int ll = 0;
//            int ul = n / b;
//            for (int i = 0; i < 23; i++) {
//                int y = (ll + ul) / 2;
//                int ans = x * a + y * b;
//                if (ans == n) {
//                    ax = x;
//                    ay = y;
//                    break o;
//                } else if (ans > n) {
//                    ul = y - 1;
//                } else {
//                    ll = y + 1;
//                }
//            }
        }

        if (ax == -1 && ay == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(ax + " " + ay);
        }
    }
}
