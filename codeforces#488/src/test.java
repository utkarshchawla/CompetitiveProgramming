import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) {
        System.out.println(rodCut(6, new ArrayList<>(Arrays.asList(1, 2, 5))));
    }

    public static int isMatch(final String A, final String B) {
        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) dp[i][j] = true;
                    else if (j == 0 && A.charAt(i - 1) == '*') dp[i][j] = dp[i - 1][j] | dp[i - 2][j];
                    else if (i == 0 && B.charAt(j - 1) == '*') dp[i][j] = dp[i][j - 1] | dp[i][j - 2];
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1) || A.charAt(i - 1) == '.' || B.charAt(j - 1) == '.')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (A.charAt(i - 1) == '*' || B.charAt(j - 1) == '*') {
                        if (A.charAt(i - 1) == '*') {
                            int col = j;
                            while (col >= 0) {
                                dp[i][j] = dp[i][j] | dp[i - 1][j];
                                col--;
                            }
                        }
                        if (B.charAt(j - 1) == '*') {
                            int row = i;
                            while (row >= 0) {
                                dp[i][j] = dp[i][j] | dp[row][j - 1];
                                row--;
                            }
                        }
                        if (A.charAt(i - 1) == '*' && i - 2 >= 0) dp[i][j] = dp[i][j] | dp[i - 2][j];
                        if (B.charAt(j - 1) == '*' && j - 2 >= 0) dp[i][j] = dp[i][j] | dp[i][j - 2];
                    }
                }

            }
        }
        if (dp[A.length()][B.length()]) return 1;
        return 0;
    }

    public static int canJump(ArrayList<Integer> A) {
        int[] dp = new int[A.size()];
        Arrays.fill(dp, -1);
        dp[dp.length - 1] = 1;
        o:
        for (int i = dp.length - 2; i >= 0; i++) {
            if (A.get(i) >= dp.length - 1 - i) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= A.get(i); j++) {
                if (dp[i + j] == 1) {
                    dp[i] = 1;
                    continue o;
                }
            }
            dp[i] = 0;
        }

        return dp[0];
    }

//    public static ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        long[][] dp = new long[A + 1][A + 1];
//        for (long[] aDp : dp) {
//            Arrays.fill(aDp, -1);
//        }
//        long ans = helper(0, A, B, dp);
//        System.out.println(ans);
//        return new ArrayList<>();
//    }
//
//    public static long helper(int l, int r, ArrayList<Integer> B, long[][] dp) {
//        long ans = Integer.MAX_VALUE;
//        boolean flag = false;
//        if (dp[l][r] != -1) return dp[l][r];
//        for (int i = 0; i < B.size(); i++) {
//            long val = Integer.MAX_VALUE;
//            if (B.get(i) < r && B.get(i) > l) {
//                val = (r - l) + helper(l, B.get(i), B, dp) + helper(B.get(i), r, B, dp);
//                flag = true;
//            }
//            ans = Math.min(ans, val);
//        }
//
//        if (!flag) return dp[l][r] = 0;
//        return dp[l][r] = ans;
//
//    }

    public static class pair {
        int val;
        int ans;
    }

    public static ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        pair[][] dp = new pair[A + 1][A + 1];
        for(int i = 0 ; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                dp[i][j] = new pair();
            }
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 2; j < dp.length; j++) {
                int min = Integer.MAX_VALUE;
                boolean flag = false;
                int ans = -1;
                for (int k = 0; k < B.size(); k++) {
                    if (B.get(k) > i && B.get(k) < j) {
                        flag = true;
                        int val = (j - i) + dp[i][B.get(k)].val + dp[B.get(k)][j].val;
                        if (val < min) {
                            min = val;
                            ans = B.get(k);
                        }
                    }
                }
                if (flag) {
                    dp[i][j].val = min;
                    dp[i][j].ans = ans;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        helper(list,dp,0,dp.length - 1);
        return list;
    }

    private static void helper(ArrayList<Integer> list, pair[][] dp, int l, int r) {
        int ans = dp[l][r].ans;
        if(ans == 0)return;
        list.add(ans);
        helper(list,dp,l,ans);
        helper(list,dp,ans,r);
    }


}
