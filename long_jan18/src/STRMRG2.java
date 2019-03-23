import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class STRMRG2 {
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
            int m = fr.nextInt();
            String a = fr.nextLine();
            String b = fr.nextLine();
            HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < b.length(); i++) {
                if (map.containsKey(b.charAt(i))) {
                    map.get(b.charAt(i)).add(i);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(b.charAt(i), list);
                }
            }
            int ans = Integer.MAX_VALUE;
            String s = "";
            for (int i = 0; i < a.length(); i++) {
                StringBuilder sb = new StringBuilder();
                int idx = 0;
                sb.append(a.substring(0, i));
                for (int j = i; j < a.length(); j++) {
                    if (map.containsKey(a.charAt(j))) {
                        int temp = get(map.get(a.charAt(j)), idx);
                        if (temp < 0) {
                            sb.append(a.charAt(j));
                            continue;
                        }
                        sb.append(b.substring(idx, temp + 1));
                        idx = temp + 1;
                    }
                    sb.append(a.charAt(j));
                }
                sb.append(b.substring(idx));
                int val = helper(sb.toString());
                if (val < ans) {
                    ans = val;
                    s = sb.toString();
                }
            }
            System.out.println(s);
            System.out.println(ans);
        }
    }

    private static int helper(String s) {
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }

        return count;

    }

    public static int get(ArrayList<Integer> arr, int key) {
        int low = 0, high = arr.size(), mid = -1;
        boolean flag = false;

        while (low < high) {
            mid = (low + high) / 2;
            if (arr.get(mid) == key) {
                flag = true;
                break;
            } else if (arr.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (flag) {
            return arr.get(mid);
        } else {
            if (low >= arr.size())
                return -1;
            else
                return arr.get(low);
            //high will give next smaller
        }
    }
}
