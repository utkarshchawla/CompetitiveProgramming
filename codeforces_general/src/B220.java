import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B220 {
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
        int m = fr.nextInt();
        int n = fr.nextInt();
        int[] arr = new int[m];
        HashMap<Integer, Integer>[] hashMaps = new HashMap[m];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = fr.nextInt();
            if (arr[i] > 100000) {
                hashMaps[i] = new HashMap<>();
                continue;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            if (i > 0) {
                map = new HashMap<>(hashMaps[i - 1]);
            }
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
            hashMaps[i] = map;
        }

        while (n-- > 0) {
            int l = fr.nextInt();
            int r = fr.nextInt();
            l--;
            r--;
            int ans = 0;
            if (l == 0) {
                for (int i : hashMaps[r].keySet()) {
                    if (i == hashMaps[r].get(i)) ans++;
                }
            } else {
                for (int i : hashMaps[r].keySet()) {
                    if (hashMaps[l - 1].containsKey(i)) {
                        if (i == (hashMaps[r].get(i) - hashMaps[l - 1].get(i))) ans++;
                    } else {
                        if (i == hashMaps[r].get(i)) ans++;

                    }
                }
            }
            fw.println(ans);
        }
        fw.close();

    }
}
