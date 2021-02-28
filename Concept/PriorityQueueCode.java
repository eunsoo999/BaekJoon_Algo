import java.util.Collections;
import java.util.PriorityQueue;
public class PriorityQueueCode {

	public static void main(String[] args) throws Exception {
	
		PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		queue1.add(11);
		queue1.add(4);
		queue1.add(7);
		
		queue2.add(10);
		queue2.add(4);
		queue2.add(7);
		
		System.out.println(queue1.toString());
		System.out.println(queue2.toString());
		
		System.out.println(queue1.peek());
		System.out.println(queue2.peek());
	}
}
