package linkedlist_stack_queue;

/* Delete nodes which have a greater value on right side */

public class DeleteNodeGreaterValueOnRight {

	Node head;

	public static void main(String[] args) {
		DeleteNodeGreaterValueOnRight llist = new DeleteNodeGreaterValueOnRight();

		/* Created Linked List 1->2->3->4->5 */
		llist.push(6);
		llist.push(4);
		llist.push(9);
		llist.push(2);
		llist.push(5);
		llist.push(0);

		System.out.println("Linked List before calling pairWiseSwap() ");
		llist.printList();

		llist.deleteNode();

		System.out.println("Linked List after calling pairWiseSwap() ");
		llist.printList();

	}

	private void deleteNode() {

		Node prev = null, current = null, next = null;
		boolean flag = false;

		if (head == null)
			return;

		while (!flag) {
			if (head.data < head.next.data) {
				head = head.next;
				flag = false;

			} else {
				flag = true;
			}

			current = head;
		}

		while (current.next != null) {
			next = current.next;
			if (current.data < next.data) {

				prev.next = next;
				prev = next;

			} else {
				prev = current;
			}

			current = next;
		}

	}

	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
