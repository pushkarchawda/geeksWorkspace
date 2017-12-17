package binarytree;

/**
 * http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 * 
 * Given a binary tree, write a function that returns true if the tree satisfies
 * below property.
 * 
 * For every node, data value must be equal to sum of data values in left and
 * right children. Consider data value as 0 for NULL children. Below tree is an
 * example
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class SumProperty {
	public Node root;
	static boolean childrenSumFlag = true;

	public static void main(String[] args) {
		BinaryTreeAllViews tree = new BinaryTreeAllViews();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);

/* Constructed binary tree is
	    
        10
       /  \
     8     2
    / \   /
   3   5 2
  
 */
		
		childrenSumPropertyBottomUp(tree.root);
		System.out.println("children Sum Property "+childrenSumFlag);
		
		childrenSumPropertyTopDown(tree.root); // prefer this
		System.out.println("children Sum Property "+childrenSumFlag);
	}
	
private static int childrenSumPropertyBottomUp(Node root) {
		
		if(root == null)
			return 0;
		
		int left=0,right=0;
		
		if(root.left!=null)
		{
			left = childrenSumPropertyBottomUp(root.left);
		}
		if(root.right!=null)
		{
			right = childrenSumPropertyBottomUp(root.right);
		}
		
		if(left == 0 && right == 0)
			return root.data;
		
		if(left+right == root.data && childrenSumFlag)
			{
				childrenSumFlag = true;
				return root.data;
			}
		else
			{
				childrenSumFlag = false;
				return root.data;
			}
	}

	private static boolean childrenSumPropertyTopDown(Node root) {

		if (root == null || (root.left == null && root.right == null))
			return false;

		int left = 0, right = 0;

		left = root.left.data;
		right = root.right.data;

		if (left + right == root.data && childrenSumPropertyTopDown(root.left)
				&& childrenSumPropertyTopDown(root.right)) {
			return true;
		}

		return false;
	}

}
