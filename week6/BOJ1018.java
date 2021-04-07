package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1018 {
	public static String[][] WB = { {"W", "B", "W", "B", "W", "B", "W", "B" },
									{"B", "W", "B", "W", "B", "W", "B", "W" },
									{"W", "B", "W", "B", "W", "B", "W", "B" },
									{"B", "W", "B", "W", "B", "W", "B", "W" },
									{"W", "B", "W", "B", "W", "B", "W", "B" },
									{"B", "W", "B", "W", "B", "W", "B", "W" },
									{"W", "B", "W", "B", "W", "B", "W", "B" },
									{"B", "W", "B", "W", "B", "W", "B", "W" } };
	public static String[][] BW = { {"B", "W", "B", "W", "B", "W", "B", "W" },
									{"W", "B", "W", "B", "W", "B", "W", "B" },
									{"B", "W", "B", "W", "B", "W", "B", "W" },
									{"W", "B", "W", "B", "W", "B", "W", "B" },
									{"B", "W", "B", "W", "B", "W", "B", "W" },
									{"W", "B", "W", "B", "W", "B", "W", "B" },
									{"B", "W", "B", "W", "B", "W", "B", "W" }, 
									{"W", "B", "W", "B", "W", "B", "W", "B" } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		// 보드 입력
		String[][] board = new String[N][M];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = input[j];
			}
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int BW_count = 0;
				int WB_count = 0;
				for (int a = i; a < i + 8; a++) {
					for (int b = j; b < j + 8; b++) {
						if (!board[a][b].equals(BW[a - i][b - j])) {
							BW_count++;
						}
						if (!board[a][b].equals(WB[a - i][b - j])) {
							WB_count++;
						}
					}
				}
				int min = Math.min(BW_count, WB_count);
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
	}
}
