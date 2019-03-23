import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
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
        int arr[] = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int val = fr.nextInt();
            arr[i] = val;
            if (val < min) {
                min = val;
            }
        }
        int mind = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; ) {
            int val = arr[i];
            if (val == min) {
                int count = 1;
                i++;
                boolean flag = false;
                if (i < arr.length && arr[i] == min) {
                    mind = 1;
                    break;
                }
                while (i < arr.length && arr[i] != min) {
                    flag = true;
                    i++;
                    count++;
                }
                if (i == arr.length) {
                    flag = false;
                }

                if (flag && count < mind) {
                    mind = count;
                }
            } else {
                i++;
            }
        }

        System.out.println(mind);
    }
}
