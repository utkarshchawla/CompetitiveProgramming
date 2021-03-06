package june_28;

public class recursion {

    public static int count = 0;

    public static void main(String[] args) {
        printNKnights(new boolean[5][5], 0, "", 0, -1);
        System.out.println(count);
    }

    public static void printTArgetSubsset(int[] arr, int vidx, int target, String asf) {

        if (vidx == arr.length) {
            if (target == 0) {
                System.out.println(asf);
            }
            return;
        }

        printTArgetSubsset(arr, vidx + 1, target, asf);
        printTArgetSubsset(arr, vidx + 1, target - arr[vidx], asf + " " + arr[vidx]);
    }

    public static void splitAns(int[] arr, int vidx, String as1, String as2, int s1, int s2) {
        if (vidx == arr.length) {
            if (s1 == s2) {
                System.out.print(as1 + "\t");
                System.out.println(as2);
            }
            return;
        }

        // splitAns(arr, vidx + 1, as1, as2, s1, s2);
        splitAns(arr, vidx + 1, as1 + " " + arr[vidx], as2, s1 + arr[vidx], s2);
        splitAns(arr, vidx + 1, as1, as2 + " " + arr[vidx], s1, s2 + arr[vidx]);

    }

    public static void splitAnsconsecutive(int[] arr, int vidx, String as1, String as2, int s1, int s2, boolean flag) {
        if (vidx == arr.length) {
            if (s1 == s2) {
                System.out.print(as1 + "\t");
                System.out.println(as2);
            }
            return;
        }
        if (!flag)
            splitAnsconsecutive(arr, vidx + 1, as1 + " " + arr[vidx], as2, s1 + arr[vidx], s2, flag);

        splitAnsconsecutive(arr, vidx + 1, as1, as2 + " " + arr[vidx], s1, s2 + arr[vidx], true);

    }

    public static void printNQueens(boolean[][] board, int qpsf, String ans) {
        if (qpsf == board.length) {
            System.out.println(ans);
//			count++;
            return;
        }

        int r = qpsf;
        for (int c = 0; c < board.length; c++) {
            board[r][c] = true;
            if (isItSafeQueen(board, r, c)) {
                printNQueens(board, qpsf + 1, ans + "[" + r + "-" + c + "]");
            }
            board[r][c] = false;
        }

    }

    public static boolean isItSafeQueen(boolean[][] board, int row, int col) {
        int r = row - 1, c = col;
        while (r >= 0) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
        }

        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
            c--;
        }

        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board.length) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    public static void printNKnights(boolean[][] board, int kpsf, String ans, int lr, int lc) {

        if (kpsf == 13) {
            System.out.println(ans);
            count++;
            return;
        }

        for (int r = lr; r < board.length; r++) {
            int sc = 0;
            if (r == lr) sc = lc + 1;
            for (int c = sc; c < board[0].length; c++) {
                if (board[r][c] == false) {
                    if (isItSafeKnight(board, r, c)) {
                        board[r][c] = true;
                        printNKnights(board, kpsf + 1, ans + "[" + r + "-" + c + "]", r, c);
                        board[r][c] = false;
                    }
                }
            }
        }
    }

    public static boolean isItSafeKnight(boolean[][] board, int row, int col) {
        int r = row;
        int c = col;

        // up
        if (r - 2 >= 0) {
            if (c + 1 < board.length && board[r - 2][c + 1] == true) {
                return false;
            } else if (c - 1 >= 0 && board[r - 2][c - 1] == true) {
                return false;
            }
        }

        // down
        if (r + 2 < board.length) {
            if (c + 1 < board.length && board[r + 2][c + 1] == true) {
                return false;
            } else if (c - 1 >= 0 && board[r + 2][c - 1] == true) {
                return false;
            }
        }
        // right
        if (c + 2 < board.length) {
            if (r - 1 >= 0 && board[r - 1][c + 2] == true) {
                return false;
            } else if (r + 1 < board.length && board[r + 1][c + 2] == true) {
                return false;
            }
        }

        // left
        if (c - 2 >= 0) {
            if (r - 1 >= 0 && board[r - 1][c - 2] == true) {
                return false;
            } else if (r + 1 < board.length && board[r + 1][c - 2] == true) {
                return false;
            }
        }
        return true;

    }

}
