package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ13305 {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 도시 개수
		long[] oil = new long[N]; // 각 도시의 리터당 가격을 저장할 배열 
		int[] distance = new int[N - 1]; 
		
		// 거리 입력
		String[] input_line = br.readLine().split(" ");
		for (int i = 0; i < input_line.length; i++) {
			distance[i] = Integer.parseInt(input_line[i]);
		}
		
		// 리터당 가격 입력
		String[] input_oil = br.readLine().split(" ");
		for (int i = 0; i < input_oil.length; i++) {
			oil[i] = Integer.parseInt(input_oil[i]);
		}
		
		long sum = 0; // 총 비용
		long min_price = oil[0]; // 이전까지의 주유소 최소 비용
		for(int i = 0; i < N - 1; i++) {
			if (oil[i] < min_price) { // 이전까지의 주유 최소비용보다 싼 주유소가 있는 경우
				min_price = oil[i]; // 최소비용으로 갱신
			}
			sum += min_price * distance[i];
		}
		System.out.println(sum);
	}
}
