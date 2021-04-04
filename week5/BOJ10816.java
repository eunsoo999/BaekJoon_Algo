package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ10816 {
	public static int[] count;
	public static int N;
	public static int[] card;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		card = new int[N];
		
		// 가지고 있는 카드 입력
		String[] card_input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(card_input[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] M_card = new int[M];
		
		// 주어진 카드 입력
		String[] card2_input = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			M_card[i] = Integer.parseInt(card2_input[i]);
		}
		
		Arrays.sort(card); // 정렬
		
		count = new int[M]; // 카운트
		
		for (int i = 0; i < M; i++) {
			int left = find_left(M_card[i]);
			int right = find_right(M_card[i]);
			count[i] = right - left;

		}
		for (int i = 0; i < M; i++) {
			bw.write(String.valueOf(count[i]) + " ");
		}
		bw.flush();
		bw.close();
	}
	
	public static int find_left(int value) {
		int start = 0;
		int end = card.length;
		
		while (start < end) {
			int mid = (start + end) / 2;
			if (card[mid] >= value) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
	
	public static int find_right(int value) {
		int start = 0;
		int end = card.length;
		
		while (start < end) {
			if (start == end) return -1;
			int mid = (start + end) / 2;
			
			if (card[mid] > value) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}