package week5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 사람 수 입력
		int person = sc.nextInt();

		int[] line = new int[person];
	
		
		// 각 사람 당 인출 시간 입력
		for (int i = 0; i < person; i++) {
			line[i] = sc.nextInt();
		}
		
		// 인출 시간이 빠른 순으로 정렬 (오름차순)
		Arrays.sort(line);
		
		int time = 0; // 총 걸리는 시간
		for (int i = 1; i < person; i++) {
			for (int j = 0; j <= i; j++) {
				time += line[j];
			}
		}
		System.out.println(time);
	}
}
