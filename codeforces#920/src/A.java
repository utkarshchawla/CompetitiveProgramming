import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {
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
        int test = fr.nextInt();
        while (test-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            boolean[] arr = new boolean[n + 1];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < k; i++) {
                int v = fr.nextInt();
                set.add(v);
                arr[v] = true;
            }

            int t = 1;
            for (int i = 1; i < arr.length; i++) {
                if (!arr[i]) {
                    i = 0;
                    t++;
                    ArrayList<Integer> list = new ArrayList<>(set);
                    for (Integer j : list) {
                        set.remove(j);
                        if (j - 1 >= 0) {
                            arr[j - 1] = true;
                            set.add(j - 1);
                        }
                        if (j + 1 < arr.length) {
                            arr[j + 1] = true;
                            set.add(j + 1);
                        }
                    }
                }
            }

            System.out.println(t);


        }
    }
}
