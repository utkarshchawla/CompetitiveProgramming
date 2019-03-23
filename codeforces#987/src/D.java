import com.sun.corba.se.impl.orbutil.graph.Graph;

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

    public static class Vertex {
        HashMap<Integer, Integer> nbrs = new HashMap<>();
        int val;
        long weight;
    }

    public static HashMap<Integer, Vertex> vces = new HashMap<>();

    public static void addVertex(int vname, int val) {
        if (vces.containsKey(vname)) {
            return;
        }

        Vertex v = new Vertex();
        v.val = val;
        vces.put(vname, v);
    }

    public static void addEdge(Integer v1name, Integer v2name, int weight) {
        if (vces.get(v1name) == null || vces.get(v2name) == null) {
            return;
        }

        vces.get(v1name).nbrs.put(v2name, weight);
        vces.get(v2name).nbrs.put(v1name, weight);
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int k = fr.nextInt();
        int s = fr.nextInt();
        for (int i = 0; i < n; i++) {
            addVertex(i + 1, fr.nextInt());
        }
        for (int i = 0; i < m; i++) {
            addEdge(fr.nextInt(), fr.nextInt(), 1);
        }

        for (int i = 0; i < n; i++) {
            Vertex v = vces.get(i + 1);
            v.weight = 0;
            HashMap<Integer, Long> map = new HashMap<>();
            LinkedList<Vertex> list = new LinkedList<>();
            list.addLast(v);
            long ans = 0;
            while (map.size() < s) {
                Vertex rv = list.removeFirst();
                for (int j : rv.nbrs.keySet()) {
                    Vertex temp = new Vertex();
                    temp.val = vces.get(j).val;
                    temp.nbrs = vces.get(j).nbrs;
                    temp.weight = rv.weight + 1;
                    list.addLast(temp);
                }

                if (map.containsKey(rv.val)) {
                    if (rv.weight >= map.get(rv.val)) continue;
                    ans -= map.get(rv.val);
                }

                ans += rv.weight;
                map.put(rv.val, rv.weight);
            }
            fw.print(ans + " ");
        }
        fw.close();
    }
}
