package june30;

public class complexity {

	public static void main(String[] args) {
		// int[] one = { 1, 2, 3, 6 };
		// int[] two = { 6, 9, 15, 77 };
		int[] arr = { 55, 11, 33, 44, 0, 22 };
		// int[] r = mergesort(arr, 0, arr.length - 1);
		quicksort(arr, 0, arr.length - 1);
		// int[] r = merge(one, two);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static int[] merge(int[] one, int[] two) {
		int[] r = new int[one.length + two.length];
		int k = 0, i = 0, j = 0;

		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				r[k] = one[i];
				i++;
				k++;
			} else {
				r[k] = two[j];
				j++;
				k++;
			}
		}

		while (i < one.length) {
			r[k] = one[i];
			i++;
			k++;
		}
		while (j < two.length) {

			r[k] = two[j];
			j++;
			k++;

		}
		return r;
	}

	public static int[] mergesort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] ra = new int[1];
			ra[0] = arr[lo];
			return ra;
		}

		int mid = (lo + hi) / 2;

		int[] fsh = mergesort(arr, lo, mid);
		int[] ssh = mergesort(arr, mid + 1, hi);

		return merge(fsh, ssh);
	}

	public static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int left = lo, right = hi;
		int pivot = arr[(lo + hi) / 2];
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
	}
}
