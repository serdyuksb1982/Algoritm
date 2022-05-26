package ru.serdyuk.insertionsort;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 */
public class InsertionSort {

    private static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > currentElement) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = currentElement;
        }

    }

    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1,0};
        insertionSort(array);
        System.out.println(Arrays.toString((array)));
    }
}
