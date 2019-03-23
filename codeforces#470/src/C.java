import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int snow[] = new int[n];
        int temp[] = new int[n];

        for (int i = 0; i < n; i++) {
            snow[i] = fr.nextInt();
        }
        for (int i = 0; i < n; i++) {
            temp[i] = fr.nextInt();
        }

        long pre[] = new long[n];
        pre[0] = temp[0];
        for (int i = 1; i < temp.length; i++) {
            pre[i] = temp[i] + pre[i - 1];
        }

        long mi[] = new long[n];
        long fi[] = new long[n];
        for (int i = 0; i < n; i++) {
            int val = snow[i];
            int jl = search(pre, val);
            long a = 0;
            for (int j = i; j < jl; j++) {
                fi[j]++;
            }
            if (jl - 1 >= 0)
                a = pre[jl - 1];
            mi[jl] += (val - a);

        }

        for (int i = 0; i < n; i++) {
            System.out.print(mi[i] + fi[i] * temp[i] + " ");
        }


    }

    public static int search(long arr[], int key) {
        int low = 0, high = arr.length, mid = -1;
        boolean flag = false;

        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] == key) {
                flag = true;
                break;
            } else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid;

        }
        if (flag)
            return mid;
        else {
            if (low >= arr.length)
                return -1;
            else
                return low;
        }
    }
}
