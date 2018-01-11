package _linkedlist;

/**
 * Add two numbers represented by linked lists | Set 1 2.4 Given two numbers
 * represented by two lists, write a function that returns sum list. The sum
 * list is list representation of addition of two input numbers.
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class AddTwoLinekdList {

	Node head1, head2;

	public static void main(String[] args) {
		AddTwoLinekdList list = new AddTwoLinekdList();

		// creating first list
		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);
		System.out.print("First List is ");
		list.printList(list.head1);

		// creating seconnd list
		list.head2 = new Node(8);
		list.head2.next = new Node(4);
		System.out.print("Second List is ");
		list.printList(list.head2);

		// add the two lists and see the result
		Node rs = list.addTwoLists(list.head1, list.head2);
		System.out.print("Resultant sum list without reversing required is ");
		list.printList(rs);
	}

	private Node addTwoLists(Node head1, Node head2) {

		Node current1 = head1, current2 = head2;
		Node sumHead = null, temp = null;
		int sum = 0, carry = 0;

		while (current1 != null && current2 != null) {
			sum = current1.data + current2.data + carry;
			carry = sum / 10;

			temp = new Node(sum % 10);

			if (sumHead == null)
				sumHead = temp;
			else {
				temp.next = sumHead;
				sumHead = temp;
			}

			current1 = current1.next;
			current2 = current2.next;

		}

		while (current1 != null) {
			sum = current1.data + carry;
			carry = sum / 10;

			temp = new Node(sum % 10);

			if (sumHead == null)
				sumHead = temp;
			else {
				temp.next = sumHead;
				sumHead = temp;
			}

			current1 = current1.next;
		}

		if (carry > 0) {
			temp.next = new Node(carry);
			temp.next = sumHead;
			sumHead = temp;
		}

		return sumHead;
	}

	void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}

}
