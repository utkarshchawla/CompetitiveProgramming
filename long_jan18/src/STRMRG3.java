import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class STRMRG3 {
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
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            String a = fr.nextLine();
            String b = fr.nextLine();
            a = removedup(a);
            b = removedup(b);
            int[][] arr = new int[a.length() + 1][b.length() + 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 0;
            }
            for (int i = 0; i < arr[0].length; i++) {
                arr[0][i] = 0;
            }
            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr[0].length; j++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    } else {
                        arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                    }
                }
            }

            int val = a.length() + b.length() - arr[a.length()][b.length()];
            System.out.println(val);
        }
    }


    private static String removedup(String a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            sb.append(a.charAt(i));
            while (i + 1 < a.length() && a.charAt(i) == a.charAt(i + 1)) {
                i++;
            }
        }
        return sb.toString();
    }
}
