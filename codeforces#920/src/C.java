import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
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
        int arr[] = new int[n + 1];
        int pos[] = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            int val = fr.nextInt();
            arr[i] = val;
            pos[val] = i;
        }
        String s = fr.nextLine();
        boolean flag = true;

        int[] isOk = new int[n];
        isOk[0] = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            if (!(s.charAt(i) == '0')) {
                isOk[i] = isOk[i - 1] + s.charAt(i) - '0';
            }

        }
        for (int i = 1; i <= n; i++) {
            if (pos[i] == i) {
                continue;
            }
            int a = pos[i];
            if (i > a) {
                continue;
            }
//            for (int j = i; j < a; j++) {
//                if (s.charAt(j - 1) == '0') {
//                    flag = false;
//                }
//            }
//            if (!isOk[i - 1][a - 2]) {
//                flag = false;
//            }
            int r = 0, l = 0;
            if (a - 2 >= 0) r = isOk[a - 2];
            if (i - 2 >= 0) l = isOk[i - 2];

            if ((a - i) != (r - l)) {
                flag = false;
            }


        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
