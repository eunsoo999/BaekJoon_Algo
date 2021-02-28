package Soting;

public class BubbleSort {
	
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void bubblesort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean isSwap = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j+1);
					isSwap = true;
				}
			}
			if (!isSwap) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[5];
		
		for (int i = 0; i < 5; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		for (int num : array)
			System.out.print(num + " ");
		System.out.println();
		bubblesort(array);
		for (int num : array)
			System.out.print(num + " ");
	}
}
