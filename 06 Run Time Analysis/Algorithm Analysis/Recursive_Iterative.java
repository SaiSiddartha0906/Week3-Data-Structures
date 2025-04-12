import java.util.*;
import java.io.*;

public class Recursive_Iterative {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        double starttime, endtime;
        final int a=1000000;
        starttime=System.nanoTime();
        fibonacciIterative(30);
        endtime=System.nanoTime();
        System.out.println("Fibonacci Iterative for 30 is :"+((endtime-starttime)/a));

        starttime=System.nanoTime();
        fibonacciRecursive(30);
        endtime=System.nanoTime();
        System.out.println("Fibonacci Recursive for 30 is :"+((endtime-starttime)/a));
    }
}
