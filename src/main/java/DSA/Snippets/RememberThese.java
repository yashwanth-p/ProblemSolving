package DSA.Snippets;

import java.util.*;

public class RememberThese {

    void rememberThese() {
        // maximum heap
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Heap with comparable objects


        // Sort a 2D array of Pairs based on an element

        // put the keys of map into a list in sorted order (based on some criteria)
        // option:1
        Map<Integer, Integer> map = new HashMap<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        int x = list.get(1).getValue();

        //
//        PriorityQueue<Map.Entry> pq = new PriorityQueue<>(Map.Entry.comparingByValue());


        // create a frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        int[] nums = new int[]{1, 2, 3, 4};
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
    }
}
