import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MAXSC {
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
        for (int t = fr.nextInt(); t > 0; t--) {
            int n = fr.nextInt();
            ArrayList<ArrayList<Long>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Long> l = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    l.add(fr.nextLong());
                }
                l.sort(null);
                list.add(l);
            }

            long ans = 0;
            long pre = Long.MAX_VALUE;
            int i = list.size() - 1;
            while (i >= 0) {
                if (list.get(i).size() != 0) {
                } else {
                    ans = -1;
                    break;
                }
                int idx = list.get(i).size() - 1;
                long val = list.get(i).get(idx);
                if (val >= pre) {
                    list.get(i).remove(idx);
                } else {
                    ans = ans + val;
                    i = i - 1;
                    pre = val;
                }
            }
            System.out.println(ans);
        }
    }
}