package tree;

public class BinaryTreeDFS {
	
	Node root;

	public static void main(String[] args) {
		
		BinaryTreeDFS tree = new BinaryTreeDFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        
        System.out.println("Postorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);
        System.out.println("\nPreorder traversal of binary tree is ");
        tree.printPreorder(tree.root);
		
		
	}

	private void printInorder(Node root) {
		if(root == null)
			return;

		printInorder(root.left);
		System.out.print(root.d+"->");
		printInorder(root.right);
	}

	private void printPostorder(Node root) {
		
		if(root == null)
			return;

		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.d+"->");
	}
	
	private void printPreorder(Node root) {
		if(root == null)
			return;

		System.out.print(root.d+"->");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	

}
