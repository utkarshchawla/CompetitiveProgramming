package aug_18;

public class Client {

	public static void main(String[] args) {
		
		int[] arr = {10,2,3,7,6,4,8,-2};
		SegmentTree st = new SegmentTree(arr,new SegmentAddOperator());
		System.out.println(st.query(2, 5));
//		st.update(3, -7);
//		System.out.println(st.query(2, 5));
//		st.changeOperator(new SegmentAddOperator());
//		System.out.println(st.query(2, 5));

	}

}
