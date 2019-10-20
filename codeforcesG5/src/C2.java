import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C2 {
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

    static class pair implements Comparable<pair> {
        int a;
        int b;
        int c;
        int id;

        pair(int a, int b, int c, int id) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.id = id;
        }


        @Override
        public int compareTo(pair o) {
            if (o.a == this.a && o.b == this.b) return this.c - o.c;
            if (o.a == this.a) return this.b - o.b;
            return this.a - o.a;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        ArrayList<pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), i + 1));
        list.sort(null);
        boolean visited[] = new boolean[list.size()];
        for (int i = 0; i < list.size() - 1; i++) {
            if (visited[i]) continue;
            pair x = list.get(i);
            pair y = list.get(i + 1);
            if (x.a == y.a && x.b == y.b) {
                fw.println(x.id + " " + y.id);
                visited[i] = visited[i + 1] = true;
            }
        }
        ArrayList<pair> rem = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) rem.add(list.get(i));
        }
        visited = new boolean[rem.size()];
        for (int i = 0; i < rem.size() - 1; i++) {
            if (visited[i]) continue;
            pair x = rem.get(i);
            pair y = rem.get(i + 1);
            if (x.a == y.a) {
                fw.println(x.id + " " + y.id);
                visited[i] = visited[i + 1] = true;
            }
        }

        ArrayList<pair> rem2 = new ArrayList<>();
        for (int i = 0; i < rem.size(); i++) {
            if (!visited[i]) rem2.add(rem.get(i));
        }

        for (int i = 0; i < rem2.size(); i += 2) {
            fw.println(rem2.get(i).id + " " + rem2.get(i + 1).id);
        }
        fw.close();

    }
}
