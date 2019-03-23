import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class E_1 {
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

    static class Pair {
        int l;
        int r;

        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int[] arr = new int[n];
        Pair[] sub = new Pair[m];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
        for (int i = 0; i < sub.length; i++) sub[i] = new Pair(fr.nextInt() - 1, fr.nextInt() - 1);
        int ans = 0;
        ArrayList<Integer> ansl = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ArrayList<Integer> list = new ArrayList<>();
                int small = arr[i];
                int large = arr[j];
                int k = 0;
                for (Pair p : sub) {
                    if (i >= p.l && i <= p.r && (j < p.l || j > p.r)) {
                        small--;
                        list.add(k);
                    }
                    k++;
                }

                if (large - small > ans) {
                    ans = large - small;
                    ansl = new ArrayList<>(list);
                }

                list = new ArrayList<>();
                small = arr[j];
                large = arr[i];
                k = 0;
                for (Pair p : sub) {
                    if (j >= p.l && j <= p.r && (i < p.l || i > p.r)) {
                        small--;
                        list.add(k);
                    }
                    k++;
                }

                if (large - small > ans) {
                    ans = large - small;
                    ansl = new ArrayList<>(list);
                }
//                int mini = arr[i] > arr[j] ? j : i;
//                int maxi = arr[i] > arr[j] ? i : j;
//                int small = Math.min(arr[i], arr[j]);
//                int large = Math.max(arr[i], arr[j]);
//
//                int k = 0;
//                for (Pair p : sub) {
//                    if (mini >= p.l && mini <= p.r && (maxi < p.l || maxi > p.r)) {
//                        small--;
//                        list.add(k);
//                    }
//                    k++;
//                }
//
//                if (large - small > ans) {
//                    ans = large - small;
//                    ansl = new ArrayList<>(list);
//                }

            }
        }

        fw.println(ans);
        fw.println(ansl.size());
        for (int i : ansl) fw.print(i + 1 + " ");
        fw.println("");
        fw.close();
    }
}
