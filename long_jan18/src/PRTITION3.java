import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PRTITION3 {
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
            int x = fr.nextInt();
            int n = fr.nextInt();
            long a = (n);
            long b = (n + 1);
            if (n % 2 == 0) {
                a = a / 2;
            } else {
                b = b / 2;
            }
            long sum = (a * b) - x;
            if (sum % 2 != 0 || n <= 3) {
                System.out.println("impossible");
            } else {
                sum = sum / 2;
                long val = 0;
                long idx = -1;
                long idx2 = -1;
                long idx3 = -1;
                int i = 1;
                while (true) {
                    if (i == x) {
                        i++;
                        continue;
                    }
                    if (val == sum) {
                        break;
                    }
                    if (val > sum) {
                        idx = val - sum;
                        if (idx == x) {
                            if (x >= 3) {
                                idx = x - 1;
                                idx2 = 1;
                            } else if (x == 1) {
                                idx3 = n;
                                for (int j = 2; j < i; j++) {
                                    int k = n - j + 1;
                                    if (k < i && k != 1) {
                                        idx = j;
                                        idx2 = k;
                                        break;
                                    }
                                }
                            } else if (x == 2) {
                                idx3 = n;
                                for (int j = 1; j < i; j++) {
                                    if (j == 2) {
                                        continue;
                                    }
                                    int k = n - j + 2;
                                    if (k < i && k != 2) {
                                        idx = j;
                                        idx2 = k;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    val += i;
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= n; j++) {
                    if (j == x) {
                        sb.append(2);
                    } else if (j == idx || j == idx2) {
                        sb.append(1);
                    } else if (j < i || j == idx3) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                }
                System.out.println(sb);
            }
        }
    }
}