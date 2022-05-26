package ru.serdyuk.shellsort;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 */
public class ShellSort {
    private static int[] shellSort(int[] array) {
        int middleElement = array.length / 2;
        while (middleElement > 0) {
            for (int i = 0; i < (array.length - middleElement); i++) {
                int j = i;
                while (j >= 0 && array[j] > array[j + middleElement]) {
                    swapElement(array, middleElement, j);
                    j--;
                }
            }
            middleElement /= 2;
        }
        return array;
    }

    private static void swapElement(int[] array, int middleElement, int j) {
        int temp = array[j];
        array[j] = array[j + middleElement];
        array[j + middleElement] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 7, 4, 2, 8, 5, 1, 3, 0};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
