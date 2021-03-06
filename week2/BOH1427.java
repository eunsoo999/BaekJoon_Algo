package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOH1427 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String num = br.readLine();
		
		// 방법 1. Arrays.sort, toCharArray()이용
		char[] arr = num.toCharArray();
		Arrays.sort(arr);
		
		for (int i = arr.length - 1; i >= 0; i--) {
			bw.write(arr[i]);
		}
		
//		// 방법 2. 카운팅정렬
//		int[] arr2 = new int[10]; //값이 최대 1,000,000,000이므로 (자리수 10개)
//		
//		for (int i = 0; i < num.length(); i++) {
//			arr2[num.charAt(i) - '0']++;
//		}
//		
//		for (int i = 9; i >= 0; i--) {
//			while (arr2[i]-- > 0) {
//				bw.write(String.valueOf(i));
//			}
//		}
		
		bw.flush();
		bw.close();
	}
}
