package DSA.Heaps;

import java.util.*;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 5, 9, 21},
                {-1, 0},
                {-124, 81, 121},
                {3, 6, 12, 20, 150}};

        List<List<Integer>> lists = convertTo2DList(arrays);
        List<Integer> mergedList = mergeSortedArrays(lists);

        printList(mergedList);


    }

    private static void printList(List<Integer> mergedList) {
        for(int i : mergedList) {
            System.out.print(i + " ");
        }
    }

    private static List<List<Integer>> convertTo2DList(int[][] arrays) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int[] array : arrays) {
            List<Integer> list = new ArrayList<>();
            for(int i : array) {
                list.add(i);
            }
            lists.add(list);
        }

        return lists;
    }

    /*
    K + (N-K)(logK) = K + NlogK - KLogK
    */
    private static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> mergedList = new ArrayList<>();
        Queue<Element> minHeap = new PriorityQueue<>();

        // add first elements of arrays to heap
        // runs K times
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> current = arrays.get(i);
            minHeap.add(new Element(current.get(0), i, 1));
        }

        // runs N-K times
        while (!minHeap.isEmpty()) {
            Element minElement = minHeap.poll(); // O(logK)
            mergedList.add(minElement.getValue());

            // add next element in the array from which min is extracted
            List<Integer> array = arrays.get(minElement.arrayIndex);
            // don't add if ArrayIndexOOB
            if (minElement.nextIndex < array.size()) {
                int value = array.get(minElement.nextIndex);
                minHeap.add(new Element(value, minElement.arrayIndex, minElement.nextIndex + 1)); // O(logK)
            }
        }

        return mergedList;
    }

    static class Element implements Comparable<Element> {
        Integer value;

        int arrayIndex;
        int nextIndex;

        Element(Integer value, int arrayIndex, int nextIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.nextIndex = nextIndex;
        }

        @Override
        public int compareTo(Element element) {
            return this.value.compareTo(element.value);
        }

        public Integer getValue() {
            return value;
        }
    }
}
