import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D {
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

    static class pair {
        int one;
        int two;

        pair(int one, int two) {
            this.one = one;
            this.two = two;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        pair[] arr = new pair[n];
        for (int i = 0; i < arr.length; i++) arr[i] = new pair(fr.nextInt(), fr.nextInt());
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        helper(arr, list, ans);
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(0).get(i) + " ");
        }
        System.out.println();
    }

    private static void helper(pair[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if (list.size() == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (list.size() == 1) {
            list.add(arr[list.get(0) - 1].one);
            list.add(arr[list.get(0) - 1].two);
            helper(arr, list, ans);
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);

            list.add(arr[list.get(0) - 1].two);
            list.add(arr[list.get(0) - 1].one);
            helper(arr, list, ans);
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
            return;
        }
        int a = list.get(list.size() - 2);
        int b = list.get(list.size() - 1);
        if (arr[a - 1].one == b) {
            list.add(arr[a - 1].two);
            helper(arr, list, ans);
            list.remove(list.size() - 1);
        } else if (arr[a - 1].two == b) {
            list.add(arr[a - 1].one);
            helper(arr, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
