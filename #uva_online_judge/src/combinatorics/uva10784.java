    package combinatorics;

    import java.io.*;
    import java.math.BigInteger;
    import java.util.InputMismatchException;
    import java.util.StringTokenizer;

    public class uva10784 {
        static class FastWriter {
            private final BufferedWriter bw;

            public FastWriter() {
                this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            public void print(Object object) throws IOException {
                bw.append("" + object);
            }

            public void println(Object object) throws IOException {
                print(object);
                bw.append("\n");
            }

            public void close() throws IOException {
                bw.close();
            }
        }

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

            BigInteger nextBigInteger() {
                try {
                    return new BigInteger(nextLine());
                } catch (NumberFormatException e) {
                    throw new InputMismatchException();
                }
            }
        }

        public static void main(String[] args) {
            FastReader fr = new FastReader();
            FastWriter fw = new FastWriter();
            int i = 1;
            while (true) {
                long n = fr.nextLong();
                if (n == 0) break;
                long ans = helper(n);
                System.out.println("Case " + i + ": " + ans);
                i++;
            }
        }

        private static long helper(long n) {
            long lo = 3;
            long hi = Integer.MAX_VALUE;
            long ans = Long.MAX_VALUE;
            while (lo <= hi) {
                long mid = (hi - lo) / 2 + lo;
                if (mid * (mid - 3) > 2 * n) {
                    ans = Math.min(ans, mid);
                    hi = mid - 1;
                } else if (mid * (mid - 3) < 2 * n) lo = mid + 1;
                else return mid;
            }
            return ans;

        }

    }
