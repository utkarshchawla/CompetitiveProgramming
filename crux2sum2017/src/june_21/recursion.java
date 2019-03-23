package june_21;

import june_7.printPrime;

public class recursion {

	public static int counter = 0;

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 2, 1, };
		// System.out.println(max(arr, 0));
		// System.out.println(find(arr, 0, 33));
		// System.out.println(lastindex(arr, 0, 22));
		// System.out.println(firstindex(arr, 0, 22));
		// System.out.println(allindices(arr, 0, 22, 0));
		// int[] x = allindices(arr, 0, 22, 0);
		// displaybtr(x, 0);
		// System.out.println(palindrome(arr, 0, arr.length - 1));
		invertedtriangle(1, 1, 5);

	}

	public static void displaybtr(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);
		displaybtr(arr, vidx + 1);
	}

	public static void displayrev(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		displayrev(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}

	public static int max(int[] arr, int vidx) {
		if (vidx == arr.length - 1) {
			return arr[vidx];
		}

		if (arr[vidx] > max(arr, vidx + 1)) {
			return arr[vidx];
		}

		return max(arr, vidx + 1);

	}

	public static boolean find(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}

		if (arr[vidx] == data) {
			return true;
		}
		return find(arr, vidx + 1, data);
	}

	public static int firstindex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == data) {
			return vidx;
		}
		return firstindex(arr, vidx + 1, data);
	}

	public static int lastindex(int[] arr, int vidx, int data) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == data && lastindex(arr, vidx + 1, data) == -1) {
			return vidx;
		}
		return lastindex(arr, vidx + 1, data);
	}

	public static int[] allindices(int[] arr, int vidx, int data, int csf) {
		if (vidx == arr.length) {
			return new int[csf];
		}

		if (arr[vidx] == data) {
			int[] rr = allindices(arr, vidx + 1, data, csf + 1);
			rr[csf] = vidx;
			return rr;

		} else {
			return allindices(arr, vidx + 1, data, csf);
		}

	}

	public static boolean palindrome(int[] arr, int vidx, int vfdx) {
		if (vidx == arr.length / 2 + 1) {
			return true;
		}
		if (arr[vidx] != arr[vfdx]) {
			return false;
		}
		return palindrome(arr, vidx + 1, vfdx - 1);

		// if (palindrome(arr, vidx + 1, vfdx - 1)) {
		// if (arr[vidx] == arr[vfdx]) {
		// return true;
		// } else {
		// return false;
		// }
		//
		// } else {
		// return false;
		// }

	}

	public static void invertedtriangle(int row, int col, int n) {
		if (row > n) {
			return;
		}

		if (col > row) {
			System.out.println();
			invertedtriangle(row + 1, col, n);
			return;
		}
		for (int i = 0; i < n - row + 1; i++) {
			System.out.print("*");
		}

		invertedtriangle(row, col + 1, n);

	}
}
