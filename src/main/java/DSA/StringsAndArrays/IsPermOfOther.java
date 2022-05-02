package DSA.StringsAndArrays;

public class IsPermOfOther {

    public static void main(String[] args) {
        isOneStringPermOfOther("aabadef", "bcdefaa");
    }


    public static void isOneStringPermOfOther(String str1, String str2) {
        // base case check
        if (str1.length() != str2.length()) {
            System.out.println("FALSE: string lengths doesn't match");
            return;
        }

        int[] count = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            int x = str1.charAt(i);
            count[x]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            int x = str2.charAt(i);
            count[x]--;
        }
        // check if count array is reset
        for (int j : count) {
            if (j != 0) {
                System.out.println("FALSE");
                return;
            }
        }
        System.out.println("TRUE");

    }
}
