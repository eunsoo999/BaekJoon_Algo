package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_2606_DFS {
	private static ArrayList<Integer> graph[];
	private static boolean visited[];
	private static int count;
	
	public static void main(String[] args) throws Exception  {
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
		DFS(1);
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void DFS(int start) {
		if (visited[start]) return;
		
		visited[start] = true;
		
		
		for (int i = 0; i < graph[start].size(); i++) {
			if (!visited[graph[start].get(i)]) { // 방문하지않은 정점이라면
				count++;
				DFS(graph[start].get(i));
			}
		}
	}
}
