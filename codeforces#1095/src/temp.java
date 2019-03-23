import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class temp {
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
        int n = 2;
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();

        HashMap<String, ArrayList<String>> nfa = new HashMap<>();
        nfa.put("0", new ArrayList<>(Arrays.asList("01", "0")));
        nfa.put("1", new ArrayList<>(Arrays.asList("", "2")));
        nfa.put("2", new ArrayList<>(Arrays.asList("", "")));
        HashMap<String, ArrayList<String>> dfa = new HashMap<>();
        ArrayList<String> mul = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
//        initial state added to dfa
        dfa.put("0", new ArrayList<>(Arrays.asList("01", "0")));
        mul.add("01");
        mul.add("0");
        set.add("0");

        while (mul.size() != 0) {
            String s = mul.remove(mul.size() - 1);
            if (set.contains(s) || s.length() == 0) continue;
            set.add(s);
            ArrayList<String> ans = new ArrayList<>();
            for (int ns = 0; ns < n; ns++) {
                String str = "";
                for (int i = 0; i < s.length(); i++) {
                    str += nfa.get(s.charAt(i) + "").get(ns);
                }
                str = remdup(str);
                ans.add(str);
                mul.add(str);
            }
            dfa.put(s, ans);
        }

        for (String s : dfa.keySet()) {
            System.out.println(s + "-->" + dfa.get(s));
        }
    }

    public static String remdup(String s) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) continue;
            set.add(s.charAt(i));
            sb.append(s.charAt(i));
        }
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
//        return sb.toString();
    }
}
