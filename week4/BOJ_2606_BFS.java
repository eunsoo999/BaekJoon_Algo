package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2606_BFS {
	private static ArrayList<Integer> graph[];
	private static boolean visited[];
	private static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int computer = Integer.valueOf(br.readLine()); // 컴퓨터 수
		int edge = Integer.valueOf(br.readLine()); // 연결 수
		
		graph = new ArrayList[computer + 1];
		
		for (int i = 0; i <= computer; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		visited = new boolean[computer + 1];
		
		for (int i = 0; i <= computer; i++) {
			visited[i] = false;
		}
		
		for (int i = 0; i < edge; i++) {
			String[] con = br.readLine().split(" ");
			
			graph[Integer.valueOf(con[0])].add(Integer.valueOf(con[1]));
			graph[Integer.valueOf(con[1])].add(Integer.valueOf(con[0]));
		}
		count = 0;
		BFS(1);
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) { // 큐가 비어있으면 종료
			int num = queue.remove();
			
			for (int value : graph[num]) {
				if (!visited[value]) {
					queue.add(value);
					visited[value] = true;
					count++;
				}
			}
		}
	}
}
