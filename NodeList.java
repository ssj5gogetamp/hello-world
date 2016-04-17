package feedingSchedule;

//import stack.Node;

public class NodeList {
	private int size;
	private Node head;
	private Node tail;

	// Default Constructor
	public NodeList() {
		size = 0;
		head = null;
		tail = null;

	}

	// 1 Node, list constructor
	public NodeList(Node head) {
		this.head = tail = head;
	}

	// Push method
	public void push(Node node) {
		Node oldHead = head;
		head = new Node(node.getName(), node.getNemesis(), node.getTravelTime(), oldHead, null);
		size++;

		Node current = head;
		while (current != null) {
			tail = current;
			current = current.getNext();

		}
	}

	public Node peek(){
		return head;
	}
	// Pop method
	public Node pop() {
		if (head == null)
			throw new RuntimeException("Stack underflow");
		Node oldHead = head;

		head = head.getNext(); // delete first node
		size--;

		return oldHead;

	}

	public String popAll() {
		while (head != null) {
			pop();

		}
		return "List obliterated.";
	}

	public void printList() {
		String listContents = "";
		Node current = head;
		while (current != null) {
			listContents += current.info() + "\n";
			current = current.getNext();
		}
		System.out.println(listContents);
		// System.out.println("The tail is: "+tail.getName());

	}

	public int getSize() {
		return size;
	}

	public void enqueue(Node node) {
		if (head == null) {
			head = tail = node;
			size++;
		} else {
			Node temp = new Node(node);
			//Node temp;
			tail.setNext(temp);
			tail = temp;
			size++;
		}
	}

	public Node dequeue() {
		return pop();
	}

	public void dequeueAll() {
		popAll();
	}
}
