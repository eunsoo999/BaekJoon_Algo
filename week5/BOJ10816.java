package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ10816 {
	public static int[] count;
	public static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int[] card = new int[N];
		
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
		
		Arrays.sort(card);
		
		count = new int[M]; // 카운트
		for (int i = 0; i < M; i++) {
			find(card, 0, card.length - 1, M_card[i], i);
		}
		for (int i = 0; i < M; i++) {
			bw.write(String.valueOf(count[i]) + " ");
		}
		bw.flush();
		bw.close();
	}
	
	public static void find_adj_left(int[] card, int start, int value, int index) {
		if (start >= 0 && card[start] == value) {
			count[index]++;
			find_adj_left(card, start - 1, value, index);
		}
	}
	
	public static void find_adj_right(int[] card, int start, int value, int index) {
		if (start < N && card[start] == value) {
			count[index]++;
			find_adj_right(card, start + 1, value, index);
		}
	}
	
	public static void find(int[] card, int start, int end, int value, int index) {
		if (start > end) return;
		int mid = (start + end) / 2;
		
		if (card[mid] == value) {
			count[index]++;
			find_adj_left(card, mid - 1, value, index);
			find_adj_right(card, mid + 1, value, index);
		} else if (card[mid] > value) {
			find(card, start, mid - 1, value, index);
		} else {
			find(card, mid + 1, end, value, index);
		}
	}
}
