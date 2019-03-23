package july_31;

public class Generics {

	public static void main(String[] args) {

		Integer[] arr = { 33, 44, 66, 11, 22, 55 };
		bubblesort(arr);
		display(arr);

		Student[] students = new Student[5];
		students[1] = new Student("Modi", 100, 1);
		students[2] = new Student("Kejri", 10, 75);
		students[3] = new Student("Rahul", 0, Integer.MAX_VALUE);
		students[4] = new Student("ABC", 50, 50);
		students[0] = new Student("DEF", 40, 60);

		bubblesort(students);
		display(students);

	}

	public static <T> void display(T[] arr) {
		for (T val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println(".");
	}

	public static <T extends Comparable<T>> void bubblesort(T[] arr) {
		int count = 1;
		while (count < arr.length) {
			for (int i = 0; i < arr.length - count; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			count++;
		}
	}
}
