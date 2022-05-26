package ru.serdyuk.bubblesort;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 */
public class BubbleSort {
    
    private static int[] sort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i + 1]) {
                    isSorted = false;
                    getTempElement(array, i);
                }
            }
        }
        return array;
    }

    private static void getTempElement(int[] array, int i) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(sort(array)));
    }
}
