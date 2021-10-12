import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String string = Charset.defaultCharset ().displayName ();
        System.out.println (string);
        int[] list = new int[(int) Math.round(Math.random() * Byte.MAX_VALUE)];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) Math.round(Math.random() * Byte.MAX_VALUE);
        }
        System.out.println(Arrays.toString(list));

        //bubleSort ( list );
        quickSort ( list,0, list.length - 1);
        Iterator<Integer> iterator = Arrays.stream( list ).iterator ();
        while (iterator.hasNext ()) {
            System.out.printf ("%d , ",iterator.next ());
        }
        System.out.println ("------------");
        binarySearch ( list,0, list.length, 5);
        //fibonachi ( 44 );
        System.out.println ("------------------");
        factorial ( 19 );
        boolean b = isPrime ( getMaxElement ( list ) );
        System.out.print (b);
        System.out.println (" - " + getMaxElement ( list ));
    }
    public static int getMaxElement(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            if(value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static int[] bubleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if(array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    //method quickSort();
    public static int[] quickSort(int[] array, int start, int end) {
        if(start >= end) {
            return array;
        }
        int pivot = partition2 ( array, start, end );
        quickSort ( array, start, pivot - 1 );
        quickSort ( array, pivot, end );
        return array;
    }
    public static int partition(int[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
            if(array[i] <= array[end]) {
                int temp = array[start];
                array[start] = array[i];
                array[i] = temp;
                start += 1;
            }
        }
        return start - 1;
    }
    public static int partition2(int[] array, int from, int to) {
        int leftElement = from;
        int rightElement = to;
        int pivot = array[from + (to - from) / 2];
        while (leftElement <= rightElement) {
           while (array[leftElement] < pivot) {
               leftElement++;
           }
           while (array[rightElement] > pivot) {
               rightElement--;
           }
            if(leftElement <= rightElement) {
                temp ( array, leftElement,rightElement );
                leftElement++;
                rightElement--;
            }
        }
        return leftElement;
    }

    public static void temp(int[] array, int leftElement, int rightElement) {
        int temp = array[leftElement];
        array[leftElement] = array[rightElement];
        array[rightElement] = temp;
    }

    //binary search;
    public static int binarySearch(int[] array, int first, int last, int item) {

        int middle = (first + last) / 2;
        while ((array[middle] != item) && (first <= last)) {
            if (array[middle] > item) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }
            middle = (first + last) / 2;
        }
        if(first <= last) {
            System.out.printf ( "%d -> %d%n", item, ++middle );
        } else System.out.printf ("%s","Error");
        return middle;

    }

    public static void fibonachi(int n) {
        Stream.iterate ( new int[] {0,1}, array -> new int[] {array[1], array[0] + array[1]} )
                .limit ( n )
                .map ( y -> y[0] )
                .forEach ( System.out::println );
    }
    public static long factorial(long n) {

        long result = 1;

        for (long i = 1; i <= n; i++) {
            result = result * i;
        }

        return result;
    }
    public static boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; ++i) {
            if(i % n == 0) {
                return false;
            }
        }
        return true;
    }
}
