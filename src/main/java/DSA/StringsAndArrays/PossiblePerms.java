package DSA.StringsAndArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossiblePerms {

    public static void main(String[] args) {
        String largeString = "cbabcacabca";
        String smallString = "abc";
        List<String> possiblePerms = getAllPermutations(largeString, smallString);
        printList(possiblePerms);

        System.out.println("apple".compareTo("banana"));
        possiblePerms.forEach(System.out::println);
    }

    private static void printList(List<String> possiblePerms) {
        for (String s : possiblePerms) {
            System.out.println(s);
        }
    }

    // O(n-m + m) = O(n)
    private static List<String> getAllPermutations(String largeString, String smallString) {
        List<String> res = new ArrayList<>();

        int n = largeString.length();
        int m = smallString.length();
        Map<Character, Integer> base = getFrequencyCount(smallString); // O(m)
        Map<Character, Integer> temp = getFrequencyCount(largeString, m); // O(m)
        if (isPermutation(base, temp)) {
            res.add(largeString.substring(0, m));
        }
        // O(n-m)
        for (int i = 1; i <= n - m; i++) {
            int lastIndex = i + m - 1;
            int prevIndex = i - 1;
            char last = largeString.charAt(lastIndex);
            char prev = largeString.charAt(prevIndex);

            reduceCount(prev, temp); // O(1)
            incrementCOunt(last, temp); // O(1)

            if (isPermutation(base, temp, last, prev)) {
                res.add(largeString.substring(i, lastIndex + 1));
            }

        }
        return res;
    }

    // O(m)
    private static boolean isPermutation(Map<Character, Integer> base, Map<Character, Integer> temp) {
        for (Character c : base.keySet()) {
            if (!temp.get(c).equals(base.get(c))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPermutation(Map<Character, Integer> base, Map<Character, Integer> temp, char last, char prev) {
        return base.get(last).equals(temp.get(last)) && base.get(prev).equals(temp.get(prev));
    }

    private static void incrementCOunt(char k, Map<Character, Integer> temp) {
        int v = temp.get(k);
        temp.put(k, ++v);
    }

    private static void reduceCount(char k, Map<Character, Integer> temp) {
        int v = temp.get(k);
        temp.put(k, --v);

    }

    private static Map<Character, Integer> getFrequencyCount(String largeString, int m) {
        return getFrequencyCount(largeString.substring(0, m));
    }

    private static Map<Character, Integer> getFrequencyCount(String smallString) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : smallString.toCharArray()) {
            int v = frequency.get(c) == null ? 1 : frequency.get(c) + 1;
            frequency.put(c, v);
        }
        return frequency;
    }
}
