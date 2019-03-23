import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class PRTITION {
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

    //    private static ArrayList<Integer> list = new ArrayList<>();
    private static HashSet<Integer> list = new HashSet<>();

    static void printSolution(boolean[][] part, int[] arr, int i, int j) {
        if (!part[i][j] || i == 0)
            return;

        if (part[i][j - 1])
            printSolution(part, arr, i, j - 1);
        else {
            printSolution(part, arr, i - arr[j - 1], j - 1);
//            System.out.print(arr[j - 1] + " ");
            list.add(arr[j - 1]);
        }
    }

    static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;

        boolean[][] part = new boolean[sum + 1][n + 1];

        for (int i = 1; i < sum + 1; i++)
            part[i][0] = false;

        for (int j = 0; j < n + 1; j++)
            part[0][j] = true;

        for (int i = 1; i < sum + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= arr[j - 1])
                    part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
            }
        }

        if (part[sum][n]) {
//            System.out.println("\nOne subset with required sum : ");
            printSolution(part, arr, sum, n);
//            System.out.println();
        }

        return part[sum][n];
    }

    static boolean findPartition(int[] arr) {
        int n = arr.length;

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        if ((sum & 1) == 1)
            return false;

        return isSubsetSum(arr, sum / 2);
    }

//    static void printMatrix(int[][] mat) {
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++)
//                System.out.print(mat[i][j] + " ");
//            System.out.println();
//        }
//    }
//
//    static void printArray(int[] arr) {
//        for (Integer i : arr)
//            System.out.print(i + " ");
//        System.out.println();
//    }

    public static void main(String[] args) {
        FastReader fr = new FastReader  ();
        int t = fr.nextInt();
        while (t-- > 0) {
            int x = fr.nextInt();
            int n = fr.nextInt();

            int[] arr = new int[n - 1];
            int count = 1;
            for (int i = 0; i < arr.length; i++) {
                if (count == x) {
                    count++;
                }
                arr[i] = count;
                count++;
            }

            if (findPartition(arr)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    if (i == x) {
                        sb.append(2);
                    } else if (list.contains(i)) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                }
                System.out.println(sb);
            } else {
                System.out.println("impossible");
            }
            list = new HashSet<>();
        }
    }
}

