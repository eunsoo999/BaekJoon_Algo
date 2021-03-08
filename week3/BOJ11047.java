package week3;

import java.util.Scanner;

public class BOJ11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] array = new int[N];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		
		for (int i = N - 1; i >= 0; i--) {
			if (K >= array[i]) {
				count += K / array[i];
				K %= array[i];
			}
		}
		System.out.println(count);
	}

}
// 단순하게 최소 동전을 사용하여 값을 만드는것이므로 큰 동전부터 사용가능한 개수를 센다.