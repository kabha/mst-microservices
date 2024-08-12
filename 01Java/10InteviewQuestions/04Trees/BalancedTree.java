package trees;

public class BalancedTree {

	Node root;

	class Node {

		int value;
		Node left, right;

		Node(int value) {
			this.value = value;
		}
	}

	public static boolean isBalanced(Node root) {

		if (root == null)
			return true;

		if (getHigh(root.left) - getHigh(root.right) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;

		return false;
	}

	public static int getHigh(Node root) {

		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(getHigh(root.left), getHigh(root.right));

		}
	}
}
