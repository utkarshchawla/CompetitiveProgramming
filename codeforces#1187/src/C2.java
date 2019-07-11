import com.sun.management.UnixOperatingSystemMXBean;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C2 {
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

    public static class Pair implements Comparable<Pair> {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int compareTo(Pair obj) {
            if (this.left == obj.left) {
                return (this.right - this.left) - (obj.right - obj.left);
            }
            return this.left - obj.left;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int[] arr = new int[n];
        int m = fr.nextInt();
        ArrayList<Pair> sorted = new ArrayList<>();
        ArrayList<Pair> unsorted = new ArrayList<>();
        while (m-- > 0) {
            int t = fr.nextInt();
            if (t == 1) sorted.add(new Pair(fr.nextInt() - 1, fr.nextInt() - 1));
            else unsorted.add(new Pair(fr.nextInt() - 1, fr.nextInt() - 1));
        }
        sorted.sort(null);
        unsorted.sort(null);
        int x = 100000000;
//        for (int i = sorted.get(0).left; i <= sorted.get(0).right; i++) arr[i] = x;
        for (int i = 0; i < sorted.size(); i++) {
//            if (sorted.get(i).left > sorted.get(i - 1).right) x--;
            for (int j = sorted.get(i).left; j <= sorted.get(i).right; j++) arr[j] = x;
        }
        x--;
        for (int i = 0; i < unsorted.size(); i++) {
            if (issorted(arr, unsorted.get(i).left, unsorted.get(i).right)) {
                System.out.println("No");
                return;
            }

            for (int j = unsorted.get(i).left; j <= unsorted.get(i).right; j++) {
                if (arr[j] == 0) {
                    arr[j] = x;
                    x--;
                }
            }
            if (issorted(arr, unsorted.get(i).left, unsorted.get(i).right)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static boolean issorted(int[] arr, int l, int r) {
        if (arr[l] == 0) return false;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
