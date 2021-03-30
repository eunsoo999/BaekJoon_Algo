package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BOJ1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		
		String[] math = br.readLine().split("\\-"); // "-" 기준으로 split

		for(int i = 0; i < math.length; i++) {
			String[] plus = math[i].split("\\+"); // "+" 기준으로 split
			int sum = 0;
			for (int j = 0; j < plus.length; j++) {
				sum += Integer.parseInt(plus[j]);
			}
			list.add(sum);
		}
		
		int sum = list.get(0); // 맨 앞은 +해줘야하므로 포문에서 따로 빼기
		for (int i = 1; i < list.size(); i++) {
			sum -= list.get(i);
		}
		System.out.println(sum);
	}
}
