package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ17298 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		
		String[] arr = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}

		for(int i = 0; i < N; i++) {
			// 스택의 최상단 인덱스의 값보다 큰 수가 있으면 그 값이 오큰수
			while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
				array[stack.pop()] = array[i];
			}
			stack.push(i);
			
//			if (stack.isEmpty()) { // 스택이 비어있으면 배열의 인덱스를 push
//				stack.push(i);
//			}else if (array[stack.peek()] < array[i]) { // 스택의 top에 해당하는 값보다 오른쪽에 있고 크면 오큰수!
//				while (!stack.isEmpty() && array[stack.peek()] < array[i]) { // 스택에 남아있는 값의 오큰수 찾기
//					array[stack.pop()] = array[i];
//				}
//				stack.push(i);
//			} else {
//				stack.push(i); // 오큰수가 아니면 스택에 넣음
//			}
		}
		
		// 스택에 남아있으면 해당 값의 오큰 수가 없음. 
		while (!stack.isEmpty()) {
			array[stack.pop()] = -1;
		}
		
		for (int num : array) {
			bw.write(String.valueOf(num) + " ");
		}
		bw.flush();
		bw.close();	
	}
}
