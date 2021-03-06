package week2;

import java.util.Scanner;

public class BOJ1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int value = n;
		int count = 0;
		
		do {
			value = ((value % 10) * 10) + (((value % 10) + (value / 10)) % 10);
			count++;
		} while (n != value);
		
		System.out.println(count);
	}
}
/*
 * 새로운 값의 십의 자리 숫자 : (n % 10) 
 * 새로운 값의 일의 자리 숫자 : N의 십의자리 숫자 + N의 일의자리 숫자 % 10 = ((n / 10) + (n % 10)) % 10
 * 새로운 값 : ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10)
 */
