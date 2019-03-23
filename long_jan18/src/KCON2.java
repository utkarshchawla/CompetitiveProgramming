import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KCON2 {
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

            long temp = maxSubArray(arr);
            if (k == 1) {
                System.out.println(temp);
            } else {
                long[] pre1 = new long[n];
                pre1[0] = arr[0];
                for (int i = 1; i < n; i++) {
                    pre1[i] = pre1[i - 1] + arr[i];
                }
                long[] pre2 = new long[n];
                pre2[0] = arr[arr.length - 1];
                for (int i = 1; i < n; i++) {
                    pre2[i] = pre2[i - 1] + arr[n - 1 - i];
                }

//            int li = -1;
                long rs = Long.MIN_VALUE;
                for (long aPre : pre1) {
                    if (aPre > rs) {
                        rs = aPre;
                    }
                }

                long ls = Long.MIN_VALUE;
                for (long aPre : pre2) {
                    if (aPre > ls) {
                        ls = aPre;
                    }
                }

                long ans = rs + ls;
                if (pre1[n - 1] >= 0) {
                    ans += (k - 2) * pre1[n - 1];
                }
                System.out.println(Math.max(ans, temp));
            }
        }
    }

    public static long maxSubArray(int[] arr) {
        long maxSum, maxGlobalSum;
        maxSum = maxGlobalSum = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            maxSum = arr[i] > arr[i] + maxSum ? arr[i] : arr[i] + maxSum;
            maxGlobalSum = maxSum > maxGlobalSum ? maxSum : maxGlobalSum;
        }
        return maxGlobalSum;
    }
}