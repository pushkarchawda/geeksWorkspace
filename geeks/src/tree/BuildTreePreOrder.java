package tree;

public class BuildTreePreOrder {

	Node root;
	int k=0;

	public static void main(String[] args) {

		BuildTreePreOrder tree = new BuildTreePreOrder();
		char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        
		
		tree.root = tree.buildTree(in, pre, 0, in.length-1);
		
		tree.printInorder(tree.root);

	}
	
	public Node buildTree(char[] in, char[] pre, int i, int j) {

		if(i>j)
			return null;
		
		char y = pre[k++];
		
		Node temp = new Node(y);
		
		if (i == j)
            return temp;
		
		int x = searcInOrder(in, i, j, y);
    	temp.left = buildTree(in, pre, i, x-1);
		temp.right = buildTree(in, pre, x+1, j);
		
		return temp;
		
	}

	private int searcInOrder(char[] in, int i, int j, char y) {

		for(int c = i ; c <= j; c++)
		{
			if(in[c] == y)
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
