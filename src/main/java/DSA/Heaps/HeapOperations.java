package DSA.Heaps;

public class HeapOperations {
    // Find Max, Del max, Insert, Delete, Increase a key

    public static void main(String[] args) {

        int[] array = new int[]{2, 3, 29, 5, 54, 32, 22, 16, 43};
        MaxHeap heap = new MaxHeap();
        heap.buildHeap(array);
        heap.printHeap();
        heap.buildHeap_Optimized(array);
        heap.printHeap();

        int max = heap.getMax();
        System.out.println("Maximum element: " + max);
        System.out.println();

        System.out.println("Deleting maximum element");
        int currentMax = heap.deleteMax();
        System.out.println("Updated Maximum element: " + currentMax);
        System.out.println();
        heap.printHeap();

        heap.insert(65);
        heap.printHeap();


        heap.increaseKey(5, 64); // this should be promoted up
        heap.printHeap();

        heap.deleteElement(32);
        heap.printHeap();

    }
}
