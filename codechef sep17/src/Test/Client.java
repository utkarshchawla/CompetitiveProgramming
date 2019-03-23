package Test;

public class Client {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		SegmentTree st = new SegmentTree(arr);
		System.out.println(st.query(0, 3));
		st.update(2, 10);
		System.out.println(st.query(0, 3));

	}

}
