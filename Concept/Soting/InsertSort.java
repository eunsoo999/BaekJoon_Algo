package Soting;

public class InsertSort {
	
	public static void insertsort(int[] array) {
		
		for (int i = 0; i < array.length - 1; i++) { //데이터가 2개일 경우 1번 비교 - 데이터가 3개일 경우 2번 비교
			for (int j = i + 1; j > 0; j--) { // 첫번째 실행 : 기준인덱스는 1임, 두번째 실행: 기준인덱스는 2임
				if (array[j] < array[j - 1]) {
					swap(array, j, j-1);
				} else { // 자신의 바로 앞 데이터 이전은 모두 정렬이 된 상태이므로 바로 앞 데이터가 더 작다면, 그대로 반복문 종료
					break;
				}
			}
		}
	}

	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = new int[5];
		
		for (int i = 0; i < 5; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		for (int num : array)
			System.out.print(num + " ");
		System.out.println();
		insertsort(array);
		for (int num : array)
			System.out.print(num + " ");
	}
}
