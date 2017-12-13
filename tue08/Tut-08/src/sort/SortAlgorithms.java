package sort;

import java.util.Arrays;

public class SortAlgorithms {

	public static void selectionSort(int[] array) {
		int links = 0;
		do {
			// first element is minimum
			int minIndex = links;
			for(int i = links + 1; i < array.length; i++) {
				if (array[i] < array[minIndex]) {
					minIndex = i;
				}
			}
			swap(array, minIndex, links);
			links++;
			System.out.println(links + " Zahlen sortiert: " + Arrays.toString(array));
		} while (links < array.length);
		
	}

	public static void insertionSort(int[] array) {
		int i = 1;
		while (i < array.length) {
			int j = i;
			while (j > 0 && array[j - 1] > array[j] ) {
				swap(array, j - 1, j);
				j--;
			}
			i++;
			System.out.println(i + " Zahlen sortiert: " + Arrays.toString(array));
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
