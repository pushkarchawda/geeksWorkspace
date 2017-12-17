package binarytree;

public class LowestCommAncestorBST {
	
	public Node root;

	public static void main(String[] args) {
		LowestCommAncestorBST tree = new LowestCommAncestorBST();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        
        int node_data = lcaBST(tree.root, 4, 22);
        System.out.println("Lowest Common Ancestor for BST is "+node_data);

	}

	private static int lcaBST(Node root, int n1, int n2) {

		if(root == null)
			return 0;
		
		int x = root.data;
		
		if(x>n1 && x>n2)
			return lcaBST(root.left, n1, n2);
		else if(x<n1 && x<n2)
			return lcaBST(root.right, n1, n2);
		else
			return x;
	}

}
