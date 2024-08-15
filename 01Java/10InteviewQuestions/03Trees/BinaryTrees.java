package trees;

public class BinaryTrees {
	

    
	private static void transitveTree(Node tree)
	{
		if(tree == null)
			System.out.print("");
		else {
			transitveTree(tree.left);
			System.out.println(tree.val);
			transitveTree(tree.right);
			
		}
		
	}

	
	private static boolean isValidTree(Node tree)
	{
		if(tree == null) return true;
		if(tree.left != null && tree.left.val > tree.val)
			return false;
		if(tree.right!= null && tree.right.val < tree.val)
			return false;
		
		if(!isValidTree(tree.left ) || !isValidTree(tree.right))
			return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		Node tree1,tree2,tree3,tree4,tree5;
	    
		tree1 = new Node(4);
        tree1.left = new Node(1);
        tree1.right = new Node(3);

        tree2 = new Node(5);
        tree2.left = new Node(10);
        tree2.left.left = new Node(17);
        tree2.left.right = new Node(3);
        tree2.right = new Node(8);

        // Binary search trees
        tree3 = new Node(6);
        tree3.left = new Node(3);

        tree4 = new Node(5);
        tree4.left = new Node(3);
        tree4.left.left = new Node(2);
        tree4.left.left.left = new Node(1);

        tree5 = new Node(8);
        tree5.left = new Node(6);
        tree5.right = new Node(9);
        tree5.left.left = new Node(5);
        tree5.left.right = new Node(7);
        tree5.right.right = new Node(10);
        
        transitveTree(tree3);
       System.out.println(isValidTree(tree3));
	}
	
	static class Node {
		int val ;
		Node left;
		Node right;
		
		public Node (int val) {
			this.val =val;
		}
	}

}
