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

    static class node {
        int s;
        int v;
        int p = -1;

        node(int s, int v) {
            this.s = s;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        node[] arr = new node[n];
        for (int i = 0; i < n; i++) arr[i] = new node(-1, -1);
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int p = fr.nextInt() - 1;
            tree.get(p).add(i);
            arr[i].p = p;
        }
        for (int i = 0; i < n; i++) arr[i].s = fr.nextInt();
        arr[0].v = arr[0].s;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            int idx = q.poll();
            node mn = arr[idx];
            if (mn.s == -1) {
                int min = Integer.MAX_VALUE;
                ArrayList<Integer> child = tree.get(idx);
                if (child.size() <= 1) {
                    mn.s = arr[mn.p].s;
                    mn.v = 0;
                } else {
                    for (int i : child) min = Math.min(min, arr[i].s);
                    if (min < arr[mn.p].s) {
                        System.out.println(-1);
                        return;
                    }
                    mn.s = min;
                    mn.v = mn.s - arr[mn.p].s;
                    for (int i : child) arr[i].v = arr[i].s - min;
                }
            } else if (mn.v == -1) {
                mn.v = mn.s - arr[mn.p].s;
                if (mn.v < 0) {
                    System.out.println(-1);
                    return;
                }
            }

            for (int i : tree.get(idx)) q.add(i);
        }
        long ans = 0;
        for (node nn : arr) ans += nn.v;
        System.out.println(ans);

    }
}
