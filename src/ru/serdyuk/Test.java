package ru.serdyuk;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] list = new int[(int) Math.round(Math.random() * Byte.MAX_VALUE)];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) Math.round(Math.random() * Byte.MAX_VALUE);
        }
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(sort(list)));
    }

    private static int[] sort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }
        return list;
    }


}
