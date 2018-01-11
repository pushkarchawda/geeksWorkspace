package binarytree;

public class LowestCommonAncestorBT {

	public Node root;

	static boolean a1 = false;
	static boolean a2 = false;

	public static void main(String[] args) {
		LowestCommonAncestorBT tree = new LowestCommonAncestorBT();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.left = new Node(6);
		tree.root.left.right.right = new Node(7);

		Node n = lcaBT(tree.root, 2, 4);

		if (a1 && a2)
			System.out.println("LCA = " + n.data);
		else
			System.out.println("Either or both of the element n1 or n2 is not present");

	}

	private static Node lcaBT(Node root, int n1, int n2) {

		if (root == null)
			return null;

		if (root.data == n1) {
			a1 = true;
			return root;
		}

		if (root.data == n2) {
			a2 = true;
			return root;
		}

		Node lNode = lcaBT(root.left, n1, n2);
		Node rNode = lcaBT(root.right, n1, n2);

		if (lNode != null && rNode != null)
			return root;

		return lNode != null ? lNode : rNode;
	}
}
