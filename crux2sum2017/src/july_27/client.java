package july_27;

public class client {

	public static void main(String[] args) {
//		int[] post = {12, 30, 40, 37, 25, 60, 70, 62, 87, 75, 50};
		int[] in = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
//		int[] in = {1,2,3};
//		int[] post = {1,3,2};
//		BST bst = new BST(post, in);
		BST bst = new BST(in);
		bst.display();
		System.out.println();
//		System.out.println(bst.max());
//		System.out.println(bst.min());
//		bst.add(80);
//		bst.add(90);
//		bst.display();
//		bst.remove(50);
//		bst.remove(40);
//		bst.remove(50);
//		bst.remove(40);
//		bst.display();
//		bst.replaceWithSum();
//		bst.assques2();
//		bst.assques3(75);
//		bst.assques3b(87);
//		bst.display();
//		bst.pir(12, 75);
		bst.assques9(117);
	}

}
