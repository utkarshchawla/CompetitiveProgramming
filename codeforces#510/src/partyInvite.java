import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class partyInvite {
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

    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        long tc = fr.nextInt();
        while (tc-- > 0) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) set.add(i);
            ArrayList<Integer>[] g = new ArrayList[n + 1];
            for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int boss = fr.nextInt() - 1;
                int emp = fr.nextInt() - 1;
                set.remove(emp);
                g[boss].add(emp);
            }

            int[] size = new int[n];
            for (int i = 0; i < size.length; i++) {
                if (size[i] == 0)
                    findSize(g, size, i);
            }

            ArrayList<Long> list = new ArrayList<>();
            ArrayList<Long> nums = new ArrayList<>();
            long ans = 1;
            for (int boss : set) {
                list.add(solve(g, boss, size));
                nums.add((long) size[boss]);
                ans = (ans % mod) * (list.get(list.size() - 1) % mod) % mod;
            }
            long mul = helper(nums);
            ans = (ans * mul) % mod;
            fw.println(ans);
        }
        fw.close();
    }

    private static void findSize(ArrayList<Integer>[] g, int[] size, int i) {
        int ans = 1;
        for (int child : g[i]) {
            if (size[child] == 0) findSize(g, size, child);
            ans += size[child];
        }
        size[i] = ans;
    }

    private static long solve(ArrayList<Integer>[] g, int boss, int[] size) {
        long ans = 1;
        ArrayList<Long> nums = new ArrayList<>();
        for (int emps : g[boss]) {
            nums.add((long) size[emps]);
        }
        ans = (ans*helper(nums)) % mod;
        for (int emps : g[boss]) {
            ans = (ans % mod) * (solve(g, emps, size) % mod) % mod;
        }
        return ans;
    }

    private static long helper(ArrayList<Long> list) {
        long ans = 1;
        while (list.size() > 1) {
            long a = list.remove(list.size() - 1);
            long b = list.remove(list.size() - 1);
            ans = (ans % mod) * (multi(a, b)) % mod;
            list.add(a + b);
        }
        return ans;
    }

    private static long multi(long a, long b) {
        long small = Math.min(a, b);
        long big = Math.max(a, b);
        long num = 1;
        for (int i = 1; i <= small; i++) num = (num % mod) * ((big + i) % mod) % mod;
        long den = fac(small);
        return (num % mod) * (modmul(den, mod - 2) % mod) % mod;
    }

    public static long fac(long n) {
        if (n == 0) return 1;
        return ((fac(n - 1) % mod) * (n % mod)) % mod;
    }

    private static long modmul(long a, long b) {
        if (b == 0) return 1;
        if (b % 2 == 1) return (a * modmul(a, b - 1)) % mod;
        long y = modmul(a, b / 2);
        return (y * y) % mod;
    }

}
