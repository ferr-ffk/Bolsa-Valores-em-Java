package util;

public class AlgoritmosOrdenacao {

	public static void bubbleSort(int[] v) {
		boolean mudouAlgum = true;

		while (mudouAlgum) {
			mudouAlgum = false;

			for (int i = 0; i < v.length - 1; i++) {
				int temp = v[i];

				if (v[i] > v[i + 1]) {
					mudouAlgum = true;

					v[i] = v[i + 1];
					v[i + 1] = temp;
				}
			}
		}

	}

	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	public static void mergeSort(int[] arr) {
		if (arr.length > 1) {
			int mid = arr.length / 2;
			int[] left = new int[mid];
			int[] right = new int[arr.length - mid];
			for (int i = 0; i < mid; i++) {
				left[i] = arr[i];
			}
			for (int i = mid; i < arr.length; i++) {
				right[i - mid] = arr[i];
			}
			mergeSort(left);
			mergeSort(right);
			merge(arr, left, right);
		}
	}

	private static void merge(int[] arr, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		while (i < left.length) {
			arr[k++] = left[i++];
		}
		while (j < right.length) {
			arr[k++] = right[j++];
		}
	}

	public static void shellSort(int[] arr) {
		int n = arr.length;
		int gap = n / 2;
		while (gap > 0) {
			for (int i = gap; i < n; i++) {
				int temp = arr[i];
				int j = i;
				while (j >= gap && arr[j - gap] > temp) {
					arr[j] = arr[j - gap];
					j -= gap;
				}
				arr[j] = temp;
			}
			gap /= 2;
		}
	}

	public static void quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int pivotIndex = partition(arr, left, right);
			sort(arr, left, pivotIndex - 1);
			sort(arr, pivotIndex + 1, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = temp;
		return i + 1;
	}

}