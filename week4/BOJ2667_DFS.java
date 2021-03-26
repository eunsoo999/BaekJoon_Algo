package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ2667_DFS {
	private static int map[][];
	private static boolean visited[][];
	private static ArrayList<Integer> list;
	private static int count;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();
		
		// map에 집 위치 설정
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					count = 0;
					DFS(i, j);
					list.add(count);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static void DFS(int x, int y) {
		visited[x][y] = true;
		count++;
		
		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
	
			if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) {
				continue;
			}
			
			if (map[next_x][next_y] == 1 && !visited[next_x][next_y]) {
				// 방문하지 않은 집인 경우
				DFS(next_x, next_y);
			}
		}
	}
}
