package ru.serdyuk;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] list = new int[(int) Math.round(Math.random() * Byte.MAX_VALUE)];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) Math.round(Math.random() * Byte.MAX_VALUE);
        }
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(mergeSort(list)));
    }

    private static int[] mergeSort(int[] list) {
        if (list.length <= 1) return list;
        int[] leftArray = Arrays.copyOfRange(list, 0, list.length / 2);
        int[] rightArray = Arrays.copyOfRange(list, leftArray.length, list.length);
        return merge(mergeSort(leftArray), mergeSort(rightArray));
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int resultIndex = 0;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        while(leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if (leftArray[leftArrayIndex] < rightArray[rightArrayIndex])
                result[resultIndex++] = leftArray[leftArrayIndex++];
            else result[resultIndex++] = rightArray[rightArrayIndex++];
        }
        while(resultIndex < result.length) {
            if (leftArrayIndex != leftArray.length) {
                result[resultIndex++] = leftArray[leftArrayIndex++];
            }
            else result[resultIndex++] = rightArray[rightArrayIndex++];
        }
        return result;
    }


}
