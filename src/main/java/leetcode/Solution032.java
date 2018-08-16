package leetcode;

import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/longest-valid-parentheses/description/
 *  32. Longest Valid Parentheses
 * </pre>
 * on 2018/8/2.
 */
public class Solution032 {
    public static void main(String[] args) {
        Solution032 solution11 = new Solution032();
        int[] arr = {1, 5, 1};
        System.err.println(solution11.longestValidParentheses(")()())(()())"));
        System.err.println(solution11.longestValidParentheses3(")()())(()())"));
        System.err.println(solution11.longestValidParentheses("(()("));
        System.err.println(solution11.longestValidParentheses2("())"));
        System.err.println(solution11.longestValidParentheses2("()"));
        System.err.println(solution11.longestValidParentheses3("(()"));
    }


    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;

        Stack<Character> stack = new Stack<>();
        Stack<Integer> position = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (c == '(') {
                stack.push(c);
                position.push(i);
            } else {
                //reset most length
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    position.pop();
                } else {
                    stack.push(c);
                    position.push(i);
                }
            }
        }

        int maxLength = 0, lastPos = chars.length;
        while (!position.isEmpty()) {
            int notConsumePos = position.pop();
            int curLength = lastPos - notConsumePos - 1;
            if (curLength > maxLength) {
                maxLength = curLength;
            }
            lastPos = notConsumePos;
        }
        return Math.max(maxLength, lastPos);
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() <= 1) return 0;

        Stack<Integer> position = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (c == '(') {
                position.push(i);
            } else {
                //reset most length
                if (!position.isEmpty() && chars[position.peek()] == '(') {
                    position.pop();
                } else {
                    position.push(i);
                }
            }
        }

        int maxLength = 0, lastPos = chars.length;
        while (!position.isEmpty()) {
            int notConsumePos = position.pop();
            int curLength = lastPos - notConsumePos - 1;
            if (curLength > maxLength) {
                maxLength = curLength;
            }
            lastPos = notConsumePos;
        }

        return Math.max(maxLength, lastPos);
    }

    public int longestValidParentheses3(String s) {
        if (s == null || s.length() <= 1) return 0;

        int maxLength = 0;
        Stack<Integer> position = new Stack<>();
        position.push(-1);
        for (int i = 0, length = s.length(); i < length; ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                position.push(i);
            } else {
                //reset most length
                if (position.size() > 1 && s.charAt(position.peek()) == '(') {
                    position.pop();

                    int peekPos = position.peek();
                    if (i - peekPos > maxLength) maxLength = i - peekPos;
                } else {
                    position.push(i);
                }
            }
        }
        return maxLength;
    }

}
