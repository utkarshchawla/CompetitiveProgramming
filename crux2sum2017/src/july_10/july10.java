package july_10;

public class july10 {

    public static void main(String[] args) {

        int[] dims = {10, 20, 30, 40, 50, 60};
        int[] val = {10, 15, 20, 5, 8};
        int[] wts = {20, 15, 15, 5, 18};
        System.out.println(mcmiter(dims));
        System.out.println(mcm(dims, 0, dims.length - 1));
        // System.out.println(mcmdp(arr, 0, arr.length - 1, new
        // int[arr.length][arr.length]));
        // System.out.println(knapsack(val, wts, 0, 50, 0));
        // System.out.println(knapsackdp(wts, val, 50, 0, new
        // int[51][val.length]));
    }

    public static int mcm(int[] dims, int si, int fi) {
        // if (fi - si == 2) {
        // int s = dims[si] * dims[si + 1] * dims[fi];
        // return s;
        // }

        if (fi - si < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = si + 1; i < fi; i++) {
            int count1 = mcm(dims, si, i);
            int count2 = mcm(dims, i, fi);
            int count3 = dims[si] * dims[i] * dims[fi];
            int sum = count1 + count2 + count3;
            if (sum < min) {
                min = sum;
            }
        }

        return min;

    }

    public static int mcmdp(int[] dims, int si, int fi, int[][] strg) {

        if (fi - si == 2) {
            int s = dims[si] * dims[si + 1] * dims[fi];
            return s;
        }

        if (fi - si < 2) {
            return 0;
        }
        if (strg[si][fi] != 0) {
            return strg[si][fi];
        }

        int min = Integer.MAX_VALUE;
        for (int i = si + 1; i < fi; i++) {
            int count1 = mcmdp(dims, si, i, strg);
            int count2 = mcmdp(dims, i, fi, strg);
            int count3 = dims[si] * dims[i] * dims[fi];
            int sum = count1 + count2 + count3;

            if (sum < min) {
                min = sum;
            }
            strg[si][fi] = min;
        }

        return min;

    }

    public static int mcmiter(int[] dims) {
        int[][] arr = new int[dims.length - 1][dims.length - 1];
        for (int r = arr.length - 2; r >= 0; r--) {
            for (int c = arr[0].length - 2; c >= 0; c--) {
                int si = r;
                int fi = arr[0].length - c;
                int counter = fi - si;
                int val = Integer.MAX_VALUE;
                if (counter > 1) {
                    if (counter == 2) {
                        arr[r][c] = dims[si] * dims[si + 1] * dims[si + 2];
                    } else {
                        for (int i = si + 1; i < fi; i++) {
                            int count1 = dims[si] * dims[i] * dims[fi];
                            int count2 = arr[r][arr[0].length - i];
                            int count3 = arr[i][c];
                            int sum = count1 + count2 + count3;
                            if (sum < val) {
                                val = sum;
                            }
                        }
                        arr[r][c] = val;
                    }
                }
            }
        }
        return arr[0][0];
    }

    public static int knapsack(int[] prices, int[] wts, int vidx, int cap, int psf) {

        if (vidx == wts.length) {
            return psf;
        }

        int b = 0;
        int a = knapsack(prices, wts, vidx + 1, cap, psf);
        if (cap - wts[vidx] >= 0) {
            b = knapsack(prices, wts, vidx + 1, cap - wts[vidx], psf + prices[vidx]);
        }

        return Math.max(a, b);

    }

    public static int knapsackdp(int[] wts, int[] val, int cap, int vidx, int[][] strg) {
        if (vidx == wts.length) {
            return 0;
        }
        if (strg[cap][vidx] != 0) {
            return strg[cap][vidx];
        }

        int v1 = 0, v2 = 0;
        v1 = knapsackdp(wts, val, cap, vidx + 1, strg);
        if (cap >= wts[vidx]) {
            v2 = val[vidx] + knapsackdp(wts, val, cap - wts[vidx], vidx + 1, strg);
        }

        int rv = Math.max(v1, v2);
        strg[cap][vidx] = rv;
        return rv;
    }

}
