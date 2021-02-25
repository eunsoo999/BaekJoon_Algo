import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class B11279v2 {

	public static void main(String[] args) throws Exception {
	
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (input == 0) {
				if (queue.size() == 0)
					result.append(0 + "\n");
				else 
					result.append(queue.poll() * -1 + "\n");
			} else {
				queue.add(input * -1); 
				/* 우선순위(1위,2위,3위)는 숫자가 낮은게 우선순위가 높다.
				 * 따라서 최대힙을 구현하기 위해서는 -1을 곱해주고, 제거할때 다시 -1을 곱해줘서 양수로 만든다.
				 */
			}
		}
		System.out.println(result);
	}
}
