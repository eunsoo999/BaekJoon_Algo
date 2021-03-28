package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2206 {
	private static int N, M;
	private static int[][] map;
	private static boolean[][][] visited;
	private static int[][] data;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] size = br.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		
		map = new int[N][M];
		// visited[0][][] : 벽 부시고 온 경로 / visited[1][][] : 벽 안부시고 온 경로
		visited = new boolean[N][M][2];
		data = new int[N][M];
		
		// 맵 입력
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		// BFS 탐색
		System.out.println(BFS(0, 0));
	}
	
	public static int BFS(int x, int y) {
		Queue<Vertex> q = new LinkedList<>();
		q.add(new Vertex(x, y, 1));
		visited[x][y][1] = true;
		visited[x][y][1] = true;
		data[x][y]++;
		
		while (!q.isEmpty()) {
			Vertex now = q.poll();
			
			// 종점에 도착 시 거리 return
			if (now.x == N - 1 && now.y == M - 1) {
				return data[now.x][now.y]; 
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				
				if (map[nx][ny] == 0 && !visited[nx][ny][now.chance]) {
					// 벽이 없고 방문하지않았다면
					q.add(new Vertex(nx, ny, now.chance));
					visited[nx][ny][now.chance] = true;
					data[nx][ny] = data[now.x][now.y] + 1;
				} else if (map[nx][ny] == 1 && now.chance == 1 && !visited[nx][ny][now.chance]) {
					 // 벽이고 벽을 부술 기회가 남았고 방문하지않았다면
					q.add(new Vertex(nx, ny, now.chance - 1));
					visited[nx][ny][now.chance] = true;
					data[nx][ny] = data[now.x][now.y] + 1;
				}
			}
		}
		return -1;	
	}
}

class Vertex {
	int x;
	int y;
	int chance; // 벽을 부술 기회 
	 
	public Vertex (int x, int y, int chance) {
		this.x = x;
		this.y = y;
		this.chance = chance;
	}
}
