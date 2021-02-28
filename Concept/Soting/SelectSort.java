package Soting;

public class SelectSort {
	
	public static void selectsort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
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
		selectsort(array);
		for (int num : array)
			System.out.print(num + " ");
	}
}
