public class test {
    public static int count = 0;

    public static void main(String[] args) {
//        int n = 4;
//        boolean board[][] = new boolean[n][n];
//        nKnights(board, "", 0, 0, 0);
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        int c = a + b + b;
        System.out.println(c);
//        System.out.println(count);

//        boolean board[][] = new boolean[4][4];
//        nQueens(board, 0, "");
//        int arr[] = {55, 44, 33, 22, 11};
//        arr = mergeSort(arr, 0, arr.length - 1);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }


    }

    public static void nQueens(boolean board[][], int qpsf, String ans) {
        if (qpsf == board.length) {
            System.out.println(ans);
            return;
        }

        if (qpsf > board.length) {
            return;
        }


        int row = qpsf;
        for (int col = 0; col < board.length; col++) {
            if (isItSafe(board, row, col)) {
                board[row][col] = true;
                nQueens(board, qpsf + 1, ans + "[" + row + "-" + col + "]");
                board[row][col] = false;
            }
        }
    }

    private static boolean isItSafe(boolean[][] board, int row, int col) {
        for (int r = row - 1; r >= 0; r--) {
            if (board[r][col] == true) {
                return false;
            }
        }

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == true) {
                return false;
            }
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < board[0].length; r--, c++) {
            if (board[r][c] == true) {
                return false;
            }
        }

        return true;
    }

    public static int[] mergeTwoArrays(int[] one, int[] two) {
        int i = 0, j = 0, k = 0;
        int[] ra = new int[one.length + two.length];
        while (i < one.length && j < two.length) {
            if (one[i] < two[j]) {
                ra[k] = one[i];
                k++;
                i++;
            } else {
                ra[k] = two[j];
                k++;
                j++;
            }
        }

        while (i < one.length) {
            ra[k] = one[i];
            k++;
            i++;
        }

        while (j < two.length) {
            ra[k] = two[j];
            k++;
            j++;
        }
        return ra;
    }

    public static int[] mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            int[] ba = new int[1];
            ba[0] = arr[si];
            return ba;
        }
        int mid = (si + ei) / 2;

        int[] one = mergeSort(arr, si, mid);
        int[] two = mergeSort(arr, mid + 1, ei);

        return mergeTwoArrays(one, two);
    }

    public static void nKnights(boolean board[][], String asf, int kpsf, int r, int c) {
        if (kpsf == board.length) {
            System.out.println(asf);
            count++;
            return;
        }

        while (r < board.length) {
            while (c < board[0].length) {
                if (isItSafeKnight(board, r, c)) {
                    board[r][c] = true;
                    nKnights(board, asf + "[" + r + "-" + c + "]", kpsf + 1, r, c + 1);
                    board[r][c] = false;
                }
                c++;
            }
            c = 0;
            r++;
        }
    }


    public static boolean isItSafeKnight(boolean[][] board, int row, int col) {
        int r = row;
        int c = col;

        if (board[row][col]) {
            return false;
        }

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
