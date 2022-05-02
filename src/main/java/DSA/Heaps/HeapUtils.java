package DSA.Heaps;

import java.util.List;

public class HeapUtils {
    // Given array, create a max and min heap from it

    static int[] array = new int[]{2, 3, 29, 5, 54, 32, 22, 24, 13, 16, 43};

    public static MaxHeap getMaxHeap() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.buildHeap_Optimized(array);

        return maxHeap;
    }

    public static int[] getMinHeap() {
        return null;
    }

    public static void bubbleUpIfNeeded(int ci, List<Integer> maxHeap) {
        while (maxHeap.get(ci) > maxHeap.get(getParentIndex(ci))) {
            int pi = getParentIndex(ci);
            swap(ci, pi, maxHeap);
            ci = pi;
        }
    }

    public static int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public static int leftIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public static int rightIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public static void printHeap(List<Integer> heap) {
        System.out.println("Max Heap with Elements: " + heap.size());
        for (Integer integer : heap) {
            System.out.print(integer + " ");
        }
        System.out.println("\n");
    }

    public static void swap(int pi, int ci, List<Integer> heap) {
        int temp = heap.get(pi);
        heap.set(pi, heap.get(ci));
        heap.set(ci, temp);
    }
}
