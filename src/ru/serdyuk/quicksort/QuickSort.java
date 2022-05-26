package ru.serdyuk.quicksort;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 */
public class QuickSort {
    
    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                swap(array, start, i);
                start += 1;
            }
        }
        return start -1;
    }

    private static void swap(int[] array, int start, int i) {
        int temp = array[start];
        array[start] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 7, 3, 5, 0, 4, 2, 1};
        quickSort(array,0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
