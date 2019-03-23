import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C {
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

    public static class pair implements Comparable<pair> {
        char c;
        int i;

        @Override
        public int compareTo(pair o) {
            return o.i - this.i;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        char[][] arr = new char[50][50];
        pair[] temp = new pair[4];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new pair();
            temp[i].i = fr.nextInt();
        }
        temp[0].c = 'A';
        temp[1].c = 'B';
        temp[2].c = 'C';
        temp[3].c = 'D';

        Arrays.sort(temp);
        int cg = 0;
        int rg = 0;
        pair x = temp[0];
        temp[0] = temp[3];
        temp[3] = x;
        for (int i = 0; i < temp.length; i++) {
            int count = temp[i].i;
            char c = temp[i].c;
            while(true){

            }
        }


        char c = temp[0].c;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == '\u0000') fw.print(c);
                else fw.print(arr[i][j]);
            }
            fw.println("");
        }
        fw.close();
    }
}
