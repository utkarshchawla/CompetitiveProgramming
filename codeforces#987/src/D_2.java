import com.sun.deploy.util.ArrayUtil;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class D_2 {
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

    public static class Vertex implements Comparable<Vertex> {
        int idx = -1;
        HashMap<Integer, Integer> nbrs = new HashMap<>();
        int val;
        long[] arr;

        @Override
        public int compareTo(Vertex o) {
            return (int) (this.arr[idx] - o.arr[idx]);
        }
    }

    public static HashMap<Integer, Vertex> vces = new HashMap<>();

    public static void addVertex(int vname, int val, int k) {
        if (vces.containsKey(vname)) {
            return;
        }

        Vertex v = new Vertex();
        v.val = val;
        vces.put(vname, v);
        v.arr = new long[k + 1];
        Arrays.fill(v.arr, Long.MAX_VALUE);
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
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = fr.nextInt();
            addVertex(i + 1, val, k);
            ArrayList<Integer> list = new ArrayList<>();
            if (map.containsKey(val)) list = map.get(val);
            list.add(i + 1);
            map.put(val, list);
        }

        for (int i = 0; i < m; i++) {
            addEdge(fr.nextInt(), fr.nextInt(), 1);
        }

        for (int i : map.keySet()) {
            PriorityQueue<Vertex> queue = new PriorityQueue<>();
            for (int j : map.get(i)) {
                vces.get(j).arr[i] = 0;
                vces.get(j).idx = i;
                queue.add(vces.get(j));
            }
            while (!queue.isEmpty()) {
                Vertex rm = queue.poll();
                for (int nbrs : rm.nbrs.keySet()) {
                    Vertex temp = vces.get(nbrs);
                    temp.idx = i;
                    if (temp.arr[i] > rm.arr[i] + 1) {
                        temp.arr[i] = rm.arr[i] + 1;
                        queue.add(temp);
                    }

                }
            }
        }

        for (int i = 0; i < n; i++) {
            long arr[] = vces.get(i + 1).arr;
            Arrays.sort(arr);
            long sum = 0;
            for (int j = 0; j < s; j++) sum += arr[j];
            fw.print(sum + " ");
        }
        fw.close();
    }

}
