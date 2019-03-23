import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        String s = fr.next();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> odd = new ArrayList<>();
        ArrayList<Character> even = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 0) even.add(c);
            else odd.add(c);
        }
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<Character> temp = new ArrayList<>();
        for (char c : odd) {
            if (even.size() > 0) {
                int l = even.size() - 1;
                String str = "" + even.get(l) + c + even.get(l);
                map.put(even.get(l), map.get(even.get(l)) - 2);
                if (map.get(even.get(l)) == 0) {
                    map.remove(even.get(l));
                    even.remove(even.get(l));
                }
                ans.add(str);
            } else ans.add(c + "");
            map.put(c, map.get(c) - 1);
            temp.add(c);
        }
        even.addAll(temp);

        StringBuilder str = new StringBuilder();
        if (ans.size() > 0) {
            str = new StringBuilder(ans.get(ans.size() - 1));
            ans.remove(ans.size() - 1);

        }
        for (char c : even) {
            int val = map.get(c) / 2;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < val; i++) sb.append(c);
            str.append(sb);
            str.insert(0, sb);
        }
        for (String t : ans) str.append(t);
        System.out.println(str);
    }
}
