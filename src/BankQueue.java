
public class BankQueue {
	Node head;

	public void addCustomer(String name, int label) {
		Node newNode = new Node(name, label);

		if (head == null) {
			head = newNode;
			return;
		}

		int limit = 0;
		if (label == 0)
			limit = 5;
		else if (label == 1)
			limit = 3;
		else if (label == 2)
			limit = 2;
		else if (label == 3)
			limit = 1;

		Node current = head;
		Node prev = null;
		int counter = 0;

		while (current != null && current.label <= newNode.label) {
			if (current.label == newNode.label) {
				counter++;
			} else {
				counter = 0;
			}
			prev = current;
			current = current.next;
		}

		boolean hasOverflow = false;
		Node check = current;
		while (check != null) {
			if (check.label == newNode.label) {
				hasOverflow = true;
				break;
			}
			check = check.next;
		}

		if (counter >= limit || hasOverflow == true) {
			while (current != null) {
				prev = current;
				current = current.next;
			}
		}

		if (prev == null) {
			newNode.next = head;
			head = newNode;
		} else {
			newNode.next = current;
			prev.next = newNode;
		}
	}

	public void processCustomer() {
		if (head == null) {
			System.out.println("There is no customer in the queue");
			return;
		}
		System.out.println(head.name + " is processed-" + head.label);
		head = head.next;
	}

	public void printQueue() {
		if (head == null) {
			System.out.println("Current Queue: Empty");
			return;
		}
		System.out.print("Current Queue: ");
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.label);
			if (temp.next != null) {
				System.out.print("-");
			}
			temp = temp.next;
		}
		System.out.println();
	}
}