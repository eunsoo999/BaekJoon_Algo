package LinkedList;

public class LinkedList {
	Node head;
	Node tail;
	int size;
	
	public static class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//맨앞삽입
	public void insert_node_first(int data) {
		Node n = create_Node(data);
		
		if (head == null) {
			head = n;
			tail = n;
		} else {
			n.next = head;
			head = n;
		}
	}
	
	//마지막 삽입
	public void insert_node_last(int data) {
		Node n = create_Node(data);
		
		if (head == null) {
			insert_node_first(data);
		} else {
			tail.next = n;
			tail = n;
			size++;
		}
	}
	
	//맨앞 삭제
	public int remove_node_first() {
		if (head == null) return -1;
		
		Node temp = head;
		head = head.next;
		int item = temp.data;
		temp = null;
		size--;
		return item;
	}
	
	//item 삭제
	public void remove_node(int item) {
		
		
		
	}
	
	//display
	public void display() {
		Node p = head;
		
		while (p.next != null) {
			System.out.println(p.data);
			p = p.next;
		}
	}
	
	//create Node
	public Node create_Node(int data) {
		return new Node(data);
		
	}
}
