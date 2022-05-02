package DSA.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSumSubArray2 {
    public static void main(String[] args) {
        // [-2, 1, -3, 4, -1, 2, 1, -5, 4]  = 6
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        System.out.println("Enter the elements");
        while (size-- > 0) {
            list.add(sc.nextInt());
        }
        long start = System.nanoTime();
        int maxSum = MaxSubArrayHelper.maxSubArrayBrute(list);
        long end = System.nanoTime();
        System.out.println("Brute Force : Time took in nanoSeconds "+(end-start));

        start = System.nanoTime();
        int maxSumKadane = MaxSubArrayHelper.maxSubArrayKadane(list);
        end = System.nanoTime();
        System.out.println("Kadane's Algo : Time took in nanoSeconds "+(end-start));


        System.out.println(maxSum);
        System.out.println(maxSumKadane);

    }

    static class MaxSubArrayHelper {

        public static final int maxSubArrayBrute(List<Integer> arrayList) {
            int maxSumOverall = Integer.MIN_VALUE;
            for (int i = 0; i < arrayList.size(); i++) {
                int maxSumInThisIteration = arrayList.get(i);
                int sum = arrayList.get(i);
                for (int j = i + 1; j < arrayList.size(); j++) {
                    sum += arrayList.get(j);
                    if (sum > maxSumInThisIteration) {
                        maxSumInThisIteration = sum;
                    }
                }
                if (maxSumInThisIteration > maxSumOverall) {
                    maxSumOverall = maxSumInThisIteration;
                }
            }
            return maxSumOverall;
        }

        public static final int maxSubArrayKadane(List<Integer> list) {
            int maxSoFar = list.get(0);
            int currentSum  = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                currentSum = maximumOf(currentSum+list.get(i), list.get(i));
                maxSoFar = maximumOf(maxSoFar, currentSum);
            }
            return maxSoFar;
        }

        public static final int maximumOf(int a , int b) {
            return a>b?a:b;
        }
    }
}


