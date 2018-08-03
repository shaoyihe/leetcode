package leetcode;

import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/valid-parentheses/description/
 * 20 Valid Parentheses
 * </pre>
 * on 2018/8/2.
 */
public class Solution020 {
    public static void main(String[] args) {
        Solution020 solution020 = new Solution020();
        System.err.println(solution020.isValid("()[]{}")); //true
        System.err.println(solution020.isValid("(([]){})")); //true
        System.err.println(solution020.isValid("([))")); //false
    }

    public boolean isValid(String s) {
        if (s == null) return false;
        char[] sChar = s.toCharArray();
        if (sChar.length == 0) return true;
        if (sChar.length % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : sChar) {
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                if (!isPair(stack.pop(), c)) return false;

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    private boolean isPair(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '{' && right == '}') ||
                (left == '[' && right == ']');
    }
}
