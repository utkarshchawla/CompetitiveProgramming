import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MONSTER {
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
        int[] arr = new int[n];
        int count = n;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = fr.nextInt();
        }
        int q = fr.nextInt();
        while (q-- > 0) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= 0) {
                    continue;
                }
                if ((i & x) == i) {
                    arr[i] -= y;
                }
                if (arr[i] <= 0) {
                    count--;
                }
            }
            System.out.println(count);
        }
    }
}
