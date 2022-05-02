package DSA.DP;

import java.util.Random;

public class MaximumSumSubArray {

    public static final int SIZE = 10;
    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 4, 3, -1, 6, -3};
        int[] largeArray = getRandomArray();

        printMaxSubarraySum_Naive(largeArray);
        printMaxSubarraySum_Kadanes(largeArray);

    }

    private static void printMaxSubarraySum_Kadanes(int[] arr) {
        System.out.println();
        long start = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        int localMax = 0;
        for(int i=0; i<arr.length; i++) {
            localMax = Math.max(arr[i], localMax + arr[i]);
            max = Math.max(localMax, max);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken(sec): " + (end - start)/1000.0);
        System.out.printf("Max sum: %d\n", max);

    }

    private static int[] getRandomArray() {
        int[] arr = new int[SIZE];
        Random r = new Random();
        for(int i=0; i < SIZE; i++) {
            int x = r.nextInt(40);
            // put the negatives with 1/3 probability
            arr[i] = r.nextInt(3) == 2 ? x : -x;
        }
        return arr;
    }

    private static void printMaxSubarraySum_Naive(int[] arr) {
        long start = System.currentTimeMillis();
        int max = arr[0];
        int s = -1, e = -1;
        for(int i=0; i<arr.length; i++) {
            int sum = arr[i];
            for(int j=i+1; j<arr.length; j++) {
                sum += arr[j];
                if(Math.max(sum, arr[j]) > max) {
                    max = Math.max(sum, arr[j]);
                    s = i;
                    e = j;
                }
                max = Math.max(max, sum);
            }
            System.out.println(arr[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken(sec): " + (end - start)/1000.0);
        System.out.printf("Max sum: %d, Start index : %d, End index: %d \n", max, s, e);
    }
}
