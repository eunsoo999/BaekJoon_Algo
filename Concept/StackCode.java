import java.util.Stack;

public class StackCode {

	public static void main(String[] args) {

		Stack<Integer> intstack = new Stack<>();
		
		System.out.println("[스택] : " + intstack.toString());
		System.out.println("비어있나? : " + intstack.isEmpty());
		
		intstack.push(1);
		intstack.push(2);
		intstack.push(3);
		intstack.push(4);
		
		System.out.println("[스택] : " + intstack.toString());
		
		System.out.println("pop : " + intstack.pop());
		
		System.out.println("[스택] : " + intstack.toString());
		
		System.out.println("peek : " + intstack.peek());
		
		System.out.println("size : " + intstack.size());

	}
}
