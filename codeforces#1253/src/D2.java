import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D2 {
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
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        ArrayList<Interval> il = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Interval ip = new Interval(Integer.MAX_VALUE, Integer.MIN_VALUE);
                bfs(i, g, visited, ip);
                il.add(ip);
            }
        }

        int ans = insert(il);
        System.out.println(ans);


    }

    public static int insert(ArrayList<Interval> intervals) {
        Comparator<Interval> cpm = (o1, o2) -> o1.start - o2.start;
        intervals.sort(cpm);
        int ans = 0;
        int i = 0;
        int j = i + 1;
        while (j < intervals.size()) {
            if (intervals.get(j).start <= intervals.get(i).end) {
                if (intervals.get(j).end > intervals.get(i).end) {
                    intervals.get(i).end = intervals.get(j).end;
                }
                ans++;
                j++;
            } else {
                i = j;
                j++;
            }
        }

        return ans;

    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void bfs(int idx, ArrayList<ArrayList<Integer>> g, boolean[] visited, Interval ip) {
        visited[idx] = true;
        ip.start = Math.min(ip.start, idx);
        ip.end = Math.max(ip.end, idx);
        for (int nbrs : g.get(idx)) {
            if (!visited[nbrs]) {
                bfs(nbrs, g, visited, ip);
            }
        }
    }
}
