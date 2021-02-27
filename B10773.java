import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B10773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			int answer = Integer.parseInt(br.readLine());
			
			if (answer == 0) {
				stack.pop();
			} else {
				stack.push(answer);
			}
		}
		
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
		
		br.close();
	}

}
