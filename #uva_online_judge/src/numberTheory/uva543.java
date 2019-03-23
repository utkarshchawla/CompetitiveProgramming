package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva543 {
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        ArrayList<Long> seive = seive(1000000);
//        System.out.println(seive.size());
        while (true) {
            int n = fr.nextInt();
            if (n == 0) break;
            int si = 0;
            int fi = BSJustLess(seive, n);
            while (si <= fi) {
                long sum = seive.get(si) + seive.get(fi);
                if (sum > n) {
                    fi--;
                } else if (sum < n) {
                    si++;
                } else {
                    break;
                }
            }

            if (si > fi) {
                System.out.println("Goldbach's conjecture is wrong");
            } else {
                System.out.println(n + " = " + seive.get(si) + " + " + seive.get(fi));
            }
        }
    }

    public static ArrayList<Long> seive(int n) {
        boolean[] arr = new boolean[n + 1];
        ArrayList<Long> rlist = new ArrayList<>();
        arr[0] = true;
        arr[1] = true;
        for (long i = 2; i < arr.length; i++) {
            if (!arr[(int) i]) {
                for (long j = i * i; j < arr.length; j += i) {
                    arr[(int) j] = true;
                }
                rlist.add(i);
            }
        }
        return rlist;
    }

    public static int BSJustLess(ArrayList<Long> list, int val) {
        int lo = 0;
        int hi = list.size() - 1;
        int floor = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) > val) {
                hi = mid - 1;
            } else if (list.get(mid) < val) {
                lo = mid + 1;
                floor = mid;
            } else {
                return mid;
            }
        }
        return floor;
    }
}


