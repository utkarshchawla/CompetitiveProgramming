package july_7;

public class july_7 {

    public static void main(String[] args) {

        // System.out.println(cmpdsw(3, 3));
        // System.out.println(lcs("abcfgd", "bcf"));
        System.out.println(editdist("ace", "abge"));
        System.out.println(editDistItr("ybnn", "acbe"));
    }

    public static int cmpi(int er, int ec) {
        int[][] strg = new int[er + 2][ec + 2];
        strg[er][ec + 1] = 1;
        for (int r = er; r >= 0; r--) {
            for (int c = ec; c >= 0; c--) {
                strg[r][c] = strg[r + 1][c] + strg[r][c + 1];

            }

        }
        return strg[0][0];
    }

    public static int cmpdi(int er, int ec) {
        int[][] strg = new int[er + 2][ec + 2];
        strg[er][ec] = 1;
        for (int r = er; r >= 0; r--) {
            for (int c = ec; c >= 0; c--) {
                if (!(c == ec && r == er)) {
                    strg[r][c] = strg[r + 1][c] + strg[r][c + 1] + strg[r + 1][c + 1];
                }

            }

        }
        return strg[0][0];
    }

    public static int cmpdsw(int er, int ec) {
        int strg[] = new int[ec + 1];
        for (int i = 0; i < strg.length; i++) {
            strg[i] = 1;
        }
        int temp = 0;
        int nv = 0;

        for (int r = 0; r < er; r++) {
            temp = 1;
            for (int c = ec - 1; c >= 0; c--) {
                nv = strg[c] + strg[c + 1] + temp;
                temp = strg[c];
                strg[c] = nv;

            }
        }

        return strg[0];

    }

    public static int lcs(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);

        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if (ch1 == ch2) {
            return lcs(ros1, ros2) + 1;
        } else {
            int a = lcs(s1, ros2);
            int b = lcs(ros1, s2);
            if (a > b) {
                return a;
            } else {
                return b;
            }

        }
    }

    public static int lcsi(String s1, String s2) {
        int[][] strg = new int[s1.length() + 1][s2.length() + 1];
        for (int r = s1.length() - 1; r >= 0; r--) {
            for (int c = s2.length() - 1; c >= 0; c--) {
                if (s1.charAt(r) == s2.charAt(c)) {
                    strg[r][c] = 1 + strg[r + 1][c + 1];
                } else {
                    int a = strg[r + 1][c];
                    int b = strg[r][c + 1];
                    if (a > b) {
                        strg[r][c] = a;
                    } else {
                        strg[r][c] = b;
                    }
                }
            }
        }
        return strg[0][0];
    }

    public static int lscsw(String s1, String s2) {
        int[] strg = new int[s1.length() + 1];
        int nv = 0;
        int temp = 0;
        for (int j = s2.length() - 1; j >= 0; j--) {
            for (int i = s1.length() - 1; i >= 0; i--) {
                if (s2.charAt(j) == s1.charAt(i)) {
                    temp = strg[i];
                    nv = temp + 1;
                    strg[i] = nv;
                } else {
                    int a = strg[i];
                    int b = strg[i + 1];
                    if (a < b) {
                        strg[i] = strg[i + 1];
                    }
                }
            }
        }
        return strg[0];
    }

    public static int editdist(String s1, String s2) {
        if (s1.length() == 0) {
            return s2.length();
        }

        if (s2.length() == 0) {
            return s1.length();
        }

        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);
        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if (ch1 == ch2) {
            return editdist(ros1, ros2);
        } else {
            int a = editdist(ros1, s2) + 1;// insert
            int b = editdist(ros1, ros2) + 1;// replace
            int c = editdist(s1, ros2) + 1;// remove
            return Math.min(a, Math.min(b, c));
        }
    }

    public static int editDistItr(String s1, String s2) {
        int[][] arr = new int[s2.length() + 1][s1.length() + 1];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[arr.length - 1][i] = s1.length() - i;
        }
        for (int i = 0; i < arr[0].length - 1; i++) {
            arr[i][arr[0].length - 1] = s2.length() - i;
        }

        for (int r = s1.length() - 1; r >= 0; r--) {
            for (int c = s2.length() - 1; c >= 0; c--) {
                if (s1.charAt(r) == s2.charAt(c)) {
                    arr[r][c] = arr[r + 1][c + 1];
                } else {
                    int x = arr[r + 1][c];
                    int y = arr[r][c + 1];
                    int z = arr[r + 1][c + 1];
                    arr[r][c] = Math.min(Math.min(x, y), z) + 1;
                }
            }
        }
        return arr[0][0];

    }
}
