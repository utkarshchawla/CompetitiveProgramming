import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B275 {
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

    static class node {
        char dir;
        int val;
        int x;
        int y;

        node(char dir, int val, int x, int y) {
            this.dir = dir;
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int[][] matrix = new int[n][m];
        ArrayList<Integer> xval = new ArrayList<>();
        ArrayList<Integer> yval = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = fr.nextLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'B') {
                    xval.add(i);
                    yval.add(j);
                } else matrix[i][j] = 1;
            }
        }

        boolean flag = true;

        for (int i = 0; i < xval.size(); i++) {
            int x = xval.get(i);
            int y = yval.get(i);
            int[][] tmat = new int[n][m];
            node nn = new node('I', 1, x, y);
            Queue<node> q = new ArrayDeque<>();
            q.add(nn);
            helper(q, tmat, matrix);
//            solver(x, y, tmat, matrix, 'I', 1);
            for (int j = 0; j < xval.size(); j++) {
                if (tmat[xval.get(j)][yval.get(j)] != 1 && tmat[xval.get(j)][yval.get(j)] != 2) flag = false;
            }
        }

        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void helper(Queue<node> q, int[][] tmat, int[][] matrix) {
        while (!q.isEmpty()) {
            node top = q.poll();

            if (top.x < 0 || top.x >= tmat.length || top.y < 0 || top.y >= tmat[0].length) continue;
            if (tmat[top.x][top.y] == 0) tmat[top.x][top.y] = top.val;
            else tmat[top.x][top.y] = Math.min(tmat[top.x][top.y], top.val);

            if (top.x - 1 >= 0 && matrix[top.x - 1][top.y] == 0 && tmat[top.x - 1][top.y] == 0) {
                if (top.dir == 'u' || top.dir == 'I') q.add(new node('u', top.val, top.x - 1, top.y));
                else q.add(new node('u', top.val + 1, top.x - 1, top.y));
            }

            if (top.x + 1 < matrix.length && matrix[top.x + 1][top.y] == 0 && tmat[top.x + 1][top.y] == 0) {
                if (top.dir == 'd' || top.dir == 'I') q.add(new node('d', top.val, top.x + 1, top.y));
                else q.add(new node('d', top.val + 1, top.x + 1, top.y));
            }

            if (top.y + 1 < matrix[0].length && matrix[top.x][top.y + 1] == 0 && tmat[top.x][top.y + 1] == 0) {
                if (top.dir == 'r' || top.dir == 'I') q.add(new node('r', top.val, top.x, top.y + 1));
                else q.add(new node('r', top.val + 1, top.x, top.y + 1));
            }

            if (top.y - 1 >= 0 && matrix[top.x][top.y - 1] == 0 && tmat[top.x][top.y - 1] == 0) {
                if (top.dir == 'l' || top.dir == 'I') q.add(new node('l', top.val, top.x, top.y - 1));
                else q.add(new node('l', top.val + 1, top.x, top.y - 1));
            }
        }
    }

//    private static void solver(int x, int y, int[][] tmat, int[][] matrix, char dir, int val) {
//        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)return;
//        if(matrix[x][y] == 1 || tmat[x][y] != 0)return;
//        tmat[x][y] = val;
//        if(dir == 'u' || dir == 'I')solver(x - 1,y,tmat,matrix,'u',val);
//        else solver(x - 1,y,tmat,matrix,'u',val + 1);
//
//        if(dir == 'd' || dir == 'I')solver(x + 1,y,tmat,matrix,'d',val);
//        else solver(x + 1,y,tmat,matrix,'d',val + 1);
//
//        if(dir == 'r' || dir == 'I')solver(x,y + 1,tmat,matrix,'r',val);
//        else solver(x,y + 1,tmat,matrix,'r',val + 1);
//
//        if(dir == 'l' || dir == 'I')solver(x ,y - 1,tmat,matrix,'l',val);
//        else solver(x,y - 1,tmat,matrix,'l',val + 1);
//
//    }
}
