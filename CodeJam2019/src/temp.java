import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class temp {
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
            int p = fr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
            System.out.println(helper(n, arr, p));
        }
    }

    private static int helper(int n, int[] arr, int p) {
        int[][] bits = new int[(int) Math.log(1e7)][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < bits.length; j++) {
                if ((arr[i] & (int) Math.pow(2, j)) == 0) bits[j][i] = i;
                else {
                    if (i == 0) bits[j][i] = -1;
                    else bits[j][i] = bits[j][i - 1];
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < bits[0].length; j++) {
            set.add(arr[j]);
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < bits.length; i++) {
                int val = j - bits[i][j];
                if (val == 0 || val > j) continue;
                ArrayList<Integer> list = new ArrayList<>();
                if (map.containsKey(val)) list = map.get(val);
                list.add(i);
                map.put(val, list);
//                set.add(~(int) Math.pow(2, i) & arr[j]);
            }
            int val = arr[j];
            ArrayList<Integer> sequence = new ArrayList<>(map.keySet());
            sequence.sort(null);
            Collections.sort(sequence);
            for (int s : sequence) {
                for (int bit : map.get(s)) {
                    val &= ~(int) Math.pow(2, bit);
                }
                set.add(val);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int k : set) {
            System.out.println(k);
            ans = Math.min(ans, Math.abs(k - p));
        }
        return ans;
    }
}
