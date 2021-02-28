package Deque;

public class Deque_1 {

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
