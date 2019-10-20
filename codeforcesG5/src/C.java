import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C {
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
        int x;
        int y;
        int z;
        int idx;

        pair(int x, int y, int z, int idx) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.idx = idx;
        }

        @Override
        public int compareTo(pair o) {
            if (this.x == o.x && this.y == o.y) return this.z - o.z;
            else if (this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        pair[] arr = new pair[n];
        boolean[] snap = new boolean[n];
        HashMap<Integer, HashMap<Integer, HashSet<Integer>>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            pair p = new pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), i + 1);
            arr[i] = p;
            HashSet<Integer> set = new HashSet<>();
            if (map.containsKey(p.x) && map.get(p.x).containsKey(p.y)) set = map.get(p.x).get(p.y);
            set.add(p.z);
            HashMap<Integer, HashSet<Integer>> m = new HashMap<>();
            if (map.containsKey(p.x)) m = map.get(p.x);
            m.put(p.y, set);
            map.put(p.x, m);
        }
        Arrays.sort(arr);
        int l = 0;
        int r = 0;
        int count = 0;
        while (count < n) {
            while (snap[l]) l = (l + 1) % n;
            while (snap[r]) r = (r + 1) % n;
            if (l >= r) r = (l + 1) % n;
            while (snap[r]) r = (r + 1) % n;
            int minx = Math.min(arr[l].x, arr[r].x);
            int maxx = Math.max(arr[l].x, arr[r].x);
            int miny = Math.min(arr[l].y, arr[r].y);
            int maxy = Math.max(arr[l].y, arr[r].y);
            int minz = Math.min(arr[l].z, arr[r].z);
            int maxz = Math.max(arr[l].z, arr[r].z);
            boolean flag = false;
            o:
            for (int x : map.keySet()) {
                if (x < minx || x > maxx) continue;
                HashMap<Integer, HashSet<Integer>> m = map.get(x);
                for (int y : m.keySet()) {
                    if (y < miny || y > maxy) continue;
                    HashSet<Integer> s = m.get(y);
                    for (int z : s) {
                        if (z < minz || z > maxz) continue;
                        if (x == arr[l].x && y == arr[l].y && z == arr[l].z) continue;
                        if (x == arr[r].x && y == arr[r].y && z == arr[r].z) continue;

                        flag = true;
                        break o;

                    }
                }
            }

            if (!flag) {
                fw.println(arr[l].idx + " " + arr[r].idx);
                snap[l] = true;
                snap[r] = true;
                map.get(arr[l].x).get(arr[l].y).remove(arr[l].z);
                map.get(arr[r].x).get(arr[r].y).remove(arr[r].z);
                count += 2;
            } else {
                r = (r + 1) % n;
                if (l == r) {
                    l = (l + 1) % n;
                    r = (r + 1) % n;
                }
            }
        }
        fw.close();
    }
}
