package june_14;

public class binarysearch {

	public static void main(String[] args) {

		Integer[] s = { 10, 20, 30, 40, 50, 60, 70, 80 };
		System.out.println(binarysearch(s, 70));
	}

	public static int binarysearch(Integer[] arr, int data) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (data == arr[mid]) {
				return mid;
			} else if (data > arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

}
