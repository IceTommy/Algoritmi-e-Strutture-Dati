package algorithm.sorting;

import java.util.Arrays;

/**
 * This class contains various sorting algorithms
 */
public class Sorting {

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n<sup>2</sup>)
	 * <p>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void selectionsort(int A[]) {

			for (int i = 0; i < A.length; i++) {
				int m=i;
				for (int j = i+1; j < A.length; j++) {
					if(A[j] < A[m]){
						m=j;
					}
				}if(m!=i){
					swap(A,i,m);
				}
			}

		}




	public static void insertionsort(int A[]) {
		for (int i = 1; i < A.length; i++) {
			int j = i;
			while (j > 0 && A[j] < A[j - 1]) {
				swap(A, j, j - 1);
				j--;
			}
		}
	}
	private static void swap(int A[], int i, int j){
		int tmp=A[i];
		A[i]=A[j];
		A[j]=tmp;
	}


	public static void mergesort(int A[]) {
		mergesort_rec(A, 0, A.length - 1);
	}
	public static void mergesort_rec(int A[], int p, int r) {
		if (p < r) {
			int q = p + (r - p) / 2;
			mergesort_rec(A, p, q);
			mergesort_rec(A, q + 1, r); // Corrected the start index
			merge(A, p, q, r);
		}
	}

	public static void merge(int[] A, int p, int q, int r) {
		int[] B = new int[r - p + 1];
		int i = p;
		int j = q + 1;
		int k = 0; // Corrected the starting index
		while (i <= q && j <= r) {
			if (A[i] <= A[j]) { // Corrected the condition
				B[k] = A[i];
				i++;
			} else {
				B[k] = A[j];
				j++;
			}
			k++;
		}
		while (i <= q) {
			B[k] = A[i];
			k++;
			i++;
		}
		while (j <= r) {
			B[k] = A[j];
			k++;
			j++;
		}
		for (k = 0; k <= r - p; k++) { // Corrected the loop condition and increment
			A[p + k] = B[k];
		}
	}




	public static void quicksort(int A[]) {
		quicksort_rec(A, 0, A.length - 1);
	}

	public static void quicksort_rec(int A[], int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quicksort_rec(A, p, q - 1);
			quicksort_rec(A, q + 1, r);
		}
	}

	public static int partition(int A[], int p, int r) {
		int x = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++) { // Corrected loop condition
			if (A[j] <= x) {
				i++;
				swap(A, i, j); // Corrected swap operation
			}
		}
		swap(A, i + 1, r); // Corrected placement of swap operation
		return i + 1;
	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n+k)
	 * <p>
	 * Implements the countingsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n+k), where k = max(<code>A</code>)-min(<code>A</code>)+1
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void countingsort(int A[]) {
		int a = Arrays.stream(A).min().getAsInt();
		int b = Arrays.stream(A).max().getAsInt();
		int k = b - a + 1;
		int[] B = new int[k];

		for (int i = 0; i < k; i++) {
			B[i] = 0;
		}

		for (int i = 0; i < A.length; i++) {
			B[A[i] - a]++; // Corrected index calculation
		}

		int j = 0;
		for (int i = 0; i < k; i++) {
			while (B[i] > 0) {
				A[j] = i + a; // Corrected index calculation
				B[i]--;
				j++;
			}
		}
	}


}
