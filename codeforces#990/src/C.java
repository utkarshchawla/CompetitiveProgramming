import java.io.*;
import java.math.BigInteger;
import java.util.*;

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

        int n = fr.nextInt();
        pair[] arr = new pair[n];
        for (int i = 0; i < arr.length; i++) {
            String s = fr.nextLine();
            Stack<Character> st = new Stack<>();
            int l = 0;
            int r = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') st.push('C');
                else {
                    if (st.size() > 0 && st.peek() == 'C') st.pop();
                    else r++;
                }
            }
            l = st.size();
            arr[i] = new pair(l, r);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        long same = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].l > 0 && arr[i].r > 0) continue;
            else if (arr[i].l > 0) list.add(arr[i].l);
            else if (arr[i].r > 0) {
                if (map.containsKey(arr[i].r)) map.put(arr[i].r, map.get(arr[i].r) + 1);
                else map.put(arr[i].r, 1);
            } else {
                same++;
            }
        }

        long ans = same*same;
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                ans += map.get(list.get(i));
            }
        }

        System.out.println(ans);

    }

    public static class pair {
        int l;
        int r;

        pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
