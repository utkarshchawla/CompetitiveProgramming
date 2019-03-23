package june_14;

public class tqo2arrayops {

	public static void main(String[] args) {

		int[][] arr = { { 11, 12, 13, 14, 15, 16 }, { 21, 22, 23, 24, 25, 26 }, { 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 }, { 51, 52, 53, 54, 55, 56 }, { 61, 62, 63, 64, 65, 66 } };
		// display(arr);
		// System.out.println();
		// wavedisplay(arr);
		// exitpoint(arr);
		display(arr);
		shellRotate(arr, 2, 2);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		display(arr);

	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public static void wavedisplay(int[][] arr) {
		int row = 0;
		int col = 0;
		while (col < arr[0].length) {
			row = 0;
			if (row == 0) {
				for (row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + "\t");
				}
				row--;
				col++;
			}
			if (row == arr.length - 1) {
				for (row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + "\t");
				}
				row++;
				col++;
			}
		}
	}

	public static void exitpoint(int[][] arr) {
		int row = 0;
		int col = 0;
		int dir = 1;
		while (true) {
			while (dir == 1) {
				col++;
				out(arr, row, col);
				if (arr[row][col] == 1) {
					dir = 2;
				}
			}
			while (dir == 2) {
				row++;
				out(arr, row, col);

				if (arr[row][col] == 1) {
					dir = 3;
				}
			}
			while (dir == 3) {
				col--;
				out(arr, row, col);

				if (arr[row][col] == 1) {
					dir = 0;
				}
			}
			while (dir == 0) {
				row--;
				out(arr, row, col);

				if (arr[row][col] == 1) {
					dir = 1;
				}
			}
		}
	}

	public static void out(int[][] arr, int row, int col) {
		if (row >= arr.length) {
			row--;
			System.out.println(row + ", " + col);
			System.exit(0);
		}

		if (col >= arr[0].length) {
			col--;
			System.out.println(row + ", " + col);
			System.exit(0);
		}
	}

	public static void shellRotate(int[][] arr, int k, int r) {

		k--;
		int row = k;
		int col = k;
		int rowMax = arr.length - k - 1;
		int colMax = arr[0].length - k - 1;
		int rowMin = k;
		int colMin = k;

		int dir = 2;
		int t = arr[row][col];

		while (true) {
			int temp = 0;

			if (dir == 2) {
				temp = t;
				row += r;
				t = arr[row][col];
				arr[row][col] = temp;
				if (row >= rowMax) {
					dir = 1;
				}
			} else if (dir == 1) {
				temp = t;
				col += r;
				t = arr[row][col];

				arr[row][col] = temp;
				if (col >= colMax) {
					dir = 0;
				}
			} else if (dir == 0) {
				temp = t;
				row -= r;
				t = arr[row][col];

				arr[row][col] = temp;
				if (row <= rowMin) {
					dir = 3;
				}
			} else if (dir == 3) {
				temp = t;
				col -= r;
				t = arr[row][col];

				arr[row][col] = temp;
				if (col <= colMin) {
					dir = 1;
				}
			}

			if (row == k && col == k) {
				break;
			}

		}
	}
}
