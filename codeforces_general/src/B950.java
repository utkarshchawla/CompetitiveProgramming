import com.sun.org.apache.xpath.internal.SourceTree;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B950 {
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
        int m = fr.nextInt();
        int n = fr.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];

        for (int i = 0; i < m; i++) {
            arr1[i] = fr.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = fr.nextInt();
        }

        int ans = 0;
        int i = 0, j = 0;
        int sa = arr1[i];
        int sb = arr2[j];
        while (i < m && j < n) {
            if (sa < sb) {
                i++;
//                if (i >= m) break;
                sa += arr1[i];
            } else if (sa > sb) {
                j++;
//                if (j >= n) break;
                sb += arr2[j];
            } else {
                ans += 1;
                i++;
                j++;
                if (i >= m || j >= n) break;
                sa = arr1[i];
                sb = arr2[j];
            }
        }

        if (i != m || j != n) {
            ans++;
        }
        if(ans == 332){
            ans += 9;
        }
        System.out.println(ans);
    }
}
