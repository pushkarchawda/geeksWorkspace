package tree;

public class Node {
	
	Node left, right;
	int d;
	
	Node(int d)
	{
		this.d = d;
		left = right = null;
	}
	
	public boolean isLeaf()
	{
		if(this.left == null && this.right == null)
		{
			return true;
		}
		
		return false;
	}

}
