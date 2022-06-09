package ru.serdyuk.binarysearch;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {0, 7, 9, 111, 1, 80, 18, 100};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(recursiveBinarySearch(array, 80));
    }
    private static int recursiveBinarySearch(int[] array, int element) {
        return recursiveBinarySearch(array, element, 0, array.length - 1);
    }

    private static int recursiveBinarySearch(int[] array, int element, int low, int high) {
        if (low > high) return -1;

        int elementPosition = -1;

        int mid = (low + high) / 2;

        if (element == array[mid]) {
            elementPosition = mid;
        } else if (element < array[mid]) {
            recursiveBinarySearch(array, element, low, mid - 1);
        } else if (element > array[mid]) {
            recursiveBinarySearch(array, element, mid + 1, high);
        }
        return elementPosition ;
    }
}
