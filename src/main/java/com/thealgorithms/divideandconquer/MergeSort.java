package com.thealgorithms.divideandconquer;

public class MergeSort {

    /**
     * Main method for testing the merge sort implementation.
     */
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Given Array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    /**
     * Recursive method that sorts the input array using the merge sort algorithm.
     *
     * @param arr The array to be sorted.
     * @param l   The starting index of the array (usually 0).
     * @param r   The ending index of the array.
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point of the array
            int m = l + (r - l) / 2;

            // Recursively sort the first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
    /**
     * Merges two sub-arrays of arr[].
     * First sub-array is arr[l..m]
     * Second sub-array is arr[m+1..r]
     *
     * @param arr The main array that contains the sub-arrays to be merged.
     * @param l   The starting index of the first sub-array.
     * @param m   The ending index of the first sub-array.
     * @param r   The ending index of the second sub-array.
     */
    public static void merge(int[] arr, int l, int m, int r) {
        // Calculate the sizes of the two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays to hold the values of the two sub-arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temporary arrays back into the main array arr[l..r]
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    /**
     * Utility method to print the contents of an array.
     *
     * @param arr The array to be printed.
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
