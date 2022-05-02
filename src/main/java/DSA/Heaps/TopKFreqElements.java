package DSA.Heaps;

import java.util.*;

public class TopKFreqElements {
    public static void main(String[] args) {
        int[] res = topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 3, 3, 5, 5, 5, 5, 5}, 2);
        System.out.println(Arrays.toString(res));
    }


    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int n : nums) {
            int freq = frequencyMap.getOrDefault(n, 0) + 1;
            frequencyMap.put(n, freq);
        }

        // maintain top k entries in the min heap based on the frequencies
        // if the heap overflows, remove the minimum element, this way you will always be keeping top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> topKFrequentElements =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            topKFrequentElements.add(entry);

            // this maintains the top k frequent rule
            if(topKFrequentElements.size() > k) {
                topKFrequentElements.poll();
            }
        }

        // now that I have to k frequent elements, in reverse order

        int[] result = new int[k];
        k--;
        for (Map.Entry<Integer, Integer> topKFrequentElement : topKFrequentElements) {
            result[k--] = topKFrequentElement.getKey();
        }

        return result;
    }
}


