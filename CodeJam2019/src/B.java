import java.io.*;
import java.math.BigInteger;
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

    static class pair {
        boolean lydia;
        boolean visited;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        for (int c = 1; c <= t; c++) {
            int n = fr.nextInt();
            String p = fr.nextLine();
            pair[][] maze = new pair[n][n];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) maze[i][j] = new pair();
            Lydia(maze, p);
            solve(maze, 0, 0, n, c, new StringBuilder(), p);
        }
    }

    private static void solve(pair[][] maze, int row, int col, int n, int c, StringBuilder ans, String p) {
        if (row >= n || col >= n) return;
        if (row == n - 1 && col == n - 1) {
            System.out.println("Case #" + c + ": " + ans);
            return;
        }
        if (maze[row][col].visited) return;

        if (!maze[row][col].lydia || p.charAt(ans.length()) == 'E') {
            ans.append("S");
            solve(maze, row + 1, col, n, c, ans, p);
            ans.deleteCharAt(ans.length() - 1);
        }
        if (!maze[row][col].lydia || p.charAt(ans.length()) == 'S') {
            ans.append("E");
            solve(maze, row, col + 1, n, c, ans, p);
            ans.deleteCharAt(ans.length() - 1);
        }
        maze[row][col].visited = true;

    }

    private static void Lydia(pair[][] maze, String p) {
        int r = 0, c = 0;
        for (int i = 0; i < p.length(); i++) {
            maze[r][c].lydia = true;
            if (p.charAt(i) == 'E') c++;
            else r++;
        }
    }
}
