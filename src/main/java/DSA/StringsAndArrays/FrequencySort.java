package DSA.StringsAndArrays;

import java.util.*;

public class FrequencySort {
    /*
     given a list of integers, sort the elements(asc to desc)
        - based on frequency of elements, and then
        - based on the values
    */

    public static void main(String[] args) {
        int[] array = {9, 8, 5, 5, 5, 5, 1, 1, 1, 4, 4};

        int[] res = getSortedArray(array);
        System.out.println(Arrays.toString(res));

    }

    private static int[] getSortedArray(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int i : array) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(frequencyMap.keySet());
        list.sort((x, y) -> frequencyMap.get(x).equals(frequencyMap.get(y)) ? x - y : frequencyMap.get(x) - frequencyMap.get(y));

        int k=0;
        for(int x : list) {
            int count = frequencyMap.get(x);
            while(count-- > 0) {
                array[k++] = x;
            }
        }

        return array;
    }


}
