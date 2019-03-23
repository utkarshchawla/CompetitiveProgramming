import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
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
        HashSet<Integer>[] arr = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = fr.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < v; j++) {
                set.add(fr.nextInt());
            }
            arr[i] = set;

        }
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j != i) {
                    if (!arr[i].contains(j)) {
                        ans.add(j);
                    }
                }
            }
        }

        System.out.println(ans.size());
    }
}
