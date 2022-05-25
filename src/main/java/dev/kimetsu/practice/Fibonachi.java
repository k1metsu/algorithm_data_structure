package dev.kimetsu.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Fibonachi {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int fibonachi = fib1(40);
        long end = System.currentTimeMillis() - start;
        System.out.println("Fib1 = " + fibonachi + ", time = " + end + "ms");

        start = System.currentTimeMillis();
        int fibonachi1 = fib2(40);
        end = System.currentTimeMillis() - start;
        System.out.println("Fib2 = " + fibonachi1 + ", time = " + end + "ms");

        start = System.currentTimeMillis();
        int fibonachi2 = fib3(40);
        end = System.currentTimeMillis() - start;
        System.out.println("Fib3 = " + fibonachi2 + ", time = " + end + "ms");

        stream().limit(41).forEachOrdered(System.out::println);

    }

    // StackOverflowError
    private static int fib(int n) { // StackOverflowError
        return fib(n - 1) + fib(n - 2);
    }

    // BASE SITUATION
    private static int fib1(int n) {
        if (n < 2) return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    // MEMOIZATION
    static Map<Integer, Integer> memo = new HashMap<>(Map.of(0,0,1,1));

    private static int fib2(int n) {
        if(!memo.containsKey(n)) {
            memo.put(n, fib2(n - 1) + fib2(n - 2));
        }
        return memo.get(n);
    }

    // easier, Fibonacci Be!
    private static int fib3(int n) {
        int last = 0, next = 1; //fib(0) fib(1)
        for (int i = 0; i < n; i++) {
            int oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }


    // GENERATION first 41 number FIBONACHI
    static int last1 = 0, next1 = 1;

    private static IntStream stream() {
        return IntStream.generate(() -> {
            int oldLast = last1;
            last1 = next1;
            next1 = oldLast + next1;
            return oldLast;
        });
    }
}
