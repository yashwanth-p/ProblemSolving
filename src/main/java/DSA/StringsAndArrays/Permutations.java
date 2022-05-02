package DSA.StringsAndArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    private static final List<String> permutations = new ArrayList<>();

    public static void main(String[] args) {
        printPermutations("abc", new LinkedList<>());

        System.out.println();

        permutations.clear();
        printPermutations("1234", new LinkedList<>());
        List<String> copy = new ArrayList<>(permutations);
        Collections.sort(copy);
        validate(copy);

    }

    private static void validate(List<String> copy) {
        for(int i = 0; i< Permutations.permutations.size(); i++) {
            if(!copy.get(i).equals(Permutations.permutations.get(i))) {
                System.out.println("Generated permutations are NOT in sorted order");
                return;
            }
        }
        // only possible if the original string is sorted (ex 1234) instead of 1243
        System.out.println("Generated permutations are in sorted order");
    }

    private static void printPermutations(String str, LinkedList<Character> permutation) {
        // if the string is exhausted print the current formed permutation
        if(str.isEmpty()) {
            print(permutation);
            permutations.add(getString(permutation));
            return;
        }

        for(int i=0; i< str.length(); i++) {
            // fix a character and do the same for every other char
            char current = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permutation.addLast(current);
            printPermutations(remaining, permutation);
            permutation.removeLast(); // this is needed inorder to backtrack

        }

    }

    private static String getString(LinkedList<Character> permutation) {
        StringBuilder result = new StringBuilder(permutation.size());
        permutation.forEach(result::append);
        return result.toString();
    }

    private static void print(List<Character> permutation) {
        permutation.forEach(System.out::print);
        System.out.println();
    }
}
