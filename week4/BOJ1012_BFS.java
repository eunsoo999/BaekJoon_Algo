package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1012_BFS {
	private static int[][] field;
	private static boolean[][] visited;
	private static int count;
	private static int T, M, N, K;
	private static int dx[] = {-1, 1, 0, 0};
	private static int dy[] = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < T; test++) {
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]); 
			N = Integer.parseInt(input[1]); 
			K = Integer.parseInt(input[2]); 
			
			// 배열초기화
			field = new int[M][N];
			visited = new boolean[M][N];
			
			//배추심기
			for (int i = 0; i < K; i++) {
				String[] location_K = br.readLine().split(" ");
				int x = Integer.parseInt(location_K[0]);
				int y = Integer.parseInt(location_K[1]);
				
				field[x][y] = 1;
			}
			
			count = 0; // 벌레 수
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (field[i][j] == 1 && !visited[i][j]) {
						BFS(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	// 너비탐색
	public static void BFS(int x, int y) {
		Queue<Location> q = new LinkedList<>();
		Location d = new Location(x, y);
		q.add(d);
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Location now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int a = now.x + dx[i];
				int b = now.y + dy[i];
				
				if (a < 0 || b < 0 || a >= M || b >= N) {
					continue; 
				}
				
				if (!visited[a][b] && field[a][b] == 1) {
					// 방문하지 않았고 해당 위치에 배추가 있으면
					q.add(new Location(a, b));
					visited[a][b] = true;
				}

			}	
			
		}
		
	}
}

class Location {
	int x;
	int y;
	
	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
