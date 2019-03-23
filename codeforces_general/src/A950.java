import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A950 {
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
        int l = fr.nextInt();
        int r = fr.nextInt();
        int a = fr.nextInt();
        int ans = -1;

        if (l > r) {
            if (a > l - r) {
                a -= (l - r);
                ans = (l + a / 2) * 2;
            } else {
                ans = 2 * (r + a);
            }
        } else {
            if (a > r - l) {
                a -= (r - l);
                ans = (r + a / 2) * 2;
            } else {
                ans = 2 * (l + a);
            }
        }

        System.out.println(ans);
    }
}
