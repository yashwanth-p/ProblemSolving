package DSA.Misc;

import java.util.*;

public class VanityCodeNumbers {
    //  https://leetcode.com/discuss/interview-question/864424/twilio-oa-university-recruiting-for-summer-2021-swe

    public static void main(String[] args) {
        String[] vanityCodes = {"TWLO", "CODE", "HTCH"};
        String[] mobileNumbers = {"+14157088956", "+65799378940575"};

        List<String> list = getVanityMobileNumbers(mobileNumbers, vanityCodes);

        System.out.println(list);
    }

    private static List<String> getVanityMobileNumbers(String[] mobileNumbers, String[] vanityCodes) {
        Map<Character, Integer> numPad = new HashMap<>();
        numPad.put('A', 2);
        numPad.put('B', 2);
        numPad.put('C', 2);
        numPad.put('D', 3);
        numPad.put('E', 3);
        numPad.put('F', 3);
        numPad.put('G', 4);
        numPad.put('H', 4);
        numPad.put('I', 4);
        numPad.put('J', 5);
        numPad.put('K', 5);
        numPad.put('L', 5);
        numPad.put('M', 6);
        numPad.put('N', 6);
        numPad.put('O', 6);
        numPad.put('P', 7);
        numPad.put('Q', 7);
        numPad.put('R', 7);
        numPad.put('S', 7);
        numPad.put('T', 8);
        numPad.put('U', 8);
        numPad.put('V', 8);
        numPad.put('W', 9);
        numPad.put('X', 9);
        numPad.put('Y', 9);
        numPad.put('Z', 9);


        List<String> result = new ArrayList<>();
        for (String code : vanityCodes) {
            String vanityNumber = getNumberForCode(code, numPad);
            for (String mobileNum : mobileNumbers) {
                if (mobileNum.contains(vanityNumber))
                    result.add(mobileNum);
            }
        }
        return result;
    }

    private static String getNumberForCode(String code, Map<Character, Integer> numPad) {
        StringBuilder codeToNumber = new StringBuilder();
        for (Character c : code.toCharArray()) {
            codeToNumber.append(numPad.get(c));
        }
        return codeToNumber.toString();
    }

}
