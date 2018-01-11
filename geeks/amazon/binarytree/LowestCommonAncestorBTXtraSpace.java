package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class LowestCommonAncestorBTXtraSpace{
	
	
	public Node root;
	static ArrayList<Node> a1 = new ArrayList<Node>();
	static ArrayList<Node> a2 = new ArrayList<Node>();
	
	static boolean a1F = true;
	static boolean a2F = true;
	

	public static void main(String[] args) throws Exception {
		LowestCommonAncestorBTXtraSpace tree = new LowestCommonAncestorBTXtraSpace();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        int n1 = 4;
        int n2 = 2;
        
        if(n1!=n2)
        	lcaBT(tree.root, n1, n2);
        else
        {
        	System.out.println("n1 and n2 can't be same");
        	System.exit(0);
        }
        
        if(a1.size() == 0 || a2.size() == 0)
        	System.out.println("Either or both of the element n1 or n2 is not present");
        
        for(int i=0;i < a1.size() && i < a2.size();i++)
        {
        	if(!(a1.get(i).data == a2.get(i).data))
        	{
        		System.out.println("Lowest Common Ancestor for BST is "+a1.get(i-1).data);
        		break;
        	}
        	
        	else if(a1.size() == i+1 || a2.size() == i+1)
        		System.out.println("Lowest Common Ancestor for BST is "+a1.get(i).data);
        }
	}

	private static void lcaBT(Node root, int n1, int n2) {

		if(root == null)
			return;
		
		if(a1F)
		{
			a1.add(root);
			if(root.data == n1)
				a1F = false;
		}
		
		if(a2F)
		{
			a2.add(root);
			if(root.data == n2)
				a2F = false;
		}
		
		lcaBT(root.left, n1, n2);
		lcaBT(root.right, n1, n2);
		
		if(a1F)
		{
			a1.remove(root);
		}
		
		if(a2F)
		{
			a2.remove(root);
		}
	}
}
