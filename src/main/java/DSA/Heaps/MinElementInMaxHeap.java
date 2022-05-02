package DSA.Heaps;

import java.util.List;

public class MinElementInMaxHeap {
    /*
       max and min heaps
    */

    public static void main(String[] args) {
        MaxHeap heap = HeapUtils.getMaxHeap();
        List<Integer> maxHeapArray = heap.getAsArray();
        // Minimum element in max heap can always be found only in the leaf elements.
        // Reason: every internal element obeys max-heap property i.e. they are greater than its children

        heap.printHeap();
        int startIndex = maxHeapArray.size()/2; // index of first leaf node
        System.out.println("First leaf node " + maxHeapArray.get(startIndex));
        int min = findMinElement(maxHeapArray,startIndex);
        System.out.println("Minimum element in heap: " + min);
    }

    private static int findMinElement(List<Integer> maxHeapArray, int startIndex) {
        int minElement = Integer.MAX_VALUE;
        for(int i : maxHeapArray) {
            minElement = Math.min(minElement, i);
        }
        return minElement;
    }

}
