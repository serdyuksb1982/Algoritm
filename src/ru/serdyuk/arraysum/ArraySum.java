package ru.serdyuk.arraysum;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 * это задание на (провальном) собеседовании в Информзащита.
 * Нужно сложить два массива: [9,9,9] и [1], получив [1,0,0,0],
 * не используя при этом сторонних библиотек (ArrayList,...)
 */
public class ArraySum {
    static int[] array1 = {9,9,9};
    static int[] array2 = {1};
    static int array1Length = array1.length;
    static int array2Length = array2.length;
    static final int resultArrayLength = Math.max(array1Length,array2Length) + 1;
    static int[] resultArray = new int[resultArrayLength];
    static int currentSum;
    static int shiftValue = 0;
    private static int[] sumTwoArrays(int[] array1, int[] array2) {
        int i = array1Length - 1;
        int j = array2Length - 1;
        int k = resultArrayLength - 1;
        //вариант, когда оба массива одной длинны
        while (i >= 0 && j >= 0) {
            currentSum = array1[i] + array2[j] + shiftValue;
            getShiftValue(k);
            i--; j--; k--;
        }
        //вариант, когда массив ar2 короче ar1
        while (i >= 0) {
            currentSum = array1[i] + shiftValue;
            getShiftValue(k);
            i--; k--;
        }
        //вариант, когда массив ar1 короче ar2
        while (j >= 0) {
            currentSum = array2[j] + shiftValue;
            getShiftValue(k);
            j--; k--;
        }
        resultArray[k] = shiftValue;
        return resultArray;
    }

    private static void getShiftValue(int k) {
        resultArray[k] = currentSum % 10;
        currentSum = currentSum / 10;
        shiftValue = currentSum % 10;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumTwoArrays(array1,array2)));
    }
}
