import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int r = fr.nextInt();
        int c = fr.nextInt();
        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = fr.nextLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        boolean flag = true;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'S') {
                    if (i - 1 >= 0 && arr[i - 1][j] == 'W') flag = false;
                    if (i + 1 < r && arr[i + 1][j] == 'W') flag = false;
                    if (j - 1 >= 0 && arr[i][j - 1] == 'W') flag = false;
                    if (j + 1 < c && arr[i][j + 1] == 'W') flag = false;
                }
            }
        }

        if (flag) {
            System.out.println("Yes");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j] == '.') {
                        System.out.print("D");
                    } else {
                        System.out.print(arr[i][j]);
                    }
                }

                System.out.println();
            }

        } else {
            System.out.println("No");
        }
    }
}
