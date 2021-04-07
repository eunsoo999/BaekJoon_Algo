package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1759 {
	public static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int L = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		
		// 문자
		String[] letter = new String[C];
		input = br.readLine().split(" ");
		for (int i = 0; i < C; i++) {
			letter[i] = input[i];
		}
		
		Arrays.sort(letter); // 오름차순 정렬
		String[] str = new String[L];
		pick(letter, str, L, L, 0);
		
		System.out.print(sb.toString());
	}
	// 뽑기
	public static void pick(String[] letter, String[] bucket, int bucketSize, int k, int index) {
		if (k == 0) { //c개의 문자를 조합했으므로, 자음모음개수 확인
			int con = 0; //자음
			int vo = 0; //모음

			for (int i = 0; i < bucketSize; i++) {
				if (bucket[i].equals("a")  || bucket[i].equals("e") 
						|| bucket[i].equals("i")  || bucket[i].equals("o") || bucket[i].equals("u")) {
					vo++; //모음이면 모음 개수++
				} else {
					con++; //자음이면 자음 개수++
				}
			}
			
			if (con >= 2 && vo >= 1) {
				for (int i = 0; i < bucketSize; i++) {
					sb.append(bucket[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		int lastIndex = bucketSize - k - 1; // 현재 선택한 문자 개수 (버켓 크기)
		int smallest = 0;
		// 문자를 하나도 선택하지 않은 경우
		if(bucketSize == k) {
			smallest = 0; 
		} else {
			smallest = index + 1; // index : bucket에 담은 letter의 마지막 인덱스번호
		}
		
		for (int i = smallest; i < letter.length; i++) {
			bucket[lastIndex + 1] = letter[i];
			pick(letter, bucket, bucketSize, k - 1, i);
		}
	}
}
