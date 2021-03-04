package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
 * Arrays.sort(), QuickSort의 시간복잡도는 O(nlogn)이지만, 최악의 경우 O(n^2)
 * 
 */
public class BOJ10989 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		//ArrayList<Integer> array = new ArrayList<>();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		//	array.add(Integer.parseInt(br.readLine()));
		}
		
		//Collections.sort(array);
		Arrays.sort(array);
		
		for (int i = 0; i < n; i++) {
		//	bw.write(String.valueOf(array.get(i)) + "\n");
			bw.write(String.valueOf(array[i]) + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
