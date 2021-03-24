package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1325_DFS {
	private static ArrayList<Integer>[] adj;
	private static int N, M;
	private static boolean[] visited;
	private static int count;
	private static int[] countArray; // 각 인덱스번호의 컴퓨터 해킹시 해킹가능 컴퓨터 수
	

	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N + 1]; 
		
		// 인접리스트 객체 변수 초기화
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		countArray = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			count = 0;
			DFS(i);
			countArray[i] = count;
		}

		// 가장 많은 해킹을 한 수
		int max_value = 0;
		for (int i = 1; i <= N; i++) {
			max_value = Math.max(max_value, countArray[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (max_value == countArray[i]) {
				sb.append(i + " ");
			}
		}
		 System.out.println(sb.toString());
	}
	
	public static void DFS(int start) {
		if (visited[start]) return;
		visited[start] = true;
		for (int x : adj[start]) {
			if (!visited[x]) {
				count++;
				DFS(x);
			}
		}	
	}
}
