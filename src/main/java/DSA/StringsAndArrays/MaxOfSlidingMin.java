package DSA.StringsAndArrays;

import java.util.TreeMap;

public class MaxOfSlidingMin {
    // given n integers and window length k
    // find maximum( min(window1), min(window2), min(window3), ...)
    // https://leetcode.com/problems/sliding-window-maximum/

    // there is an efficient approach with Dequeue

    public static void main(String[] args) {
        int[] array = {1, 4, 10, 6, 12, 13, 3, 7, 8};
        int[] array2 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int maxOfMin = getMaxOfSlidingMin(array, k);
        System.out.println("Max of Min : " + maxOfMin);

        maxOfMin = getMaxOfSlidingMin(array2, k);
        System.out.println("Max of Min: " + maxOfMin);


        maxOfMin = getMaxOfSlidingMinNaive(array, k);
        System.out.println("Max of Min Naive: " + maxOfMin);

        maxOfMin = getMaxOfSlidingMinNaive(array2, k);
        System.out.println("Max of Min Naive: " + maxOfMin);

    }

    private static int getMaxOfSlidingMinNaive(int[] array, int k) {

        int n = array.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<n-k+1; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=i; j<i+k; j++) {
                int cur = array[j];
                min = Math.min(min,cur);
            }
            max = Math.max(max, min);
        }

        return max;
    }

    private static int getMaxOfSlidingMin(int[] array, int k) {

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

        int max = Integer.MIN_VALUE;
        // add first k elements
        for (int i = 0; i < k; i++) {
            addOnce(array[i], sortedMap);
        }
        int windowMin = getMinimumOfCurrentBatch(sortedMap);
        max = Math.max(windowMin, max);


        for (int i = k; i < array.length; i++) {
            removeOnce(array[i - k], sortedMap);
            addOnce(array[i], sortedMap);
            windowMin = getMinimumOfCurrentBatch(sortedMap);
            max = Math.max(windowMin, max);
        }

        return max;
    }

    private static void removeOnce(int x, TreeMap<Integer, Integer> sortedMap) {
        sortedMap.put(x, sortedMap.getOrDefault(x, 0) - 1);
        int currentCount = sortedMap.get(x);
        if (currentCount <= 0) {
            sortedMap.remove(x);
        }
    }

    private static int getMinimumOfCurrentBatch(TreeMap<Integer, Integer> sortedMap) {
        return sortedMap.firstKey();
    }

    private static void addOnce(int x, TreeMap<Integer, Integer> sortedMap) {
        sortedMap.put(x, sortedMap.getOrDefault(x, 0) + 1);
    }

}
