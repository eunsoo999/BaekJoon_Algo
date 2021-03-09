package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
	private static ArrayList<Integer> graph[]; // 인접리스트 방식
	private static boolean[] check; //정점 방문 여부 체크
	
	// 깊이우선탐색
	public static void dfs(int start) {
		if (check[start]) return; // 이미 방문했다면 탐색 x
		check[start] = true;
		System.out.print(start + " ");
		for (int y : graph[start]) {
			if (!check[y]) {
				dfs(y); // 해당 정점을 방문한 뒤 그 정점에서 다시 dfs수행
			}
		}
	}
	
	// 너비우선탐색
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start); //bfs 탐색을 시작할 정점을 큐에 추가
		check[start] = true;
		
		while (!queue.isEmpty()) { //큐가 비어있으면 탐색 종료
			int x = queue.remove(); // bfs탐색할 현재 정점
			System.out.print(x + " ");
			for (int y : graph[x]) { // 정점에 연결된 모든 정점 확인
				if (!check[y]) {
					queue.add(y); // 정점 방문
					check[y] = true; //정점 방문
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt(); // 정점
		int e = sc.nextInt(); // 간선
		int start = sc.nextInt(); // 시작번호
		
		graph = new ArrayList[v+1];
		
		for (int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < e; i++) {
			int temp1 = sc.nextInt();
			int temp2 = sc.nextInt();
			
			graph[temp1].add(temp2);
			graph[temp2].add(temp1);
		}
		
		for (int i = 1; i <= v; i++) {
			Collections.sort(graph[i]);
		}
		check = new boolean[v+1];
		dfs(start);
		System.out.println();
		check = new boolean[v+1];
        bfs(start);
	}

}