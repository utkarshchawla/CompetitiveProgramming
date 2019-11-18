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

    public static FastReader fr = new FastReader();
    public static FastWriter fw = new FastWriter();

    static class CCGraph {
        static final int MAXV = 200001;
        static final int MAXDEGREE = 1000;
        public int edges[][] = new int[MAXV + 1][MAXDEGREE];
        public int degree[] = new int[MAXV + 1];
        public int nvertices;
        public int nedges;

        CCGraph() {
            nvertices = nedges = 0;
            for (int i = 1; i <= MAXV; i++)
                degree[i] = 0;
        }

        void read_CCGraph(boolean directed) {
            int x, y;

            nvertices = fr.nextInt();
            int m = fr.nextInt();
            for (int i = 1; i <= m; i++) {
                x = fr.nextInt();
                y = fr.nextInt();
                insert_edge(x, y, directed);
            }

        }

        void insert_edge(int x, int y, boolean directed) {
            edges[x][degree[x]] = y;
            degree[x]++;
            if (!directed)
                insert_edge(y, x, true);
            else
                nedges++;
        }

        void print_CCGraph() {
            for (int i = 1; i <= nvertices; i++) {
                System.out.printf("%d: ", i);
                for (int j = degree[i] - 1; j >= 0; j--)
                    System.out.printf(" %d", edges[i][j]);
                System.out.printf("\n");
            }
        }
    }


    static final int MAXV = 100;
    static boolean processed[] = new boolean[MAXV];
    static boolean discovered[] = new boolean[MAXV];
    static int parent[] = new int[MAXV];

    static ArrayList<Integer> bfs(CCGraph g, int start) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<Integer>();
        int i, v;
        q.offer(start);
        discovered[start] = true;
        while (!q.isEmpty()) {
            v = q.remove();
//            process_vertex(v);
            list.add(v);
            processed[v] = true;
            for (i = g.degree[v] - 1; i >= 0; i--) {
                if (!discovered[g.edges[v][i]]) {
                    q.offer(g.edges[v][i]);
                    discovered[g.edges[v][i]] = true;
                    parent[g.edges[v][i]] = v;
                }
            }
        }
        return list;
    }

    static void initialize_search(CCGraph g) {
        for (int i = 1; i <= g.nvertices; i++) {
            processed[i] = discovered[i] = false;
            parent[i] = -1;
        }
    }

//    static void process_vertex(int v) {
//        System.out.printf(" %d", v);
//    }

    public static void connected_components(CCGraph g, ArrayList<ArrayList<Integer>> list) {
        int c;
        initialize_search(g);
        c = 0;
        for (int i = 1; i <= g.nvertices; i++) {
            if (!discovered[i]) {
//                c++;
                list.add(new ArrayList<>(bfs(g, i)));
            }
        }
    }

    static public void main(String[] args) {
        CCGraph g = new CCGraph();
        g.read_CCGraph(false);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        connected_components(g, list);
        for(ArrayList<Integer> tl : list)tl.sort(null);
        System.out.println(list);
    }
}
