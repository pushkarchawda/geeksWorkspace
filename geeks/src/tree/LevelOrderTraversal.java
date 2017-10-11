package tree;

public class LevelOrderTraversal {

	Node root;
	
	public static void main(String[] args) {

		LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        tree.levelOrderTravarsal();
	}

	public void levelOrderTravarsal() {
		// TODO Auto-generated method stub
		
		int h = height(root);
		//System.out.println(h);
		for(int i = 1; i <= h; i++)
		{
			printLevelOrderTravarsal(root, i);
		}
		
	}

	private void printLevelOrderTravarsal(Node root2, int i) {
		if(root2 == null)
			return;
			
		if(i == 1)
			System.out.println(root2.d);
		
		if(i > 1)
		{
			printLevelOrderTravarsal(root2.left, i-1);
			printLevelOrderTravarsal(root2.right, i-1);
		}
	}

	private int height(Node root2) {
		// TODO Auto-generated method stub
	if(root2 == null)
		return 0;
	
	int lHeight = height(root2.left);
	int rHeight = height(root2.right);
	
	if(lHeight < rHeight)
		return rHeight+1;
	else
		return lHeight+1;
		
	}

}
