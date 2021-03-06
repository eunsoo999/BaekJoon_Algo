package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2108 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[8001]; // 입력값 범위 : -4000 ~ 4000
		int sum = 0; // 총 합
		int max = Integer.MIN_VALUE; // 최대값
		int min = Integer.MAX_VALUE; // 최소값
		int mid = 10000;
		int freq = 10000;

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			//총 합 얻기
			sum += input;
			arr[input + 4000]++;

			//최대값 찾기
			if (max < input) {
				max = input;
			}

			//최소값 찾기
			if (min > input) {
				min = input;
			}
		}

		int count = 0; 
		int freq_max = 0; // 최빈값의 최대값
		// 이전의 동일한 최빈값이 1번만 등장했을경우 true, 아닐경우 false
		boolean flag = false;
		for (int i = min + 4000; i <= max + 4000; i++) { //-5을 입력한 경우 3995에 들어가있음.
			if (arr[i] > 0) { // 해당 값이 입력되어진 경우
				//중앙값 찾기
				if (count <= n / 2) { 
					count += arr[i]; // 해당 값의 빈도수를 count에 합산
					mid = i - 4000;  
				}

				// 최빈값 찾기
				if (freq_max < arr[i]) {
					freq_max = arr[i];
					freq = i - 4000;
					flag = true; // 첫번쨰 최빈값을 찾았으니 true 로 변경, 이후 중복된 빈도수를 갖는 값을 만나면 그 값이 두번째로 작은 값이므로 그 값이 출력되어야함.
				}
				// 최대 최빈값과 빈도수가 같고, 앞에서 최대 최대값을 찾은 경우.
				else if (freq_max == arr[i] && flag == true) {
					freq = i - 4000;
					flag = false;
				}
			}
		}
		bw.write(String.format("%.0f", (double) sum / (double) n) + "\n");
		bw.write(String.valueOf(mid) + "\n"); // 중앙값
		bw.write(String.valueOf(freq) + "\n"); // 최빈값
		bw.write(String.valueOf(max - min) + "\n"); // 범위
		
		bw.flush();
		bw.close();
	}
}
