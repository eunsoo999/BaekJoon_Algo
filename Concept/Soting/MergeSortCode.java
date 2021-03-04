package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortCode {
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		int[] temp = new int[arr.length];
		
		while (i <= mid && j <= right) {  // 왼쪽배열이랑 오른쪽배열 둘다 남아서 비교가 가능할 경우
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid) { // 왼쪽 부분 배열이 남았을 경우
			temp[t++] = arr[i++]; // 왼쪽배열은 이미 정렬된 상태이므로 그대로 넣어줌.
		}
		
		while (j <= right) { // 오른쪽 부분 배열이 남았을 경우
			temp[t++] = arr[j++];
		}
		
		i = left;
		t = 0;
		while (i <= right) {
			arr[i++] = temp[t++]; //정렬된걸 다시 arr[]에 넣어줌.
		}
	}
	
	public static void mergeSort (int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2; // 반으로 나눔
			mergeSort(arr, left, mid); // 왼쪽 배열 나눔
			mergeSort(arr, mid + 1, right); // 오른쪽 배열 나눔
			merge(arr, left, mid, right); // 왼쪽, 오른쪽 배열 합침.
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
