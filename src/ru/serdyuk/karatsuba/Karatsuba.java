package ru.serdyuk.karatsuba;
import static java.lang.Math.*;
/**
 * @author Serdyuk S.B.
 */
public class Karatsuba {
    private static long karatsubaSum(long i, long j) {
        if(i < 10 || j < 10) return i * j;

        double n = Long.toString(Math.max(i, j)).length();

        long a = (long) (i / getPow(n));

        long b = (long) (i % getPow(n));

        long c = (long) (j / getPow(n));

        long d = (long) (j % getPow(n));

        long first = karatsubaSum(a,c);

        long second = karatsubaSum(b,d);

        long third = karatsubaSum((a + b), (c + d));

        return (long) ((first * getPow(n, 2)) + ((third - second - first) * getPow(n) ) + second);
    }

    private static double getPow(double n) {
        return pow(10, floor(n / 2));

    }

    private static double getPow(double n, int a) {
        return pow(10, floor(n / 2) * a);

    }

    public static void main(String[] args) {
        System.out.println(karatsubaSum(1214, 3415));
        System.out.println(1214 * 3415);
    }
}
