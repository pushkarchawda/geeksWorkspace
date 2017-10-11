package tree;

public class BinaryTreeTraversalMorris {

	Node root;

	public static void main(String[] args) {

		BinaryTreeTraversalMorris tree = new BinaryTreeTraversalMorris();
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

		System.out.println("Inorder traversal of binary tree using morris is ");
		tree.printInorderMorris(tree.root);
		System.out.println("Postorder traversal of binary tree using 1 stacks is ");
		tree.printPostorderMorris(tree.root); // reverse them later

		System.out.println("\nPreorder traversal of binary tree is ");
		tree.printPreorderMorris(tree.root);
		
		/*System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder(tree.root);*/

	}

	private void printPostorderMorris(Node root) {

		Node current = root;
		while(current!=null)
		{
			if(current.left == null)
			{
				System.out.print(current.d+"->");
				current = current.right;
			}
			else
			{
				Node prev = current.left;
				while(prev.right != null && prev.right !=current)
				{
					prev = prev.right;
				}
				
				if(prev.right == null)
				{
					prev.right = current;
					current = current.left;
				}
				else
				{
					prev.right = null;
					current = current.right;
					//System.out.print(current.d+"->");

				}
			}
			
		}
		
		System.out.println();
		
	}
	
	private void printInorderMorris(Node root) {

		Node current = root;
		while(current!=null)
		{
			if(current.left == null)
			{
				System.out.print(current.d+"->");
				current = current.right;
			}
			else
			{
				Node prev = current.left;
				while(prev.right != null && prev.right !=current)
				{
					prev = prev.right;
				}
				
				if(prev.right == null)
				{
					prev.right = current;
					current = current.left;
				}
				else
				{
					prev.right = null;
					System.out.print(current.d+"->");
					current = current.right;
				}
			}
			
		}
		
		System.out.println();
		
	}
	
	
	private void printPreorderMorris(Node root) {

		Node current = root;
		while(current!=null)
		{
			if(current.left == null)
			{
				System.out.print(current.d+"->");
				current = current.right;
			}
			else
			{
				Node prev = current.left;
				while(prev.right != null && prev.right !=current)
				{
					prev = prev.right;
				}
				
				if(prev.right == null)
				{
					prev.right = current;
					System.out.print(current.d+"->");
					current = current.left;
				}
				else
				{
					prev.right = null;
					current = current.right;
				}
			}
			
		}
		
		System.out.println();
		
	}

}
