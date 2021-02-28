import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class B1874 {

	public static void main(String[] args) {
		//10�� 37�� ����
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<>(); //����
		int n = sc.nextInt(); // ������ ����
		ArrayList<String> result = new ArrayList<String>(); //���("+,-") ���� ����Ʈ
		
		int count =  1; //1���� n���� 
		for (int i = 0; i < n; i++) {
			int find = sc.nextInt(); //ã�� ��
			
			while(count <= find) {
				stack.push(count);
				result.add("+");
				count++;
			}
			
			if (stack.peek() == find) {
				stack.pop();
				result.add("-");
			} else {
				System.out.println("NO");
				return;
			}
		}
			
			for(String s : result) {
				System.out.println(s);
			}
	
}
}
