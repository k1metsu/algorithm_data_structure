package dev.kimetsu.practice;

import java.util.stream.IntStream;

public class Main1 {
    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 1000_000).toArray();

//        long start = System.currentTimeMillis();
//        int idx = binarySearch(arr, 795_314);
//        long end = System.currentTimeMillis() - start;
//        System.out.println("completed in " + end + "ms, target found at index " + idx);
        System.out.println(fact(5));
    }

    private static int fact(int num) {
        if(num == 1) return 1;
        else return num * fact(num - 1);
    }

    private static int binarySearch(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == item) return mid;
            else if(item < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
