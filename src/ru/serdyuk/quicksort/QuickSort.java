package ru.serdyuk.quicksort;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 * O(N) = N * log N квазилогарифмическая сложность
 * разбиение входного массива на меньшие по объему массивы, вплоть до 1-ого елемента
 * Сортировка не устойчива
 * Пространственная сложность О(N) + O(1), на временную переменную
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {9, 7, 3, 5, 0, 4, 2, 1};
        quickSort(array,0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int pivot = partition_2(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        for (int i = start; i <= end ; i++) {
            if (array[i] <= array[end]) {
                swap(array, start, i);
                start = start + 1;
            }

        }
        return start - 1;
    }

    private static void swap(int[] array, int start, int i) {
        int pivot = array[start];
        array[start] = array[i];
        array[i] = pivot;
    }

    private static int partition_2(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }



}
