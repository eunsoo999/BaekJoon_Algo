package Soting;

public class InsertSort {
	
	public static void insertsort(int[] array) {
		
		for (int i = 0; i < array.length - 1; i++) { //�����Ͱ� 2���� ��� 1�� �� - �����Ͱ� 3���� ��� 2�� ��
			for (int j = i + 1; j > 0; j--) { // ù��° ���� : �����ε����� 1��, �ι�° ����: �����ε����� 2��
				if (array[j] < array[j - 1]) {
					swap(array, j, j-1);
				} else { // �ڽ��� �ٷ� �� ������ ������ ��� ������ �� �����̹Ƿ� �ٷ� �� �����Ͱ� �� �۴ٸ�, �״�� �ݺ��� ����
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
