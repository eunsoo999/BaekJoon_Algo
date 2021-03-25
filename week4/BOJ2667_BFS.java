package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ2667_BFS {
	private static int[][] house;
	private static boolean[][] visited;
	private static int N;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int count;
	private static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		house = new int[N][N];
		visited = new boolean[N][N];
		pq = new PriorityQueue<Integer>();
		
		// 집 위치 입력
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(input[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && house[i][j] == 1) {
					count = 0;
					BFS(new Pos(i, j));
					pq.add(count);
				}
			}
		}
		
		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			int n = pq.remove();
			System.out.println(n);
		}
	}
	
	public static void BFS(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		visited[p.x][p.y] = true;
		count++;
		
		while (!q.isEmpty()) {
			Pos now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = now.x + dx[i];
				int y = now.y + dy[i];
				
				if (x < 0 || y < 0 || x >= N || y >= N) {
					continue; // 범위가 적합한지 검사
				}
				if (!visited[x][y] && house[x][y] == 1) {
					count++;
					q.add(new Pos(x, y));
					visited[x][y] = true;
				}
			}
		}
	}
}

class Pos {
	int x;
	int y;
	
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
*/
