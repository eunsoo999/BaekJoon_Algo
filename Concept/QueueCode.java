import java.util.LinkedList;
import java.util.Queue;

public class QueueCode {

	public static void main(String[] args) {
		Queue<Integer> intQueue = new LinkedList<>();
		Queue<String> stringQueue = new LinkedList<>();
		
		intQueue.add(1);
		intQueue.add(2);
		intQueue.offer(3);
		
		stringQueue.add("일");
		stringQueue.add("이");
		
		System.out.println("int형 배열");
		for (int i : intQueue) {
			System.out.println(i);
		}
		
		System.out.println("String형 배열");
		for (String i : stringQueue) {
			System.out.println(i);
		}
		
		System.out.println("삭제");
		
		intQueue.peek(); //첫번째 값 참조(출력)
		intQueue.poll(); // 첫번째 값 제거. 비어있다면 널
		intQueue.remove(); // 첫번째 값 제거
		intQueue.clear(); //초기화
	}

}
