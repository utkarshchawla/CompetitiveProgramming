import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KCON {
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
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = fr.nextInt();
            }
            int i = 1;
            int maxGlobalSum = kadan(k, arr, i);

            System.out.println(maxGlobalSum);
        }
    }

    private static int kadan(int k, int[] arr, int i) {
        int maxSum, maxGlobalSum;
        maxSum = maxGlobalSum = arr[0];
        while (k > 0) {
            if (i == arr.length) {
                i = 0;
                k--;
                continue;
            }
            maxSum = arr[i] > arr[i] + maxSum ? arr[i] : arr[i] + maxSum;
            maxGlobalSum = maxSum > maxGlobalSum ? maxSum : maxGlobalSum;
            i++;
        }
        return maxGlobalSum;
    }
}
