import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class PRTITION2 {
    private Long seven;

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
            HashSet<Long> even = new HashSet<>();
            HashSet<Long> odd = new HashSet<>();
            long seve = 0;
            long sodd = 0;
            for (int i = 1; i <= n; i++) {
                if (i == x) continue;
                if (i % 2 == 0) {
                    even.add((long) i);
                    seve += i;
                } else {
                    odd.add((long) i);
                    sodd += i;
                }
            }
            boolean flag = true;
            long diff = Math.abs(sodd - seve);
            if ((sodd + seve) % 2 != 0) {
                flag = false;
            }
            if (diff % 2 != 0) {
                flag = false;
            } else {
                diff = diff / 2;
                if (seve > sodd) {
                    if (even.contains(diff)) {
                        even.remove(diff);
                        odd.add(diff);
                    } else if (diff % 2 == 0) {
                        flag = false;
                    } else {
                        long si = 2 - diff;
                        boolean flag2 = false;
                        for (long i = 2; i <= n; i += 2) {
                            if (even.contains(i) && odd.contains(si)) {
                                even.remove(i);
                                odd.add(i);
                                odd.remove(si);
                                even.add(si);
                                flag2 = true;
                                break;
                            }
                            si += 2;
                        }
                        if (!flag2) {
                            flag = false;
                        }
                    }
                } else if (sodd > seve) {
                    if (odd.contains(diff)) {
                        odd.remove(diff);
                        even.add(diff);
                    } else if (diff % 2 == 0) {
                        flag = false;
                    } else {
                        long si = 1 - diff;
                        boolean flag2 = false;
                        for (long i = 1; i <= n; i += 2) {
                            if (odd.contains(i) && even.contains(si)) {
                                odd.remove(i);
                                even.add(i);
                                even.remove(si);
                                odd.add(si);
                                flag2 = true;
                                break;
                            }
                            si += 2;
                        }
                        if (!flag2) {
                            flag = false;
                        }
                    }
                } else {

                }
            }
            StringBuilder sb = new StringBuilder();
            for (long i = 1; i <= n; i++) {
                if (i == x) {
                    sb.append(2);
                } else if (even.contains(i)) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
            if (flag) {
                System.out.println(sb);
            } else {
                System.out.println("impossible");
            }
        }
    }
}
