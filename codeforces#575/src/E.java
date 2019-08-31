import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class E {
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
        char t;

        pair(int x, int y, char t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        while (t-- > 0) {
            int b = fr.nextInt();
            int w = fr.nextInt();
            LinkedList<pair> q = new LinkedList<>();
            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            ArrayList<Integer> rr = new ArrayList<>();
            ArrayList<Integer> cr = new ArrayList<>();
            q.add(new pair(100000, 100000, 'w'));
            HashSet<Integer> set = new HashSet<>();
            if (map.containsKey(100000)) set = map.get(100000);
            set.add(100000);
            map.put(100000, set);
            w--;
            rr.add(100000);
            cr.add(100000);
            int[] row = {1, -1, 0, 0};
            int[] col = {0, 0, 1, -1};
            while (q.size() > 0) {
                pair tp = q.removeFirst();
                int count = b;
                char c = 'b';
                if (tp.t == 'b') {
                    count = w;
                    c = 'w';
                }
                for (int i = 0; i < 4 && count > 0; i++) {
                    int nr = tp.x + row[i];
                    int nc = tp.y + col[i];
                    if(nr < 1 || nr > 1000000000 || nc < 1 || nc > 1000000000)continue;
                    HashSet<Integer> ms = new HashSet<>();
                    if (map.containsKey(nr)) ms = map.get(nr);
                    if (ms.contains(nc)) continue;
                    ms.add(nc);
                    map.put(nr, ms);
                    rr.add(nr);
                    cr.add(nc);
                    q.add(new pair(nr, nc, c));
                    count--;
                }
                if (tp.t == 'b') w = count;
                else b = count;
            }
            if(b != 0 || w != 0) System.out.println("NO");
            else{
                System.out.println("YES");
                for(int i = 0; i < rr.size(); i++){
                    System.out.println(rr.get(i) + " " + cr.get(i));
                }
            }
        }
    }
}
