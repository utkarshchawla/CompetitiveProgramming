package combinatorics;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class uva763 {
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
        BigInteger[] arr = new BigInteger[101];
        arr[0] = BigInteger.ONE;
        arr[1] = arr[0].add(arr[0]);
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
        Scanner scn = new Scanner(System.in);
        int count = 0;
        while (scn.hasNext()) {
            if (count > 0) {
                System.out.println();
            }
            String a = scn.nextLine();
            String b = scn.nextLine();

            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '1') {
                    sum = sum.add(arr[a.length() - i - 1]);
                }
            }
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '1') {
                    sum = sum.add(arr[b.length() - i - 1]);
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            while (sum.compareTo(BigInteger.ZERO) != 0) {
                int val = binary(arr, sum);
                list.add(val);
                set.add(val);
                sum = sum.subtract(arr[val]);
            }

            if (list.size() == 0) {
                System.out.println("0");
            } else {
                int l = list.get(0) + 1;
                for (int i = 0; i < l; i++) {
                    if (set.contains(l - i - 1)) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }
                System.out.println();
            }
            if (scn.hasNext()) {
                scn.nextLine();
            }
            count++;
        }


    }

    public static int binary(BigInteger[] arr, BigInteger val) {
        int lo = 0;
        int hi = arr.length - 1;
        int floor = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (val.compareTo(arr[mid]) > 0) {
                floor = mid;
                lo = mid + 1;
            } else if (val.compareTo(arr[mid]) < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return floor;

    }
}
