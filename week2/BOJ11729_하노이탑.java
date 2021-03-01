package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11729_�ϳ���ž {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void hanoiTop(int n, int start, int mid, int to) {
		if (n == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		
		//n-1�� b�� �̵�
		hanoiTop(n - 1, start, to, mid);
		
		//1��(n��)�� c�� �̵�
		sb.append(start + " " + to + "\n");
		
		//n-1�� b���� c�� �̵�
		hanoiTop(n - 1, mid, start, to);
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int) (Math.pow(2, n) - 1) + "\n");
		hanoiTop(n, 1, 2, 3);
		System.out.println(sb);
	}
}
