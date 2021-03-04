package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10989_Countingsort {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		
		for (int i = 0; i < 10001; i++) {
			count[i] = 0;
		}
		
		int input;
		for (int i = 0; i < n; i++) {
			input = Integer.parseInt(br.readLine());
			count[input]++; 
		}
		int cnt = 0;
		for (int i = 1; i <= 10000; i++) {
			if (count[i] > 0) {
				for (int j = 0; j < count[i]; j++) {
					bw.write(i + "\n");
					cnt++; //출력한 개수
				}
			}
			if (cnt == n) {
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}
