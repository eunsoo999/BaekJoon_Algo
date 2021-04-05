package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1654 {
		private static int K;
		private static int N;
		private static int[] lan;
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// K, N 입력
		String[] input = br.readLine().split(" ");
		K = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		
		// 랜선 입력
		lan = new int[K];
		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
		}
		
		// 랜선 오름차순 정렬
		Arrays.sort(lan);
		
		long lower = 1; // 랜선의 길이는 자연수이기때문
		long upper = lan[K-1];
		long mid = 0;
		while (lower <= upper) {
			mid = (lower + upper) / 2;
			int sum = 0; // 자른 랜선 합
			
			for (int i = 0; i < K; i++) {
				sum += lan[i] / mid;
			}
			
			if (sum >= N) {
				lower = mid + 1;
			} else {
				upper = mid - 1;
			}		
		}
		System.out.println(upper);	
	}
}
