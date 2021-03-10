package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2231 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int number = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i = 0; i < number; i++) {
			int num = i;
			int sum = 0;
			
			while (num != 0) {
				sum += num % 10; //각 자리수를 더함
				num /= 10;  // 더한 자리수 제거
			}
			if (sum + i == number) {
				result = i;
				break;
			}
		}
		bw.write(String.valueOf(result) + "\n");
		
		bw.flush();
		bw.close();
	}
}
