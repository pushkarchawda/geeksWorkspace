package tree;

public class BinaryTreeTraversal {
	
	Node root;

	public static void main(String[] args) {

		BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPostorder();
 
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();
 
        /*System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
		*/
		
	}
	
	void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }

	private void printPostorder(Node root) {
		if(root == null)
			return;

		System.out.println(root.d);
		printPostorder(root.left);
		printPostorder(root.right);
		
		// TODO Auto-generated method stub
		
	}
	
	private void printInorder(Node root) {
		if(root == null)
			return;

		printPostorder(root.left);
		System.out.println(root.d);
		printPostorder(root.right);
		
		// TODO Auto-generated method stub
		
	}
	
	private void printPreorder(Node root) {
		if(root == null)
			return;

		printPostorder(root.left);
		printPostorder(root.right);
		System.out.println(root.d);
		
		// TODO Auto-generated method stub
		
	}

}
