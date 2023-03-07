package ru.serdyuk.bubblesort;

import java.util.Arrays;

/**
 * @author Serdyuk S.B.
 * Наиболее простая реализация сортировки, основанная на сравнении каждого элемента с последующим и swap если надо
 * Асимптотическая сложность O(N^2), пространственная также O(N) + O(1) для временной переменной
 * не устойчивый алгоритм
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

    /** Такая реализация пузырьковой сортировки имеет временную сложность
     *  n * n, так как два вложенных цикла проходят дважды по всему массиву данных
     *
     * **/
    private static int[] bubbleSort(int[] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src.length - 1; j++) {
                if (src[j] > src[j + 1]) {
                    getTempElement(src, j);
                }
            }
        }
        return src;
    }

    /** У сортировки пузырьком в такой реализации сложность О(n * (n + 1) / 2),
     *  те равна арифметической прогрессии, а не квадратичной сложности n * n
     * **/
    private static int[] bubbleSortVar(int[] src) {
        boolean isSorted = false;
        for (int i = 0; i < src.length && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < src.length - (1 + i); j++) {
                if (src[j] > src[j + 1]) {
                    getTempElement(src, j);
                    isSorted = false;
                }
            }
        }
        return src;
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(bubbleSortVar(array)));
    }
}
/**  n (n + 1) / 2 = 10 (10 + 1) / 2 = 55  **/