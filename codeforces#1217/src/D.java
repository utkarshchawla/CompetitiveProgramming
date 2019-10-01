import java.io.*;
import java.math.BigInteger;
import java.util.*;

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
        int m = fr.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            HashMap<Integer, Integer> mm = new HashMap<>();
            if (map.containsKey(u)) mm = map.get(u);
            mm.put(v, i);
            map.put(u, mm);
            g.get(u).add(v);
        }
        int[] color = new int[m];
        int[] visited = new int[n];
        Arrays.fill(color, 1);

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0)
                dfs(i, color, visited, g, map);
        }
        boolean flag = false;
        for (int i : color) if (i == 2) flag = true;
        if (flag) System.out.println(2);
        else System.out.println(1);
        for (int i : color) System.out.print(i + " ");
        System.out.println();
    }

    private static void dfs(int u, int[] color, int[] visited, ArrayList<ArrayList<Integer>> g, HashMap<Integer, HashMap<Integer, Integer>> map) {
        visited[u] = 1;
        for (int nbr : g.get(u)) {
            int idx = map.get(u).get(nbr);
            if (visited[nbr] == 0) {
                dfs(nbr, color, visited, g, map);
            } else if (visited[nbr] == 1) {
                color[idx] = 2;
            }
        }
        visited[u] = 2;
    }
}
