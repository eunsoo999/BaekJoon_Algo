package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2751_mergesort {
	
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		int[] temp = new int[right - left + 1];
		
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) { 
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		
		i = left;
		t = 0;
		
		while (i <= right) {
			arr[i++] = temp[t++];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(array, 0, n - 1);
		
		for (int i = 0; i < n; i++) {
			bw.write(String.valueOf(array[i]) + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
