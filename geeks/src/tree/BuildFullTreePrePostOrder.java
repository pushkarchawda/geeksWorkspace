package tree;

public class BuildFullTreePrePostOrder {

	Node root;
	int k=0;

	public static void main(String[] args) {

		BuildFullTreePrePostOrder tree = new BuildFullTreePrePostOrder();
		int post[] = new int[]{8, 9, 4, 5, 2, 6, 7, 3, 1};
        int pre[] = new int[]{1, 2, 4, 8, 9, 5, 3, 6, 7};
        
		
		tree.root = tree.buildTree(post, pre, 0, post.length-1);//new Node(pre[0]); 
		
		
		
		tree.printInorder(tree.root);

	}
	
	public Node buildTree(int[] post, int[] pre, int i, int j) {

		if(i>j || k>=pre.length)
			return null;
		
		Node temp = new Node(pre[k++]); 
		
		if (i == j || k>=pre.length)
            return temp;
		
		int x = searcInOrder(post, i, j, pre[k]);
		
		/*if(i == x)
			return new Node(pre[k]);*/
		if(x<=j)
		{
			temp.left = buildTree(post, pre, i, x);
			temp.right = buildTree(post, pre, x+1, j-1);
		}
		return temp;
		
	}

	private int searcInOrder(int[] post, int i, int j, int y) {

		for(int c = i ; c <= j; c++)
		{
			if(post[c] == y)
			{
				return c;
			}
		}
		
		return i;
	}
	
	private void printInorder(Node root) {
		if(root == null)
			return;

		printInorder(root.left);
		System.out.print(root.d+"->");
		printInorder(root.right);
	}

}
