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
				/* �켱����(1��,2��,3��)�� ���ڰ� ������ �켱������ ����.
				 * ���� �ִ����� �����ϱ� ���ؼ��� -1�� �����ְ�, �����Ҷ� �ٽ� -1�� �����༭ ����� �����.
				 */
			}
		}
		System.out.println(result);
	}
}
