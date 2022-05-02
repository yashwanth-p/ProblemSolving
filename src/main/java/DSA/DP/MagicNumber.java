package DSA.DP;

import java.util.HashSet;
import java.util.Set;

public class MagicNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(7));
    }
}

class Solution {
    Set<Integer> memo = new HashSet<>();
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        if(memo.contains(n)) {
            return false;
        }
        int[] digitsArray = getDigitsArray(n);
        memo.add(n);
        return isHappy(sumOfSquaresArray(digitsArray));


    }

    int sumOfSquaresArray(int[] array) {
        int sum=0;
        for(int i : array) {
            sum+=(i*i);
        }
        return sum;
    }

    int[] getDigitsArray(int n) {
        String number = Integer.toString(n);
        int[] newArr = new int[number.length()];
        for(int i=0; i<newArr.length ; i++) {
            newArr[i] = number.charAt(i) - '0';
        }
        return newArr;

    }


}
