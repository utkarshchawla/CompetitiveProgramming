import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> check = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (check.contains(arr[i])) {
                    fw.println(-1);
                    fw.close();
                    return;
                }
                check.add(arr[i]);
                set.add(arr[i]);
            } else {
                arr[i] = -arr[i];
                if (!set.contains(arr[i])) {
                    fw.println(-1);
                    fw.close();
                    return;
                }
                set.remove(arr[i]);
                if (set.isEmpty()) {
                    list.add(i);
                    check = new HashSet<>();
                }
            }
        }

        if(!set.isEmpty()){
            fw.print(-1);
            fw.close();
            return;
        }
        fw.println(list.size());
        fw.print(list.get(0) + 1 + " ");
        for (int i = 1; i < list.size(); i++) {
            fw.print(list.get(i) - list.get(i - 1) + " ");
        }
        fw.println("");
        fw.close();
    }
}
