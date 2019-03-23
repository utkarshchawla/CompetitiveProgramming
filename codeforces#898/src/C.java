import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, HashSet<String>> sub = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = fr.nextLine();
            int idx = 0;
            while ((s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') || (s.charAt(idx) >= 'A' && s.charAt(idx) <= 'Z')) {
                idx++;
            }
            String name = s.substring(0, idx);
            if (!map.containsKey(name)) {
                map.put(name, new HashSet<String>());
                sub.put(name, new HashSet<String>());
            }
            idx += 3;
            if(s.charAt(idx) == ' '){
                idx++;
            }
            while (idx < s.length()) {
                int si = idx;
                while (idx < s.length() && s.charAt(idx) != ' ') {
                    idx++;
                }
                String ss = s.substring(si,idx);
                map.get(name).add(ss);
                idx++;

            }
        }

        for (String s : map.keySet()) {
            for (String m : map.get(s)) {
                for (int i = 1; i < m.length(); i++) {
                    String tbr = m.substring(i);
                    sub.get(s).add(tbr);
                }
            }
        }

        for (String s : map.keySet()) {
            for(String tbr : sub.get(s)){
                map.get(s).remove(tbr);
            }
        }



//        for (String s : map.keySet()) {
//            for (Iterator<String> set = map.get(s).iterator(); set.hasNext(); ) {
//                String m = set.next();
//                for (int i = 1; i < m.length(); i++) {
//                    String tbr = m.substring(i);
//                    if (map.get(s).contains(tbr)) {
//                        map.get(s).remove(tbr);
//                    }
//                }
//            }
//        }

        System.out.println(map.size());
        for (String s : map.keySet()) {
            System.out.print(s + " " + map.get(s).size() + " ");
            for (String ms : map.get(s)) {
                System.out.print(ms + " ");
            }
            System.out.println();
        }

    }
}
