import java.util.LinkedList;
import java.util.Queue;

public class QueueCode {

	public static void main(String[] args) {
		Queue<Integer> intQueue = new LinkedList<>();
		Queue<String> stringQueue = new LinkedList<>();
		
		intQueue.add(1);
		intQueue.add(2);
		intQueue.offer(3);
		
		stringQueue.add("��");
		stringQueue.add("��");
		
		System.out.println("int�� �迭");
		for (int i : intQueue) {
			System.out.println(i);
		}
		
		System.out.println("String�� �迭");
		for (String i : stringQueue) {
			System.out.println(i);
		}
		
		System.out.println("����");
		
		intQueue.peek(); //ù��° �� ����(���)
		intQueue.poll(); // ù��° �� ����. ����ִٸ� ��
		intQueue.remove(); // ù��° �� ����
		intQueue.clear(); //�ʱ�ȭ
	}

}
