package DSA.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSorted {

    /*
    Statement: Given an array of elements of size N and K, where every element is at a distance of range -K to +K from
    their original positions once  sorted. This is called a K-Sorted array.

    Make use of this feature and sort it in the best time possible

    Answer1(Obvious) : Sort the array using the best possible algorithm. O(NlogN)

    Answer2(Optimal): Use min-heap
    One observation: the first element of the array will be within a distance of next K positions aka at most in K+1
    indices.
    Putting it other way: An element at index 'i' can be within index range of [i,K+1] GIVEN array [0,i-1] is sorted

    This can be created using a min-heap. How?
    -- Construct a min-heap of first K+1 elements
    -- In every iteration starting from N-K to N elements
        -- Extract Minimum element from heap and put it in front of the array. This way we are bubbling up the array to
        so that it will be sorted eventually
        -- Insert the new element into the min-heap
        -- When there are no elements left to be added from array to heap, empty the heap by extracting the minimum elements

    -- This way evey time we are creating a sorted array of [0,i-1] where i ranges from [1, N]

    Time complexity: O(NlogK) Space complexity: O(k)

    DS from Java that can be used: PriorityQueue
     */

    private static int runs = 0;
    public static void main(String[] args) {
        int[] array1 = new int[]{10, 9, 8, 7, 4, 70, 60, 50};
        int[] array2 = new int[]{6, 5, 3, 2, 8, 10, 9};
//        testRunPQ(array1);

        testRun1(array1, 4);
        testRun1(array2, 3);
    }

    private static void testRun1(int[] array, int k) {
        System.out.println();
        System.out.println("Run-" + (++runs));
        System.out.println("Before");
        printArray(array);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // insert k+1 elements into heap
        for(int i=0; i < k+1; i++) {
            minHeap.add(array[i]);
        }

        // bubble up the elements in increasing order from the heap to array
        // add the elements from array to the heap
        int index = 0;
        for(int i = k+1; i< array.length; i++) {
            array[index++] = minHeap.poll();
            minHeap.add(array[i]);
        }

        // done with the elements in array.
        // bubble up the remaining elements from the heap to array
        while (!minHeap.isEmpty()) {
            array[index++] = minHeap.poll();
        }

        System.out.println("After");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for(int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void testRunPQ(int[] array) {

        System.out.println("Min heap");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int element : array) {
            minHeap.add(element);
        }

        for (Integer element : minHeap) {
            System.out.print(element + " ");
        }

        System.out.println();

        System.out.println("Peek Heap " + minHeap.peek());
        System.out.println("Poll Heap " + minHeap.poll());
        minHeap.add(22);


        for (Integer element : minHeap) {
            System.out.print(element + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("Max heap");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int element : array) {
            maxHeap.add(element);
        }

        for (Integer element : maxHeap) {
            System.out.print(element + " ");
        }

        System.out.println();

        System.out.println("Peek Heap " + maxHeap.peek());
        System.out.println("Poll Heap " + maxHeap.poll());
        maxHeap.add(22);

        for (Integer element : maxHeap) {
            System.out.print(element + " ");
        }

        System.out.println();
        // empty the heap by extracting max elements. This should be in descending order
        System.out.println("Extraction of Max Heap - Desc order");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }


}
