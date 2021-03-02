package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ2751_수정렬하기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		for (int num : array) {
			bw.write(String.valueOf(num));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
