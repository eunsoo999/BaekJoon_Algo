package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;

		int conf = Integer.parseInt(br.readLine());
		int[][] list = new int[conf][2];

		// 회의 시간 입력
		for (int i = 0; i < conf; i++) {
			String[] input = br.readLine().split(" ");
			list[i][0] = Integer.parseInt(input[0]);
			list[i][1] = Integer.parseInt(input[1]);
		}
		
		// 종료시간이 빠른 것부터 정렬
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료시간이 같다면 시작시간이 빠른 것 선택
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0]; 
				}
				return o1[1] - o2[1]; // 양수면 자리바꿈
			}
		});

		int last_end = 0;
		for (int i = 0; i < conf; i++) {
			if (last_end <= list[i][0]) {
				// 마지막 시간뒤에 회의가 있으면 시간표 추가
				last_end = list[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
