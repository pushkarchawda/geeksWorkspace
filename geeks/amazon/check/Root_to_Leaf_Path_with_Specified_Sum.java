package check;

class Node1 {
	int data;
	Node left, right;

	Node1(int item) {
		data = item;
		left = right = null;
	}
}

public class Root_to_Leaf_Path_with_Specified_Sum {

	Node root;
	static int count=0; 

	public static void main(String[] args) {
		int sum = 21;

		 /* Constructed binary tree is
        10
       /  \
     8     2
    / \   /
   3   5 2
  */
		Root_to_Leaf_Path_with_Specified_Sum tree = new Root_to_Leaf_Path_with_Specified_Sum();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		
		System.out.println(hasSumEqual(sum, tree.root));

	}

	private static int hasSumEqual(int sum, Node root2) {
		
		if(root2.left == null && root2.right == null)
		{
			return count+root2.data;
		}
		
		if(root2.left != null)
		{
			count=count+hasSumEqual(sum, root2.left);
		}
		
		if(root2.right != null)
		{
			count=count+hasSumEqual(sum, root2.right);
		}
		
		return count+root2.data;
		
		
	}

}
