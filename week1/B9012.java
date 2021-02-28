import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Character> stack = new Stack<Character>();
	
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			String input = br.readLine();

			boolean check = true; // VPS 체크 변수 
			
			if (input.length() == 0) {
				check = false;
			} //아무 입력 없이 엔터를 치는 경우 VPS가 아님.
			
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == '(') {
					stack.push(input.charAt(j)); // '(' 일 때 스택에 삽입
				} else if (input.charAt(j) == ')') {
					if (stack.isEmpty()) {
						check = false;
						break;
					} else { 
						stack.pop();
					}
				}
			}

			if (stack.empty() && check) {
				bw.write("YES");
				bw.newLine();
			}
			else {
				bw.write("NO");
				bw.newLine();
			}
			stack.clear();
		}
		bw.flush();
	}
}