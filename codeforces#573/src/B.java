import java.io.*;
import java.math.BigInteger;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B {
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
        String s = fr.nextLine();
        String[] arr = s.split(" ");
        Arrays.sort(arr);
        if (arr[0].equals(arr[1]) && arr[1].equals(arr[2])) System.out.println(0);
        else if (arr[2].charAt(0) - 1 == arr[1].charAt(0) && arr[1].charAt(0) - 1 == arr[0].charAt(0) && arr[0].charAt(1) == arr[1].charAt(1) && arr[1].charAt(1) == arr[2].charAt(1))
            System.out.println(0);
        else if (arr[0].equals(arr[1]) || arr[1].equals(arr[2])) System.out.println(1);
        else if ((arr[2].charAt(0) - 1 == arr[1].charAt(0) && arr[1].charAt(1) == arr[2].charAt(1)))
            System.out.println(1);
        else if (arr[1].charAt(0) - 1 == arr[0].charAt(0) && arr[0].charAt(1) == arr[1].charAt(1))
            System.out.println(1);
        else if (arr[2].charAt(0) - 1 == arr[0].charAt(0) && arr[0].charAt(1) == arr[2].charAt(1))
            System.out.println(1);
        else if ((arr[2].charAt(0) - 2 == arr[1].charAt(0) && arr[1].charAt(1) == arr[2].charAt(1)))
            System.out.println(1);
        else if (arr[1].charAt(0) - 2 == arr[0].charAt(0) && arr[0].charAt(1) == arr[1].charAt(1))
            System.out.println(1);
        else if (arr[2].charAt(0) - 2 == arr[0].charAt(0) && arr[0].charAt(1) == arr[2].charAt(1))
            System.out.println(1);
        else System.out.println(2);
    }
}
