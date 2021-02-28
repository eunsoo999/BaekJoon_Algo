package Soting;

import java.util.Arrays;
import java.util.Collections;

public class SortInJava {

	public static void main(String[] args) {
		//오름차순
		int[] array1 = {10, 3, 6, 2, 7};
		Arrays.sort(array1);
		System.out.println(Arrays.toString(array1));
		
		//내림차순
		Integer[] array2 = {10, 3, 6, 2, 7};
		Arrays.sort(array2, Collections.reverseOrder());
		System.out.println(Arrays.toString(array2));
	}

}
