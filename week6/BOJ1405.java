package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1405 {
	public static boolean[][] map;
	public static double[] dir;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static double result = 0;
	public static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		dir = new double[4];
		for (int i = 0; i < 4; i++) {
			dir[i] = Integer.parseInt(input[i + 1]) * 0.01; //퍼센트 저장
		}
		
		map = new boolean[29][29];
		
		DFS(14, 14, 0, 1);
		
		System.out.println(result);
	}
	
	// 단순한 경로 개수 세기
	public static void DFS(int x, int y, int count, double total) {
		if (count == N)  {	
			result += total;
			return;
		}
		map[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (!map[nx][ny]) {
				map[nx][ny] = true;
				DFS(nx, ny, count + 1, total * dir[i]);
				map[nx][ny] = false;
			}
		}
	}
}
