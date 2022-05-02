package DSA.Stacks;

import java.util.Stack;

public class CheckValidNumber {
    public static void main(String[] args) {
        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }

    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        int stars = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == '*') {
                stars++;
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    if (stars == 0) {
                        return false;
                    }
                    stars--;
                }
            }
        }

        while (stars > 0) {
            stars--;
            if (!stack.isEmpty()) {
                stack.pop();
                continue;
            }
            break;
        }

        return stack.isEmpty();


    }

    public int[] productExceptSelf(int[] nums) {
        long prod = 1;
        for(int i : nums) {
            prod = prod*i;
        }

        for(int i : nums) {
            nums[i] = nums[i]==0 ? (int) prod : (nums[i]==(int) prod ? nums[i] : (int) prod/nums[i]);
        }

        return nums;
    }
}
