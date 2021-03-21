package week3;

import java.util.Scanner;

public class DFS_adjMatrix {
	private static int nV; // 정점의 개수
	private static int[][] graph; //그래프
	private static boolean[] visited; // 정점 방문 여부 체크 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		nV = sc.nextInt(); // 정점의 수
		int e = sc.nextInt(); // 간선의 수
		
		// 그래프, 배열 초기화
		initGraph(nV);
		
		for (int i = 0; i < e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			put(x, y);
		}
		printMat();
		
		System.out.print("1부터 탐색 ");
		DFS(1);
		System.out.println();
		
		clearVisited();
		System.out.print("2부터 탐색 ");
		DFS(2);
		System.out.println();
		
		clearVisited();
		System.out.print("3부터 탐색 ");
		DFS(3);
		System.out.println();
	}
	
	public static void DFS(int v) {
		visited[v] = true; // 방문했으니 true로 변경
		
		System.out.print(v + " ");
		
		for (int i = 1; i <= nV; i++) {
			if (graph[v][i] == 1 && visited[i] == false) { // 연걸되어있는 정점이 있고, 방문하지않은 정점일 경우
				DFS(i); // DFS 재귀호출
			}
		}
	}
	
	public static void printMat() {
		for(int i = 0; i < graph.length; i++) {
            for(int j=0; j < graph[i].length; j++) {
                System.out.print(" " + graph[i][j]);
            }
            System.out.println();
        }
	}
	
	public static void initGraph(int v) {
		graph = new int[v+1][v+1];
		visited = new boolean[v+1];
		
		for (int i = 0; i < v; i++) {
			visited[i] = false;
		}
	}
	
	public static void put(int x, int y) {
		graph[x][y] = graph[y][x] = 1;
	}
	
	public static void clearVisited() {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}
}
