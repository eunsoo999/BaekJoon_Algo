package week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {
	public static int N;
	public static boolean[][] visited;
	public static char[][] board;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//입력
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = input.charAt(j);
			}
		}
		
		//적록색약이 아닌 사람이 보는 구역
		visited = new boolean[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					BFS(false, i, j);
					count++;
				}
			}
		}
		bw.write(String.valueOf(count) + " ");
		
		//적록색약인 사람이 보는 구역
		visited = new boolean[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					BFS(true, i, j);
					count++;
				}
			}
		}
		bw.write(String.valueOf(count) + " ");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void BFS(boolean rgb, int x, int y) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(x, y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Pos now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int next_x = now.x + dx[i];
				int next_y = now.y + dy[i];
				
				if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) {
					continue;
				}
				
				char nowValue = board[now.x][now.y];
				char nextValue = board[next_x][next_y];
				
				if (!rgb) { 
					//적록색약이 아닌 사람
					if (!visited[next_x][next_y] && nextValue == nowValue) {
						q.add(new Pos(next_x, next_y));
						visited[next_x][next_y] = true;
					} 
				} else {
					//적록색약인 사람
					if (nowValue == 'B') {
						if (!visited[next_x][next_y] && nextValue == nowValue) {
							q.add(new Pos(next_x, next_y));
							visited[next_x][next_y] = true;
						} 
					} else { //청록, 레드 색상은 동일하게 취급
						if (!visited[next_x][next_y] && (nextValue == 'R' || nextValue == 'G')) {
							q.add(new Pos(next_x, next_y));
							visited[next_x][next_y] = true;
						} 
					}
				}
			}
		}
	}
}

class Pos {
	int x;
	int y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}