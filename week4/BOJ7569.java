package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
	private static int M, N, H;
	private static int[][][] boxs;
	private static int[] dx = {-1, 1, 0, 0, 0, 0};
	private static int[] dy = {0, 0, -1, 1, 0, 0};
	private static int[] dz = {0, 0, 0, 0, -1, 1};
	private static int day;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] box_size = br.readLine().split(" ");
		M = Integer.parseInt(box_size[0]); //M 가로길이
		N = Integer.parseInt(box_size[1]); //N 세로길이
		H = Integer.parseInt(box_size[2]); //H 높이
		
		// 객체 변수 초기화
		boxs = new int[N][M][H];
		
		// 토마토 저장
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					boxs[j][k][i] = Integer.parseInt(st.nextToken());
				}
			}
		}
	
		System.out.println(BFS());
	}
	
	public static int BFS() {
		Queue<Locate> q = new LinkedList<>();
		
		// 익은 토마토를 큐에 삽입
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (boxs[j][k][i] == 1) {
						q.add(new Locate(j, k, i, 0)); // x, y, z, 날짜
					}
				}
			}
		}
		
		while (!q.isEmpty()) {
			Locate now = q.poll();
			day = now.day;
			
			for (int i = 0; i < 6; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nz = now.z + dz[i];
				
				// 상자 범위 확인
				if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) {
					continue;
				}
				
				if (boxs[nx][ny][nz] == 0) {
					boxs[nx][ny][nz] = 1;
					q.add(new Locate(nx, ny, nz, now.day + 1));
				}
			}			
		}
		
		// 안익은 토마토 유무 확인
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (boxs[j][k][i] == 0) {
						return -1;
					}
				}
			}
		}
		return day;
	}
}

class Locate {
	int x;
	int y;
	int z;
	int day;
	
	Locate (int x, int y, int z, int day) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
	}
}

