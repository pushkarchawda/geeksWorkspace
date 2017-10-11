package linkedlist_stack_queue;

public class LinkedList_DeleteGivenNode {

	public static void main(String[] args) {

		LinkedList_DeleteGivenNode f = new LinkedList_DeleteGivenNode();
		DeleteNode g = f.new DeleteNode();
		g.push(0);
		g.push(1);
		g.push(2);
		g.push(4);
		g.push(5);
		g.push(6);
		g.push(7);
		g.insertAfter(3, 4);
		g.append(8);
		g.append(9);

		g.display();

		System.out.println("*******");
		g.delete(6);

		g.display();

	}

	class DeleteNode {

		Node head;

		boolean push(int d) {
			Node temp = new Node(d);
			// System.out.println("temp "+temp.getData());
			if (head == null) {
				head = temp;
				return true;
			} else if (head != null) {
				temp.setNext(head);
				head = temp;
				return true;
			} else
				return false;

		}

		boolean insertAfter(int d, int valueAfterToInsert) {
			Node temp = new Node(d);

			Node current = head;

			while (current != null) {
				if (current.getData() == valueAfterToInsert) {
					temp.setNext(current.getNext());
					current.setNext(temp);
					return true;
				}
				current = current.getNext();
			}

			return false;
		}

		boolean append(int d) {
			Node temp = new Node(d);

			Node current = head;

			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(temp);
			return true;
		}

		int delete(int key) {
			if (head.getData() == key) {
				int t = head.getData();
				head = head.getNext();
				return t;
			}

			Node current = head;
			Node prev = head;
			while (current != null) {
				if (current.getData() == key) {
					int t = current.getData();
					prev.setNext(current.getNext());
					return t;
				}
				prev = current;
				current = current.getNext();
			}

			return Integer.MIN_VALUE;
		}

		void display() {
			Node current = head;
			while (current != null) {
				System.out.println(current.getData());
				current = current.getNext();
			}
		}
	}

	class Node {

		int data;
		Node next;

		Node(int d) {

			data = d;
			next = null;

		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

}
