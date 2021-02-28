import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B5397 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> leftStack = new Stack<Character>();
		Stack<Character> rightStack = new Stack<Character>();
		
		int tc = Integer.parseInt(br.readLine()); 
		
		for (int i = 0; i < tc; i++) {
			String pw = br.readLine();
			//String[] pwArray = pw.split(""); //배열로 주는대신 charAt(i)
			
			for (int j = 0; j < pw.length(); j++) { //String.length() 문자열길이
				if (pw.charAt(j) == '<') {
					if (!leftStack.isEmpty()) {
						rightStack.push(leftStack.pop());
					}
				} else if (pw.charAt(j) == '>') {
					if (!rightStack.isEmpty()) {
						leftStack.push(rightStack.pop());
					}
				} else if (pw.charAt(j) == '-') {
					if (!leftStack.isEmpty()) {
						leftStack.pop();
					}
					
				} else {
					leftStack.push(pw.charAt(j));
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			while (!rightStack.isEmpty()) {
				leftStack.push(rightStack.pop());
			}
			
			while (!leftStack.isEmpty()) {
				sb.append(leftStack.pop());
			}
			
			System.out.println(sb.reverse().toString());
		}
	}
}
