package july_26;

public class Client {

	public static void main(String[] args) {
		int[] post = { 12, 30, 37, 25, 60, 62, 87, 75, 50 };
		int[] in = { 12, 25, 30, 37, 50, 60, 62, 75, 87 };
		// BinaryTree bt = new BinaryTree();
		BinaryTree bt = new BinaryTree(post, in);
		// 50 true 25 true 12 false false true 37 true 30 false false true 40
		// false false true 75 true 62 true 60 false false true 70 false false
		// true 87 false false
		// 50 true 50 true 50 false false true 50 true 50 false false
		bt.display();
		System.out.println();
		// System.out.println(bt.levelLL());
		// System.out.println(bt.size);
		// System.out.println(bt.max());
		// System.out.println(bt.find(65));
		// System.out.println(bt.height());
		// System.out.println(bt.diameter());
		// System.out.println(bt.isBalanced());
		// System.out.println(bt.isBST());
		// bt.postOrder();
		// System.out.println();
		// System.out.println();
//		 bt.preOrder();
//		 System.out.println();
		// System.out.println();
		// bt.inOrder();
		// System.out.println();
		// bt.levelOrder();
//		bt.preOrderIter();
		// bt.postOrderIter();
		// bt.inOrderIter();
		// bt.printsib();
		// System.out.println();
		// bt.removeleaves();
		// bt.display();
//		 System.out.println(bt.LCA(25, 50));
		 bt.kaway(3, 25);
	}

}
