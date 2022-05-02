package DSA.Heaps;

import java.util.ArrayList;
import java.util.List;

import static DSA.Heaps.HeapUtils.*;

public class MaxHeap {
    List<Integer> maxHeap = new ArrayList<>();

    public void buildHeap(int[] elements) {
        maxHeap.clear();
        for (int element : elements) {
            insert(element);
        }
    }

    public void buildHeap_Optimized(int[] elements) {
        fillElementsToList(elements);
        // max_heapify from the end (basically, from first non leaf node as there is no need for leaves to be heapified)
        // heapify will take care of leaves
        for(int i = maxHeap.size() - 1; i>=0; i--) {
            maxHeapify(i);
        }
    }

    private void fillElementsToList(int[] elements) {
        maxHeap.clear();
        for (int i : elements) {
            maxHeap.add(i);
        }
    }

    // O(height)
    public void insert(int element) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(element);
            return;
        }
        maxHeap.add(element);
        int ci = lastIndex();

        bubbleUpIfNeeded(ci, maxHeap);
    }

    public void deleteIndex(int currentIndex) {
        if (isLeaf(currentIndex)) {
            maxHeap.remove(lastIndex());
            return;
        }
        swap(lastIndex(), currentIndex, maxHeap);
        maxHeap.set(lastIndex(), Integer.MIN_VALUE);
        maxHeapify(currentIndex);
        maxHeap.remove(lastIndex());
    }

    public void deleteElement(int element) {
        int currentIndex = maxHeap.indexOf(element); // O(N)
        deleteIndex(currentIndex);
    }

    // restore the Max heap nature for this tree (recursively)
    private void maxHeapify(int index) {
        // base condition
        if (isLeaf(index)) {
            return;
        }

        // node violates the max-heap node rule (node.left < node > node.right)
        int node = maxHeap.get(index);
        int li = leftIndex(index);
        int ri = rightIndex(index);
        int left = maxHeap.get(li);
        int right = maxHeap.get(ri);
        if (node < left || node < right) {
            int maxIndex = getMaximumValueIndex(li, ri);
            swap(maxIndex, index, maxHeap);
            maxHeapify(maxIndex);
        }

    }

    private int getMaximumValueIndex(int i1, int i2) {
        return maxHeap.get(i1) > maxHeap.get(i2) ? i1 : i2;
    }

    private int lastIndex() {
        return maxHeap.size() - 1;
    }

    private boolean isLeaf(int index) {
        // there is no right and left AND right child
        return isOutOfBounds(leftIndex(index)) && isOutOfBounds(rightIndex(index));
    }

    private boolean isOutOfBounds(int index) {
        return index >= maxHeap.size();
    }

    public int getMax() {
        return maxHeap.get(0);
    }

    public int deleteMax() {
        deleteIndex(0);
        return getMax();
    }

    public void increaseKey(int keyIndex, int increment) {
        if(isOutOfBounds(keyIndex)) {
            return;
        }
        int current = maxHeap.get(keyIndex);
        maxHeap.set(keyIndex, current+increment);
        bubbleUpIfNeeded(keyIndex, maxHeap);
    }

    public void printHeap() {
        HeapUtils.printHeap(maxHeap);
    }

    public List<Integer> getAsArray() {
        return new ArrayList<>(maxHeap);
    }
}
