import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class D {
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

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

        BigInteger nextBigInteger() {
            try {
                return new BigInteger(nextLine());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int q = fr.nextInt();
        while (q-- > 0) {
            int n = fr.nextInt();
            int[] arr = new int[n];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
                set.add(arr[i]);
            }
            ArrayList<Integer> list = new ArrayList<>(set);
            list.sort(null);
            int min = list.get(0) - 1;
            int max = list.get(list.size() - 1) + 1;
            if (((max + 1) * 1L * (n + 1)) > 10000) {
                int val = helper2(arr, min, max, 0, 1, list);
                fw.println(val);
            } else {
                int[][][][] dp = new int[max + 1][max + 1][n + 1][n + 1];
                int val = helper(arr, min, max, 0, 1, list, dp);
                fw.println(val);
            }


        }
        fw.close();
    }

    public static int helper(int[] arr, int min, int max, int l, int r, ArrayList<Integer> list, int[][][][] dp) {
        if (r == arr.length) {
            int a = Collections.binarySearch(list, min);
            if (a < 0) a = 0;
            else a++;
            int b = Collections.binarySearch(list, max);
            if (b < 0) b = 0;
            else b = list.size() - b;
            return a + b;

        }
        if (dp[min][max][l][r] != 0) {
//            System.out.println("hola");
            return dp[min][max][l][r];
        }
        if (arr[l] <= arr[r]) {
            int tl = l;
            for (int i = l + 1; i <= r; i++) {
                if (arr[i] > min && arr[i] < max) {
                    tl = i;
                    break;
                }
            }
            return helper(arr, min, max, tl, r + 1, list, dp);
        }
        int tr = arr.length;
        int nmin = Math.max(min, arr[r]);
        for (int i = r + 1; i < arr.length; i++) {
            if (arr[i] > nmin && arr[i] < max) {
                tr = i;
                break;
            }
        }
        int a = helper(arr, nmin, max, l, tr, list, dp);
        int tl = r;
        int nmax = Math.min(max, arr[l]);
        for (int i = l - 1; i >= 0; i--) {
            if (arr[i] > min && arr[i] < nmax) {
                tl = i;
                break;
            }
        }
        int b = 10;
        if (tl != r) b = helper(arr, min, nmax, tl, r, list, dp);
        else {
            tr = arr.length;
            for (int i = r + 1; i < arr.length; i++) {
                if (arr[i] > min && arr[i] < nmax) {
                    tr = i;
                    break;
                }
            }
            b = helper(arr, min, nmax, r, tr, list, dp);
        }

        return dp[min][max][l][r] = Math.min(a, b);
    }

    public static int helper2(int[] arr, int min, int max, int l, int r, ArrayList<Integer> list) {
        if (r == arr.length) {
            int a = Collections.binarySearch(list, min);
            if (a < 0) a = 0;
            else a++;
            int b = Collections.binarySearch(list, max);
            if (b < 0) b = 0;
            else b = list.size() - b;
            return a + b;

        }
        if (arr[l] <= arr[r]) {
            int tl = l;
            for (int i = l + 1; i <= r; i++) {
                if (arr[i] > min && arr[i] < max) {
                    tl = i;
                    break;
                }
            }
            return helper2(arr, min, max, tl, r + 1, list);
        }
        int tr = arr.length;
        int nmin = Math.max(min, arr[r]);
        for (int i = r + 1; i < arr.length; i++) {
            if (arr[i] > nmin && arr[i] < max) {
                tr = i;
                break;
            }
        }
        int a = helper2(arr, nmin, max, l, tr, list);
        int tl = r;
        int nmax = Math.min(max, arr[l]);
        for (int i = l - 1; i >= 0; i--) {
            if (arr[i] > min && arr[i] < nmax) {
                tl = i;
                break;
            }
        }
        int b = 10;
        if (tl != r) b = helper2(arr, min, nmax, tl, r, list);
        else {
            tr = arr.length;
            for (int i = r + 1; i < arr.length; i++) {
                if (arr[i] > min && arr[i] < nmax) {
                    tr = i;
                    break;
                }
            }
            b = helper2(arr, min, nmax, r, tr, list);
        }

        return Math.min(a, b);
    }
}
