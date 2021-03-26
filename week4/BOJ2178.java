package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] data;
	private static int N, M;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] loc = br.readLine().split(" ");
		N = Integer.parseInt(loc[0]);
		M = Integer.parseInt(loc[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		data = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		BFS(0,0);
		
		System.out.println(data[N-1][M-1]);
	}
	
	public static void BFS(int x, int y) {
		Queue<loc> q = new LinkedList<>();
		q.add(new loc(x, y));
		visited[x][y] = true;
		data[x][y]++;
		
		while (!q.isEmpty()) {
			loc now = q.poll();
			
			if (now.x == N - 1 && now.y == M - 1) {
				// N,M에 도착했으면 종료
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int next_x = now.x + dx[i];
				int next_y = now.y + dy[i];
				
				if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) {
					continue;
				}
				
				if (map[next_x][next_y] == 1 && !visited[next_x][next_y]) {
					data[next_x][next_y] = data[now.x][now.y] + 1;
					q.add(new loc(next_x, next_y));
					visited[next_x][next_y] = true;
				}
			}
		}
	}
}

class loc {
	int x;
	int y;
	
	public loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
