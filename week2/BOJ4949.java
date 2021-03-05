package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ4949 {
	
	public static String checkString(String input) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(' || input.charAt(i) == '[') { // (, [인 경우에는 스택에 push
				stack.push(input.charAt(i));
			} else if (input.charAt(i) == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					return "no";
				} else {
					stack.pop(); // 균형이 맞으면 스택에서 꺼냄.
				}
			} else if (input.charAt(i) == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					return "no";
				} else {
					stack.pop();
				}
			}
		}
		
		if (stack.isEmpty()) {
			return "yes";
		} else {
			return "no";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input;
		
		while (true) {
			input = br.readLine();

			if (input.equals(".")) {
				break;
			}
			bw.write(checkString(input) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
