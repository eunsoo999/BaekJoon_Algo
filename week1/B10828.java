import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B10828 {
	
	static ArrayList<Integer> stack = new ArrayList<>();

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		Stack stack = new Stack();
		ArrayList<Integer> output = new ArrayList<>();
		
		for (int i = 0; i < count; i++) {
			String input = br.readLine();
			
			if (input.contains("push")) {
				int key = Integer.parseInt(input.split(" ")[1]);
				stack.push(key);
			} else if (input.equals("pop")) {
				output.add(stack.pop());
			} else if (input.equals("size")) {
				output.add(stack.size());
			} else if (input.equals("top")) {
				output.add(stack.top());
			} else if (input.equals("empty")) {
				output.add(stack.empty());
			}
		}
		
		for (Integer str : output) {
			System.out.println(str);
		}
	}

}

class Stack {
	ArrayList<Integer> stack;
	
	public Stack() {
		stack = new ArrayList<Integer>();
	}

	public void push(int data) {
		stack.add(data);
	}
	
	public int pop() {
		int index = stack.size() - 1;
		
		if (stack.size() == 0) {
			return -1;
		} else {
			int num = stack.get(index);
			stack.remove(index);
			
			return num;
		}
	}
	
	public int size() { 
		return stack.size();
	}
	
	public int empty() {
		if (stack.size() == 0)
			return 1;
		else 
			return 0;
	}
	
	public int top() {
		
		if (size() == 0)
			return -1;
		else 
			return stack.get(size() - 1);
	}

	
	
}

