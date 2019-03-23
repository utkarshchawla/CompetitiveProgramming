package aug_18;

public class ass9ques18 {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 0, 2, 1, 2, 1, 0, 1, 2 };
		sort3elements(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void sort3elements(int[] arr) {
		int lo = 0;
		int mid = 0;
		int hi = arr.length - 1;

		while (mid <= hi) {

			if (arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[lo];
				arr[lo] = temp;
				lo++;
				mid++;

			} else if (arr[mid] == 1) {
				mid++;
			} else {
				int temp = arr[mid];
				arr[mid] = arr[hi];
				arr[hi] = temp;
				hi--;

			}

		}
	}

}
