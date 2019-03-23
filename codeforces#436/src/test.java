import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        String s = fr.nextLine();

        int ans = 0;
        int i = 0;
        int j = 0;
        int max = 0;
//        while (j < s.length() - 1) {
//            if (s.charAt(j) == s.charAt(j + 1)) {
//                j++;
//            } else {
//                break;
//            }
//        }
//        if (j == s.length() - 1) {
//            ans = 1;
//        }
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c > 95) {

            }

            i++;
        }
        System.out.println(max);
    }
}
