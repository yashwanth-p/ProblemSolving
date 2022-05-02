package DSA.Stacks;

import java.util.Stack;

public class BackSpaceCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompareUsingStacks("c##vnvr", "c##vn#nvr"));
    }

    private static boolean backspaceCompareUsingStacks(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
//
//        if (S.charAt(0) != '#')
//            s1.push(S.charAt(0));
//        if (T.charAt(0) != '#')
//            s2.push(T.charAt(0));
        for (int i = 0; i < S.length(); i++) {
            if (!s1.empty() && s1.peek() != '#' && S.charAt(i) == '#') {
                s1.pop();
            } else if (S.charAt(i) != '#') {
                s1.push(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (!s2.empty() && s2.peek() != '#' && T.charAt(i) == '#') {
                s2.pop();
            } else if (T.charAt(i) != '#') {
                s2.push(T.charAt(i));
            }
        }

        if (s1.size() != s2.size()) return false;
        while (!s1.empty() && !s2.empty()) {
            if (s1.pop() != s2.pop())
                return false;
        }
        return true;
    }
}
