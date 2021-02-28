package Deque;

class DequeType {
	Node head;
	Node tail;
	
	public DequeType() {
		head = null;
		tail = null;
	}
	
	//�ʱ�ȭ �Լ�
	public void init() {
		head = null;
		tail = null;
	}
	
	//����ֳ�?
	public boolean isEmpty() {
		return head == null;
	}
	
	//���� ����
	public void add_head(int data) {
		Node newNode = new Node(data);
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.rlink = head;
			head.llink = newNode;
			head = newNode;
		}
	}
	
	//�Ĵ� ����
	public void add_tail(int data) {
		Node newNode = new Node(data);
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.rlink = newNode;
			newNode.llink = tail;
			tail = newNode;
		}
		
	}
	
	//���� ����
	public int delete_front() {
		Node removed_node;
		int item;
		
		if (isEmpty()) 
			return -1;
		else {
			removed_node = head;
			item = removed_node.data;		
			head = removed_node.rlink;
			
			if (head != null) {
				head.llink = null;
			} else {
				tail = null;
			}
			return item;
		}
	}
	//�Ĵ� ����
	public int delete_tail() {
		Node removed_node;
		int item;
		
		if (isEmpty())
			return -1;
		else {
			removed_node = tail;
			item = removed_node.data;
			tail = removed_node.llink;
			
			if (tail != null) {
				tail.rlink = null;
			} else {
				head = null;
			}
			return item;
		}
		
	}
	//display
	public void display() {
		for (Node n = head; n != null; n = n.rlink) {
			System.out.print(n.data + " ");
		}
	}
}
