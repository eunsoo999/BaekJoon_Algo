package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1012_2 {

	private static int T, M, N, K;
	private static int[][] field;
	public static boolean[][] visited;
	private static int count;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < T; test++) {
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]); //밭 가로길이
			N = Integer.parseInt(input[1]); //밭 세로길이
			K = Integer.parseInt(input[2]); //배추 개수
			
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
			
			count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (field[i][j] == 1 && !visited[i][j]) {
						DFS(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= M || ny < 0 || ny >= N) { // 값이 범위에 맞는지 확인
				continue;
			}
			if(field[nx][ny] == 1 && !visited[nx][ny]) {
				DFS(nx, ny);
			}
		}
	}
}