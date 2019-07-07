import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D {
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
        int n = fr.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        HeapMover m = new HeapMover();
        m.flag = true;
        boolean visited[] = new boolean[n];
        helper(g, 0, -1, m, visited);
        if (m.flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static class HeapMover {
        boolean flag;
    }

    public static void helper(ArrayList<ArrayList<Integer>> g, int c, int p, HeapMover m, boolean[] visited) {
        visited[c] = true;
        if (p != -1) {
//            if (g.get(c).size() == 1) {
                if (g.get(p).size() == 2) m.flag = false;
//            }
        }

        for(int ch : g.get(c)){
            if(!visited[ch]){
                helper(g,ch,c,m,visited);
            }
        }
    }
}
