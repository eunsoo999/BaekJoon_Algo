package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1012 {
	private static int[][] field;
	private static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < T; test++) {
			String[] input = br.readLine().split(" ");
			int M = Integer.parseInt(input[0]); //밭 가로길이
			int N = Integer.parseInt(input[1]); //밭 세로길이
			int K = Integer.parseInt(input[2]); //배추 개수
			
			// 배열초기화
			field = new int[M][N];
			
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
					if (field[i][j] == 1) {
						DFS(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void DFS(int x, int y) {
		if (field[x][y] == 0) return;
		
		field[x][y] = 0;
		
		if (x + 1 < field.length && field[x + 1][y] == 1) {
			DFS(x+1, y);
		}
		
		if (x - 1 >= 0 && field[x - 1][y] == 1) {
			DFS(x-1, y);
		}
		
		if (y + 1 < field[0].length && field[x][y + 1] == 1) {
			DFS(x, y+1);
		}
		
		if (y - 1 >= 0 && field[x][y - 1] == 1) {
			DFS(x, y-1);
		}
	}

}
