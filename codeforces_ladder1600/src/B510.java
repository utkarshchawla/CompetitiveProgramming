import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B510 {
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

    static class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj == this) return true;
            pair p = (pair) obj;
            if (p.x == x && p.y == y) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        char[][] arr = new char[n][m];
        HashMap<pair, pair> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = fr.nextLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
                map.put(new pair(i, j), new pair(-1, -1));
            }
        }
        while (true) {
            int x = -1;
            int y = -1;
            o:
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] >= 'A' && arr[i][j] <= 'Z') {
                        x = i;
                        y = j;
                        break o;
                    }
                }
            }
            if (x == -1) break;
            if (dfs(arr, (char) (arr[x][y] + 32), x, y, -1, -1, map)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }

    private static boolean dfs(char[][] arr, char ch, int r, int c, int prer, int prec, HashMap<pair, pair> map) {
        if (map.containsKey(new pair(prer, prec)) && map.get(new pair(prer, prec)).equals(new pair(r, c))) return false;
        if (r >= arr.length || r < 0 || c < 0 || c >= arr[0].length) return false;
        if (arr[r][c] == ch) return true;
        if (arr[r][c] != ch - 32) return false;
        arr[r][c] = ch;
        pair p = new pair(r, c);
        map.put(new pair(r + 1, c), p);
        map.put(new pair(r - 1, c), p);
        map.put(new pair(r, c + 1), p);
        map.put(new pair(r, c - 1), p);
        return dfs(arr, ch, r + 1, c, r, c, map) || dfs(arr, ch, r - 1, c, r, c, map) || dfs(arr, ch, r, c + 1, r, c, map) || dfs(arr, ch, r, c - 1, r, c, map);
    }
}
