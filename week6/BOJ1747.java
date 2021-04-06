package week6;

import java.util.Scanner;

public class BOJ1747 {

	public static boolean[] prime = new boolean[2000000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//0,1은 소수가 아님.
		for (int i = 2; i < prime.length; i++) {
			prime[i] = true;
		}
		
		//소수 아닌 수 판별: 제곱근까지 해당하는 범위안의 소수의 배수를 제외하면 됨. (에라토스테네스의 체)
		for (int i = 2; i * i < prime.length; i++) {
			if (prime[i]) {
				for (int j = i * 2; j < prime.length; j += i) {
					prime[j] = false;
				}
			}
		}
		
		int N = sc.nextInt();
		
		int number = N;
		while(true) {
			if (prime[number]) {
				if (palindrome(number)) {
					System.out.println(number);
					break;
				}
			}
			number++;
		}
	}
	
	public static boolean palindrome(int num) {
		String n = String.valueOf(num);
	
		for (int i = 0; i < n.length() / 2; i++) {
			if (n.charAt(i) != n.charAt(n.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}