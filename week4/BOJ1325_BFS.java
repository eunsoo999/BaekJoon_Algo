package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325_BFS {

	private static int N, M;
	private static ArrayList<Integer> adj[];
	private static boolean visited[];
	private static int countArr[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N + 1];
		countArr = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b); 
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			BFS(i);
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, countArr[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (countArr[i] == max) {
				sb.append(i + " ");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	
	
	public static void BFS(int start) {
		if (visited[start]) return;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for (int value : adj[num]) {
				if (!visited[value]) {
					queue.add(value);
					visited[value] = true;
					countArr[value]++; // 현재 노드에 도달할 수 있는 노드 수를 증가
				}
			}
		}
	}
}
