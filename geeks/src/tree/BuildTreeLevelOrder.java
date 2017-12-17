package tree;

public class BuildTreeLevelOrder {

	Node root;
	int k=0;
	boolean found = false;

	public static void main(String[] args) {

		BuildTreeLevelOrder tree = new BuildTreeLevelOrder();
		int in[] = new int[]{4,8,10,12,14,20,22};
        int level[] = new int[]{20,8,22,4,12,10,14};
        
		
		tree.root = tree.buildTree(in, level, 0, in.length-1);
		
		tree.printInorder(tree.root);

	}
	
	public Node buildTree(int[] in, int[] level, int i, int j) {

		if(i>j)
			return null;
		
		//int y = pre[k++];
		
		Node temp = null;
		
		if (i == j)
            return new Node(in[i]);
		
		int x = 0 ;
		int saveK = 0;
		while(!found)
		{
			temp = new Node(level[saveK]);
			x = searcInOrder(in, i, j, level[saveK++]);
		}
		//k = saveK;
		found = false;
    	temp.left = buildTree(in, level, i, x-1);
		temp.right = buildTree(in, level, x+1, j);
		
		return temp;
		
	}

	private int searcInOrder(int[] in, int i, int j, int y) {

		for(int c = i ; c <= j; c++)
		{
			if(in[c] == y)
			{
				found = true;
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
