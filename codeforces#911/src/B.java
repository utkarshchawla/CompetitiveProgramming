import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    private int s1;

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

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            int j = n - i;
            int s1 = solver(a, i);
            int s2 = solver(b, j);
            ans = Math.max(ans, Math.min(s2, s1));
        }

        System.out.println(ans);
    }

    private static int solver(int a, int i) {
        int arr[] = new int[i];
        Arrays.fill(arr, a / i);
        int rem = a % i;
        int idx = 0;
        while (rem != 0) {
            arr[idx]++;
            rem--;
            idx = (idx + 1) % arr.length;
        }

        Arrays.sort(arr);
        return arr[0];
    }
}
