package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11729_하노이탑 {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void hanoiTop(int n, int start, int mid, int to) {
		if (n == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		
		//n-1을 b로 이동
		hanoiTop(n - 1, start, to, mid);
		
		//1개(n번)을 c로 이동
		sb.append(start + " " + to + "\n");
		
		//n-1을 b에서 c로 이동
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
