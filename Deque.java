package Deque;

public class Deque {

	public static void main(String[] args) {
		DequeType deque = new DequeType();
		
		deque.add_head(10);
		deque.add_head(20);
		deque.add_head(30);
		
		System.out.println("삽입완료");
		deque.display();
		System.out.println();
		
		System.out.println("맨앞 삭제 : " + deque.delete_front());
		deque.display();
		System.out.println();
		System.out.println("맨뒤 삭제 : " + deque.delete_tail());
		deque.display();
		System.out.println();
		
		deque.add_tail(50);
		deque.add_tail(60);
		deque.add_tail(70);
		deque.add_head(1);
		
		System.out.println("삽입완료");
		deque.display();
		System.out.println();
		
		System.out.println("맨앞 삭제 : " + deque.delete_front());
		deque.display();
		System.out.println();
		System.out.println("맨뒤 삭제 : " + deque.delete_tail());
		deque.display();
		System.out.println();

	}

}

class Node {
	int data;
	Node llink;
	Node rlink;
	
	public Node(int data) {
		this.data = data;
		this.llink = null;
		this.rlink = null;
	}

}

class DequeType {
	Node head;
	Node tail;
	
	public DequeType() {
		head = null;
		tail = null;
	}
	
	//초기화 함수
	public void init() {
		head = null;
		tail = null;
	}
	
	//비어있나?
	public boolean isEmpty() {
		return head == null;
	}
	
	//전단 삽입
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
	
	//후단 삽입
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
	
	//전단 삭제
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
	//후단 삭제
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
