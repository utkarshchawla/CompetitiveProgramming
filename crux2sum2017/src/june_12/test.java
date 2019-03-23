package june_12;

public class test {

	public static void main(String[] args) {
		
		
		int[] arr = new int[3];
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
//		System.out.println(arr[3]);
		
		arr[0] = 10;
		arr[1] = 30;
		arr[2] = 20;
//		arr[3] = 40;
		
		int i = 0, j = arr.length - 1;
		System.out.println(arr[i] + ", " + arr[j]);
		Swap(arr, i, j);
		System.out.println(arr[i] + ", " + arr[j]);
	}
	public static void Swap(int[] arr, int i, int j) {
//		System.out.println(arr[i] + ", " + arr[j]);

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
//		System.out.println(arr[i] + ", " + arr[j]);
	}

	
	

}
