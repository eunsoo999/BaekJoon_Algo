package LinkedList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class B1966 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int tc = sc.nextInt(); //TEST CASE ����
		int m; //���� ����
		int index; //���°�� ��µǴ��� �ñ��� ������ �ε���
		
		for (int i = 0; i < tc; i++) {
			m = sc.nextInt();
			index = sc.nextInt();
			
			PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(); // ������ �߿䵵�� �켱���� ť�� �̿��Ͽ� ����
			Queue<Node> queue = new LinkedList<>();
			
			for (int j = 0; j < m; j++) {
				int data = sc.nextInt();
				Node n = new Node(j, data);
				
				pqueue.add(data * -1); //�켱����(1��,2��,3��)�� ���� ���� �켱���̹Ƿ� -1�� ���ؼ� �ִ밪�� �켱�� �ǵ��� ��.
				queue.add(n);
			}
			
			int count = 0; //�μ� ��ȣ
			while (!queue.isEmpty()) {
				Node temp = queue.poll();
				
				if (pqueue.peek() * -1 != temp.importance) {
					queue.add(temp);
					//�켱������ �ִ� ������ �߿䵵�� �μ������ �ִ� ������ �߿䵵�� �ٸ��� queue�� �ٽ� �������
				} else {
					//�켱������ �ִ� ������ �μ������ ������ �߿䵵�� ���� ��� �μ�����ϱ�.
					pqueue.poll();
					count++;
					if (temp.index == index) {
						sb.append(count + "\n");
						break;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}

class Node {
	int index;
	int importance;
	
	public Node(int index, int importance) {
		this.index = index;
		this.importance = importance;
	}
}