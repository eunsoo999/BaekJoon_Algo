import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B2750 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int array[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		for (int i : array) {
			bw.write(Integer.toString(i));
			bw.newLine();
		}
		bw.flush();
	}
	
	/*
	 * BufferedReader 사용 | 15108 KB, 188ms
	 * 
	 * public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int array[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		for (int i : array) {
			System.out.println(i);
		}
		
	}*/
	
	/*
	 * Scanner 사용 | 22116 KB, 352 ms
	 * 
	 * public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
		Arrays.sort(array);
		
		for (int i : array) {
			System.out.println(i);
		}
	}*/
}
