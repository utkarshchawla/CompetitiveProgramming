package bigInteger;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva343 {
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("").append(String.valueOf(object));
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
        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            String a = scn.next();
            String b = scn.next();
            int minBase1 = 0, minBase2 = 0;
            for (char c : a.toCharArray()) if (minBase1 < c) minBase1 = c;
            for (char c : b.toCharArray()) if (minBase2 < c) minBase2 = c;
            minBase1 = Character.digit((char) minBase1, 36) + 1;
            minBase2 = Character.digit((char) minBase2, 36) + 1;
            boolean flag = false;
            int x = -1, y = -1;
            o:
            for (int i = minBase1; i < 37; i++) {
                for (int j = minBase2; j < 37; j++) {
                    try {
                        if (new BigInteger(a, i).equals(new BigInteger(b, j))) {
                            flag = true;
                            x = i;
                            y = j;
                            break o;
                        }
                    } catch (Exception ignored) {
                    }
                }
            }
            if (!flag) {
                System.out.println(a + " is not equal to " + b + " in any base 2..36");
            } else {
                System.out.println(a + " (base " + x + ") = " + b + " (base " + y + ")");
            }
        }
    }
}
