package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortCode {
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int q = partition(arr, left, right);
			quickSort(arr, 0, q - 1);
			quickSort(arr, q + 1, right);
		}
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		
		int i = left - 1; //1구역마지막인덱스 (기준보다 작은 값의 배열)
		
		for (int j = left; j < right; j++) {
			if (pivot > arr[j]) {
				int temp = arr[++i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		arr[right] = arr[i + 1]; //pivot을 제자리로
		arr[i + 1] = pivot;
		
		return i + 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
