import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C510 {
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
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = fr.nextLine();
            temp.add(s);
        }
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < 26; i++) g.add(new ArrayList<>());
        for (int i = 0; i < temp.size() - 1; i++) {
            int j = 0;
            String a = temp.get(i);
            String b = temp.get(i + 1);
            while (j < a.length() && j < b.length()) {
                if (a.charAt(j) != b.charAt(j)) {
                    g.get(a.charAt(j) - 97).add(b.charAt(j) - 97);
                    break;
                }
                j++;
            }
            if (j == b.length()) {
                System.out.println("Impossible");
                return;
            }
        }
        ArrayList<Integer> list = new ArrayList();
        boolean visited[] = new boolean[26];
        boolean cycle[] = new boolean[26];
        for (int i = 0; i < g.size(); i++) {
            if (!visited[i]) {
                if (!topo(list, g, visited, i, cycle)) {
                    System.out.println("Impossible");
                    return;
                }
            }
        }
        if (list.size() != 26) {
            System.out.println("Impossible");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append((char) (list.get(i) + 97));
        }
        System.out.println(sb);
    }

    private static boolean topo(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> g, boolean[] visited, int i, boolean[] cycle) {
        visited[i] = true;
        cycle[i] = true;
        for (int nbrs : g.get(i)) {
            if (visited[nbrs] && cycle[nbrs]) return false;
            if (!visited[nbrs]) topo(list, g, visited, nbrs, cycle);
        }
        cycle[i] = false;
        list.add(i);
        return true;
    }
}
