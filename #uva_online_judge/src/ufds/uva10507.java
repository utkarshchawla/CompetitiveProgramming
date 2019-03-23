package ufds;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class uva10507 {
    static class Graph {

        public class Vertex {
            HashMap<String, Integer> nbrs = new HashMap<>();
        }

        HashMap<String, Vertex> vces = new HashMap<>();

        public int numVertices() {
            return vces.size();
        }

        public boolean containsVertex(String vname) {
            return vces.containsKey(vname);
        }

        public void addVertex(String vname) {
            if (vces.containsKey(vname)) {
                return;
            }

            Vertex v = new Vertex();
            vces.put(vname, v);
        }

        public void removeVertex(String vname) {
            for (String name : vces.keySet()) {
                if (vces.get(name).nbrs.containsKey(vname)) {
                    vces.get(name).nbrs.remove(vname);
                }
            }
            vces.remove(vname);

        }

        public int numEdges() {
            int val = 0;
            for (String name : vces.keySet()) {
                val += vces.get(name).nbrs.size();
            }
            return val / 2;

        }

        public void removeEdge(String v1name, String v2name) {
            if (vces.get(v1name) == null || vces.get(v2name) == null) {
                return;
            }
            vces.get(v1name).nbrs.remove(v2name);
            vces.get(v2name).nbrs.remove(v1name);

        }

        public boolean containsEdge(String v1name, String v2name) {
            if (vces.get(v1name) == null || vces.get(v2name) == null) {
                return false;
            }

            if (vces.get(v2name).nbrs.containsKey(v1name) && vces.get(v1name).nbrs.containsKey(v2name)) {
                return true;
            }

            return false;
        }

        public void addEdge(String v1name, String v2name, int weight) {
            if (vces.get(v1name) == null || vces.get(v2name) == null) {
                addVertex(v1name);
                addVertex(v2name);
            }

            vces.get(v1name).nbrs.put(v2name, weight);
            vces.get(v2name).nbrs.put(v1name, weight);
        }
    }

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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        while (fr.br.ready()) {
            int n = fr.nextInt();
            Graph g = new Graph();
            int t = fr.nextInt();
            HashSet<Character> wake = new HashSet<>();
            HashSet<Character> asleep = new HashSet<>();
            String s = fr.nextLine();
            int ans = 0;
            wake.add(s.charAt(0));
            wake.add(s.charAt(1));
            wake.add(s.charAt(2));
            while (t-- > 0) {
                String connect = fr.nextLine();
                char c1 = connect.charAt(0);
                char c2 = connect.charAt(1);
                if (!wake.contains(c1)) asleep.add(c1);
                if (!wake.contains(c2)) asleep.add(c2);
                g.addEdge(c1 + "", c2 + "", 0);
            }
//        ArrayList<Character> list = new ArrayList<>(asleep);
            while (!asleep.isEmpty()) {
                ArrayList<Character> list = new ArrayList<>();
                for (Character c : asleep) {
                    int count = 0;
                    for (Character temp : wake) {
                        if (g.containsEdge(temp + "", c + "")) count++;
                    }
                    if (count > 2) {
                        list.add(c);
                    }
                }
                if (list.size() == 0) break;
                ans++;
                for (Character c : list) {
                    wake.add(c);
                    asleep.remove(c);
                }

            }
            if (wake.size() < n) {
                System.out.println("THIS BRAIN NEVER WAKES UP");
            } else {
                System.out.println("WAKE UP IN, " + ans + ", YEARS");
            }
        }
    }
}
