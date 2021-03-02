package Concept;

import java.util.Arrays;
/*
 * 이진탐색(이분탐색) : 탐색할 자료를 둘로 나누어 해당 데이터가 있을만한 곳을 탐색하는 방법
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 ,9 };
		
		System.out.println(Arrays.toString(arr));
		
		if (binarySearch(arr, 0, arr.length - 1, 4) == 1)
			System.out.println("존재합니다.");
		else 
			System.out.println("존재하지않습니다.");
	}
	
	public static int binarySearch(int[] arr, int start, int end, int data) {
		
		if (start > end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if (arr[mid] > data) {
			return binarySearch(arr, start, mid - 1, data); // mid번이 data가 아니므로 비교하는 의미없음 -1.
		} else if (arr[mid] < data) {
			return binarySearch(arr, mid + 1, end, data);
		} else {
			return 1;
		}
	}
}