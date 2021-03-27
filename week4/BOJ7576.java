package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
	private static int M, N;
	private static int[][] box;
	private static int day = 0;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] box_size = br.readLine().split(" ");
		M = Integer.parseInt(box_size[0]); //M 가로길이
		N = Integer.parseInt(box_size[1]); //N 세로길이
		
		box = new int[N][M];
		
		// 토마토 정보 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 결과 출력
		System.out.println(BFS());
	}
	
	public static int BFS() {
		Queue<Box_loc> q = new LinkedList<>();
		
		// 익은 토마토들을 큐에 먼저 삽입
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					q.add(new Box_loc(i, j, 0));
				}
			}
		}
		
		while (!q.isEmpty()) {
			Box_loc now = q.poll();
			day = now.day; // 날짜 세기
			
			for (int i = 0; i < 4; i++) {
				// 인접 위치 토마토 확인
				int next_x = now.x + dx[i];
				int next_y = now.y + dy[i];
			
				// 범위 확인
				if (next_x < 0 || next_y <0 || next_x >= N || next_y >= M) {
					continue;
				}
				
				// 익은 토마토와 인접한 토마토가 안익었을때
				if (box[next_x][next_y] == 0) {
					box[next_x][next_y] = 1; // 토마토를 익힌다.
					q.add(new Box_loc(next_x, next_y, now.day + 1)); // 익었으니 다음 날 주변을 익히도록 익은 날짜와 함께 q에 add. 
				}
			}
		}
		
		// 인접한 토마토를 익힐 수 있는 날짜가 다 지났는데도 안익은 토마토가 존재하는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					return -1;
				}
			}
		}
		return day;
	}
}
class Box_loc {
	int x;
	int y;
	int day; // 익은 날짜(일)
	
	public Box_loc(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}
