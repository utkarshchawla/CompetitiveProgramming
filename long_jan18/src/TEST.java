import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TEST {
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
            for (int i = list.size() - 1; i >= 0; ) {
                if (list.get(i).size() == 0) {
                    ans = -1;
                    break;
                }
                long val = list.get(i).get(list.get(i).size() - 1);
                if (val < pre) {
                    ans += val;
                    i--;
                    pre = val;
                } else {
                    list.get(i).remove(list.get(i).size() - 1);
                }

            }
            System.out.println(ans);
        }
    }
}