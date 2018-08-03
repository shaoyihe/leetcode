package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/generate-parentheses/description/
 *  22. Generate Parentheses
 * </pre>
 * on 2018/8/2.
 */
public class Solution022 {
    public static void main(String[] args) {
        Solution022 solution11 = new Solution022();

        System.err.println(solution11.generateParenthesis(3));
    }

    /**
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     *
     * @param n
     * @return
     */
        public List<String> generateParenthesis(int n) {
            char[] c = new char[n * 2];
            c[0] = '(';
            c[c.length - 1] = ')';
            List<String> result = new ArrayList<>();
            loop(c, 1, result, 1, 0, n - 1, n - 1);
            return result;
        }

        private void loop(char[] parenthesis, int index, List<String> result, int leftParenthesis, int rightParenthesis, int remainLeft, int remainRight) {
            if (index < parenthesis.length - 1) {
                //只能加左括号情绪
                if (leftParenthesis == rightParenthesis) {
                    parenthesis[index] = '(';
                    loop(parenthesis, index + 1, result, leftParenthesis + 1, rightParenthesis, remainLeft - 1, remainRight);
                } else {
                    //2种情况
                    if (remainLeft > 0) {
                        char[] left = Arrays.copyOf(parenthesis, parenthesis.length);
                        left[index] = '(';
                        loop(left, index + 1, result, leftParenthesis + 1, rightParenthesis, remainLeft - 1, remainRight);
                    }
                    if (remainRight > 0) {
                        parenthesis[index] = ')';
                        loop(parenthesis, index + 1, result, leftParenthesis, rightParenthesis + 1, remainLeft, remainRight - 1);
                    }
                }
            } else {
                result.add(new String(parenthesis));
            }
        }

}
