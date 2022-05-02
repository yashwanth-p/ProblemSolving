package DSA.StringsAndArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortKingNames {

    // SORT ALPHABETICALLY
    // IF BOTH ARE SAME SORT BASED ON ROMAN NUMERALS
    public static void main(String[] args) {
        String[] names = {"Louis V", "Louis VI", "Louis X", "Peter I", "Peter X"};

        Arrays.sort(names, (o1, o2) -> {
            String[] names1 = o1.split(" ");
            String[] names2 = o2.split(" ");

            if(names1[0].equals(names2[0])) {
                return getNumericForRoman(names1[1]) - getNumericForRoman(names2[1]);
            }
            return names2[0].compareTo(names1[0]);
        });

        System.out.println(Arrays.toString(names));
    }

    private static int getNumericForRoman(String s) {
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);

        s = s.replaceAll("IV", "IIII").replaceAll("IX", "VIIII")
                .replaceAll("XL", "XXXX").replaceAll("XC", "LXXXX")
                .replaceAll("CD", "CCCC").replaceAll("CM", "DCCCC");

        int res = 0;
        for(char c : s.toCharArray()) {
            res += mapping.get(c);
        }

        return res;
    }
}
