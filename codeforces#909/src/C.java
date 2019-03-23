import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int n = fr.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append(fr.nextLine());
        }

        int ans = solver(sb.toString(), 0, sb.length() - 1);
        System.out.println(ans);


    }

    private static int solver(String s, int c, int idx) {
        int[] arr = new int[s.length()];
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.charAt(i) == 's') {
                count++;
            } else {
                arr[i] = count;
                count = 1;
            }
        }

        int ans = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'f') {
                ans *= arr[i];
            }
        }

        return ans;

    }
}
