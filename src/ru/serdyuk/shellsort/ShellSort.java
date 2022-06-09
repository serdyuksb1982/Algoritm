package ru.serdyuk.shellsort;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 * Сортировка Шелла имеет O(N^4/3)
 * объединяет в себе сортировку вставками, но на расстроянии от элементов
 * Сортировка не устойчива
 * Пространственные затраты O(N) + O(1) на временную переменную
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {9, 7, 4, 2, 8, 5, 1, 3, 0};
        shellSortClassic(array);
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

    private static void shellSortClassic(int[] array) {
        int n = array.length;
        for (int step = n / 2; step > 0 ; step /= 2) {
            for (int i = step; i < n; i++) {
                for (int j = i - step; j >= 0 && array[j] > array[j + step]; j -= step) {
                    int temp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = temp;
                }
            }
        }
    }
}
