import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
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
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
            long sum = 0;
            int count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum % 2 != 0) {
                    count++;
                    sum = 0;
                    list.add(i + 1);
                }
            }
            if(list.size() == 0){
                System.out.println("NO");
                continue;
            }
            list.remove(list.size() - 1);
            list.add(n);
            if (count < k) System.out.println("NO");
            else {
                int diff = count - k;
                if (diff % 2 == 1) System.out.println("NO");
                else {
                    System.out.println("YES");
                    for (int i = 0; i < k - 1; i++) System.out.print(list.get(i) + " ");
                    System.out.println(list.get(list.size() - 1));
                }
            }

        }
    }
}
