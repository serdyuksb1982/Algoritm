package ru.serdyuk.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] list = new int[(int) Math.round(Math.random() * Byte.MAX_VALUE)];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) Math.round(Math.random() * Byte.MAX_VALUE);
        }
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(mergeSort(list)));
    }
    public static int[] mergeSort(int[] src) {
        if(src.length <= 1) return src;
        int[] left = Arrays.copyOfRange(src, 0, src.length / 2);
        int[] right = Arrays.copyOfRange(src, left.length, src.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int resultIndex = 0;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if (leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
                result[resultIndex++] = leftArray[leftArrayIndex++];
            } else result[resultIndex++] = rightArray[rightArrayIndex++];
        }
        while (resultIndex < result.length) {
            if (leftArrayIndex != leftArray.length) {
                result[resultIndex++] = leftArray[leftArrayIndex++];
            } else result[resultIndex++] = rightArray[rightArrayIndex++];
        }
        return result;
    }
}
