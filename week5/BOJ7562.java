package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7562 {
	public static int[] dx = { -2, -1, -2, -1, 1, 2, 1, 2 };
	public static int[] dy = { -1, -2, 1, 2, 2, 1, -2, -1 };
	public static boolean[][] visited;
	public static int[][] count;
	public static int tc, n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		tc = Integer.parseInt(br.readLine()); //tc개수
		
		for (int i = 0; i < tc; i++) {
			n = Integer.parseInt(br.readLine());

			visited = new boolean[n][n];
			count = new int[n][n];

			String[] pos_input = br.readLine().split(" ");
			int start_x = Integer.parseInt(pos_input[0]);
			int start_y = Integer.parseInt(pos_input[1]);

			String[] de_input = br.readLine().split(" ");
			int end_x = Integer.parseInt(de_input[0]);
			int end_y = Integer.parseInt(de_input[1]);

			BFS(new Pos(start_x, start_y), new Pos(end_x, end_y));

			bw.write(String.valueOf(count[end_x][end_y]) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS(Pos start, Pos end) {
		Queue<Pos> q = new LinkedList<>();
		q.add(start);
		visited[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Pos now = q.poll();

			if (now.x == end.x && now.y == end.y) {
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					count[nx][ny] = count[now.x][now.y] + 1;
					q.add(new Pos(nx, ny));
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
