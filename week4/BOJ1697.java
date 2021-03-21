package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 숨바꼭질 https://www.acmicpc.net/problem/1697
 * 문제유형 : BFS
 * 
 */

public class BOJ1697 {
	private static int MAX = 100001;
	private static int n, k;
	private static int[] data = new int[MAX]; // 최대 100,000

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		
		n = Integer.valueOf(input[0]);
		k = Integer.valueOf(input[1]);
		
		BFS(n);
		
		bw.write(String.valueOf(data[k]));
		bw.flush();
		bw.close();
	}
	
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		while (!queue.isEmpty()) { // 큐가 비어있으면 종료
			int num = queue.poll();
			
			if (num == k) { // 술래잡기 성공 시 카운트 출력
				return;
			}
			
			int next = num - 1;
			if (0 <= next && next < MAX && data[next] == 0) {
				data[next] = data[num] + 1;
				queue.add(next);
			}
			next = num + 1;
			if (0 <= next && next < MAX && data[next] == 0) {
				data[next] = data[num] + 1;
				queue.add(next);
			}
			
			next = num * 2;
			if (0 <= next && next < MAX && data[next] == 0) {
				data[next] = data[num] + 1;
				queue.add(next);
			}
		}
	}

}
