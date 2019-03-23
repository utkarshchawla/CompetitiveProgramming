package june_14;

public class matrix_multi {

	public static void main(String[] args) {

		int[][] arr1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int[][] arr2 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		int[][] a = mm(arr1, arr2);
		display(a);
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public static int[][] mm(int[][] arr1, int[][] arr2) {
		int col1 = 0, row2 = 0;

		int[][] s = new int[arr1.length][arr2[0].length];
		if (arr1[0].length != arr2.length) {
			System.out.println("not possible");
			System.exit(0);
		}

		for (int row1 = 0; row1 < arr1.length; row1++) {
			for (int col2 = 0; col2 < arr2[0].length; col2++) {
				int val = 0;

				for (col1 = 0, row2 = 0; col1 < arr1[0].length && row2 < arr2.length; col1++, row2++) {
					val += arr1[row1][col1] * arr2[row2][col2];
				}
				row2--;
				col1--;
				s[row1][col2] = val;

			}

		}

		return s;
	}

}
