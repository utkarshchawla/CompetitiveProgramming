import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> zer = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        int minNegIdx = -1;
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = fr.nextInt();
            if (arr[i] == 0) zer.add(i + 1);
            else if (arr[i] < 0) {
                neg.add(i + 1);
                if (temp < arr[i]) {
                    minNegIdx = i + 1;
                    temp = arr[i];
                }
            } else pos.add(i + 1);
        }
        while (zer.size() > 1) {
            fw.println("1 " + zer.get(zer.size() - 1) + " " + zer.get(zer.size() - 2));
            zer.remove(zer.size() - 1);
        }
        if (neg.size() % 2 == 0) {
            if (zer.size() == 1 && (neg.size() > 0 || pos.size() > 0)) fw.println("2 " + zer.get(0));
        } else {
            if (zer.size() == 1) {
                fw.println("1 " + minNegIdx + " " + zer.get(0));
                neg.remove(neg.indexOf(minNegIdx));
                if (pos.size() > 0 || neg.size() > 0)
                    fw.println("2 " + zer.get(0));
            } else {
                fw.println("2 " + minNegIdx);
                neg.remove(neg.indexOf(minNegIdx));
                pos.addAll(neg);
                neg.clear();
            }
        }
        for (int i = 0; i < neg.size(); i += 2) {
            pos.add(neg.get(i + 1));
            fw.println("1 " + neg.get(i) + " " + neg.get(i + 1));
        }

        while (pos.size() > 1) {
            fw.println("1 " + pos.get(pos.size() - 1) + " " + pos.get(pos.size() - 2));
            pos.remove(pos.size() - 1);
        }
        fw.close();

    }
}
