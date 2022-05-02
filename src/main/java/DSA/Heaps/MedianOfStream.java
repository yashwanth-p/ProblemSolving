package DSA.Heaps;

import java.util.*;

public class MedianOfStream {
    /*
    Median of a stream of elements arr[0,n-1]at anytime equals:
    In the sorted array
    mid =  n/2
    array[mid] : if n is odd
    (arr[mid] + arr[mid-1])/2 : if n is even

    Solution involves:
    -- Getting the mid element(s) in constant time

    Maintain 2 heaps; max and min which are balanced always i.e. |max.length - min.length| <= 1
    -- What goes into heaps?
    (first half) max-heap => 1 2 3 4 | 5 6 7 8 <= min-heap(the second half)
        -- only the elements less than max element goes to max-heap (because it's the first half). Rest goes to min-heap
        -- if size is even, top elements from each of the heaps are mid elements
        -- if size is odd, top from max-heap is mid element
    -- When and how should they be rebalanced?
        -- Put the element in the minheap/maxheap
        -- check if they are balanced
        -- remove top from the unbalanced heap and add it to the other heap


       Time complexity analysis: O(NLogN) or O(N) ??


     -- What's the naive way to solve this? Insertion sort?

     */

    public static void main(String[] args) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int[] stream = new int[]{3, 6, 17, 15, 2, 13, 23, 54, 33, 26, 55, 11, 1, 12, 37, 26, 33, 56, 97, 29, 43, 65};
        List<Integer> testArray = new ArrayList<>(); //testing purposes only

        maxheap.add(stream[0]);
        testArray.add(stream[0]);
        for(int i=1; i<stream.length ; i++) {
            int current = stream[i];
            // O(logN) actually: O(log1) + O(log2) + O(log3) + ....
            if(current < maxheap.peek()) {
                maxheap.add(current);
            } else {
                minheap.add(current);
            }
            // rebalance
            // O(logN)
            if(Math.abs(maxheap.size() - minheap.size()) > 1) {
                if(maxheap.size() > minheap.size()) {
                    minheap.add(maxheap.poll()); // from max heap to min heap
                } else {
                    maxheap.add(minheap.poll());
                }
            }

            // find the median. this can be included in the above statements
            // O(1)
            double median;
            if(maxheap.size() == minheap.size()) {
                median = (maxheap.peek() + minheap.peek())/2.0;
            } else {
                median = maxheap.size() > minheap.size() ? maxheap.peek() : minheap.peek();
            }
            System.out.println(median);

            // verify using a test array
            testArray.add(current);
            verify(testArray, median);
        }
    }

    private static void verify(List<Integer> testArray, double actualMedian) {
        Collections.sort(testArray);
        for(int e : testArray) {
            System.out.print(e + " ");
        }
        double expectedMedian = 0;
        int mid = testArray.size() / 2;
        if(isEven(testArray.size())) {
            expectedMedian = (testArray.get(mid) + testArray.get(mid-1))/2.0;
        } else {
            expectedMedian = testArray.get(mid);
        }
        System.out.println();
        System.out.printf("Actual median: %s Expected median: %s \n", actualMedian, expectedMedian);

        if(expectedMedian == actualMedian) {
            System.out.println("Check Passed");
        } else {
            System.out.println("** Check Failed **");
            System.exit(1);
        }

        System.out.println("");
    }

    private static boolean isEven(int size) {
        return size % 2 == 0;
    }


}
