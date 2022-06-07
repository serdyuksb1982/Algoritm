package ru.serdyuk.shellsort;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {9, 7, 4, 2, 8, 5, 1, 3, 0};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort(int[] array) {
        int middleElement = array.length / 2;
        while (middleElement > 0) {
            for (int i = 0; i < array.length - middleElement; i++) {
                int j = i;
                while (j >= 0 && (array[j] > array[j + middleElement])) {
                    swap(array, middleElement, j);
                    j--;
                }
            }
            middleElement /= 2;
        }
    }

    private static void swap(int[] array,int j , int middleElement) {
        int temp = array[j];
        array[j] = array[j + middleElement];
        array[j + middleElement] = temp;
    }
}
