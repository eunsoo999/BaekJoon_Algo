package LinkedList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class B1966 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int tc = sc.nextInt(); //TEST CASE 개수
		int m; //문서 개수
		int index; //몇번째에 출력되는지 궁금한 문서의 인덱스
		
		for (int i = 0; i < tc; i++) {
			m = sc.nextInt();
			index = sc.nextInt();
			
			PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(); // 문서의 중요도를 우선순위 큐를 이용하여 정렬
			Queue<Node> queue = new LinkedList<>();
			
			for (int j = 0; j < m; j++) {
				int data = sc.nextInt();
				Node n = new Node(j, data);
				
				pqueue.add(data * -1); //우선순위(1위,2위,3위)는 낮을 수록 우선적이므로 -1을 곱해서 최대값이 우선이 되도록 함.
				queue.add(n);
			}
			
			int count = 0; //인쇄 번호
			while (!queue.isEmpty()) {
				Node temp = queue.poll();
				
				if (pqueue.peek() * -1 != temp.importance) {
					queue.add(temp);
					//우선순위에 있는 문서의 중요도와 인쇄순서에 있는 문서의 중요도가 다르면 queue에 다시 집어넣음
				} else {
					//우선순위에 있는 문서와 인쇄순서의 문서의 중요도가 같을 경우 인쇄출력하기.
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