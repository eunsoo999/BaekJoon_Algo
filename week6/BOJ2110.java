package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2110 {
	public static int N;
	public static int C;
	public static int[] distance;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		distance = new int[N];
		for (int i = 0; i < N; i++) {
			distance[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(distance);
		
		int min = 1; // 최소 간격
		int max = distance[N-1] - distance[0]; // 최대간격
		
		int result = 0;
		int last_set = 0;
		
		while (min <= max) {
			last_set = distance[0];
			int count = 1; // 공유기 개수 1 : 첫번째 집 설치
			int mid = (max + min) / 2;
			
			for (int i = 1; i < distance.length; i++) {
				if (distance[i] - last_set >= mid) {
					last_set = distance[i];
					count++;
				}
			}
			
			if (count >= C) {
				result = Math.max(result, mid);
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		System.out.println(result);
	}
}
