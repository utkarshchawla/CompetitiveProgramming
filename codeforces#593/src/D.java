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
        int k = fr.nextInt();
        HashMap<Integer, ArrayList<Integer>> row = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> col = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            ArrayList<Integer> lr = new ArrayList<>();
            if (row.containsKey(x)) lr = row.get(x);
            lr.add(y);
            row.put(x, lr);
            ArrayList<Integer> lc = new ArrayList<>();
            if (col.containsKey(y)) lc = col.get(y);
            lc.add(x);
            col.put(y, lc);
        }

        for (ArrayList<Integer> tl : row.values()) tl.sort(null);
        for (ArrayList<Integer> tl : col.values()) tl.sort(null);
        int dir = 1;
        int cr = 1;
        int cc = 1;
        int maxr = n + 1;
        int maxc = m + 1;
        int minr = 0;
        int minc = 0;
        int count = 0;
        while (true) {
            if (cr >= maxr || cr <= minr || cc >= maxc || cc <= minc) break;
            if (row.containsKey(cr) && Collections.binarySearch(row.get(cr), cc) >= 0) break;
            if (dir == 1) {
                ArrayList<Integer> list = row.get(cr);
                int idx = -1;
                if (row.containsKey(cr)) {
                    idx = Collections.binarySearch(list, cc);
                    idx = -(idx + 1);
                }
                if (idx == -1 || idx == list.size()) {
                    count += maxc - cc;
                    cc = maxc - 1;
                } else {
                    int nc = Math.min(list.get(idx), maxc - 1);
                    count += nc - cc;
                    cc = nc - 1;
                }
                cr++;
                minr++;
                dir = 2;
            } else if (dir == 2) {
                ArrayList<Integer> list = col.get(cc);
                int idx = -1;
                if (col.containsKey(cc)) {
                    idx = Collections.binarySearch(list, cr);
                    idx = -(idx + 1);
                }
                if (idx == -1 || list.size() == idx) {
                    count += maxr - cr;
                    cr = maxr - 1;
                } else {
                    int nr = Math.min(list.get(idx), maxr - 1);
                    count += nr - cr;
                    cr = nr - 1;
                }
                cc--;
                maxc--;
                dir = 3;
            } else if (dir == 3) {
                ArrayList<Integer> list = row.get(cr);
                int idx = -1;
                if (row.containsKey(cr)) {
                    idx = Collections.binarySearch(list, cc);
                    idx = -(idx + 1);
                }
                if (idx == 0 || idx == -1) {
                    count += cc - minc;
                    cc = minc + 1;
                } else {
                    int nc = Math.max(list.get(idx - 1), minc + 1);
                    count += cc - nc;
                    cc = nc + 1;
                }
                cr--;
                maxr--;
                dir = 4;
            } else {
                ArrayList<Integer> list = col.get(cc);
                int idx = -1;
                if (col.containsKey(cc)) {
                    idx = Collections.binarySearch(list, cr);
                    idx = -(idx + 1);
                }
                if (idx == 0 || idx == -1) {
                    count += cr - minr;
                    cr = minr + 1;
                } else {
                    int nr = Math.max(list.get(idx - 1), minr + 1);
                    count += cr - nr;
                    cr = nr + 1;
                }
                cc++;
                minc++;
                dir = 1;
            }
        }

        if (n * 1L * m - k == count) System.out.println("Yes");
        else System.out.println("No");

    }
}
