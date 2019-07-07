
public class h {

    public static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        Node ans = removeHalfNodes(root);
        System.out.println(ans.data);
    }

    public static Node removeHalfNodes(Node root) {
        if (root == null) return null;
        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);
        if (root.left == null && root.right == null) return root;
        else if (root.left == null) return root.right;
        else if (root.right == null) return root.left;
        return root;
    }

}
