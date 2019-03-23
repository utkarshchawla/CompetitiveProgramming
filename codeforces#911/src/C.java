import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class C {
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
        int a = fr.nextInt();
        int b = fr.nextInt();
        int c = fr.nextInt();
        boolean flag = false;
        if (a == 1 || b == 1 || c == 1) {
            flag = true;
        }
        if (a == 3 && b == 3 && c == 3) {
            flag = true;
        }
        if (a == 2 && b == 2 || a == 2 && c == 2 || c == 2 && b == 2) {
            flag = true;
        }

        if (a == 4 && b == 4 && c == 2 || a == 4 && c == 4 && b == 2 || a == 2 && c == 4 && b == 4) {
            flag = true;
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
