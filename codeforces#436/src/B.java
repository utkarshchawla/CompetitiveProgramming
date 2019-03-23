import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B {

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
    }

    static class IntegerPair {

        int x;
        int y;

        public IntegerPair(int i, int j) {
            this.x = i;
            this.y = j;

        }
    }

    public static void main(String[] args) {
//		FastReader fr = new FastReader();
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        String s = fr.next();

        ArrayList<IntegerPair> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                i++;
            }
            if (i >= s.length()) {
                break;
            }

            int ii = i;
            while (i < s.length() && s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                i++;
            }
            int ei = i - 1;
            list.add(new IntegerPair(ii, ei));

        }

        System.out.println(helper(list, s));

    }

    public static int helper(ArrayList<IntegerPair> list, String s) {
        int max = 0;
        for (IntegerPair ip : list) {
            HashSet<Character> set = new HashSet<>();
            for (int i = ip.x; i <= ip.y; i++) {
                set.add(s.charAt(i));
            }

            int val = set.size();
            if (val > max) {
                max = val;
            }
        }

        return max;
    }

}
