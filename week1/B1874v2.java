import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class B1874 {

	public static void main(String[] args) {
		//10시 37분 시작
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<>(); //스택
		int n = sc.nextInt(); // 데이터 개수
		ArrayList<String> result = new ArrayList<String>(); //결과("+,-") 저장 리스트
		
		int count =  1; //1부터 n까지 
		for (int i = 0; i < n; i++) {
			int find = sc.nextInt(); //찾는 값
			
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
