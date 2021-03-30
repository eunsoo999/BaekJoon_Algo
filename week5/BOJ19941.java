package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ19941 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input_num = br.readLine().split(" ");
		int N = Integer.parseInt(input_num[0]); // 라인
		int K = Integer.parseInt(input_num[1]); // 접근 가능 거리

		String[] line = br.readLine().split("");

		boolean[] visited = new boolean[N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			if (line[i].equals("P")) { // 로봇 인 경우
				visited[i] = true;
				for (int j = K * -1; j <= K; j++) {
					if ((i + j) < 0 || (i + j) >= N) {
						continue;
					}
					if (line[(i + j)].equals("H") && !visited[(i + j)]) {
						// 방문안했고, 접근가능한 부품일 경우
						visited[(i + j)] = true;
						count++;
						break;
					}
				}
			}
		}
		System.out.println(count);
	}
}