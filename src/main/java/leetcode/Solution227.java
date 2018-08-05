package leetcode;

import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/basic-calculator-ii/description/
 *  227. Basic Calculator II
 * </pre>
 * on 2018/8/2.
 */
public class Solution227 {
    public static void main(String[] args) {
        Solution227 solution11 = new Solution227();
        System.err.println(solution11.calculate("3+2*2"));
        System.err.println(solution11.calculate("3+5 / 2 "));
    }


    public int calculate(String s) {
        Stack<Object> stack = new Stack<>();

        char[] chars = s.toCharArray();
        int length = chars.length;
        Character lastOpr = '0';
        for (int i = 0; i < length; ++i) {
            char curChar = chars[i];
            if (curChar >= '0' && curChar <= '9') {
                //find number
                int from = i;
                for (; i + 1 < length && chars[i + 1] >= '0' && chars[i + 1] <= '9'; ++i) ;
                Integer num = toNum(chars, from, i);
                if (lastOpr == '*' || lastOpr == '/') {
                    Character opr = (Character) stack.pop();
                    Integer leftVal = (Integer) stack.pop();
                    stack.push(eval(opr, leftVal, num));
                    lastOpr = '0';
                } else {
                    stack.push(num);
                }

            } else if (curChar != ' ') {
                lastOpr = curChar;
                stack.push(curChar);
            }
        }
        // opr + -
        int leftVal = (int) stack.get(0);
        int size = stack.size();
        for (int i = 1; i < size; ) {
            Character opr = (Character) stack.get(i++);
            leftVal = eval(opr, leftVal, (Integer) stack.get(i++));
        }

        return leftVal;
    }

    private int eval(Character opr, int left, int right) {
        if (opr == '*') {
            return left * right;
        }

        if (opr == '/') {
            return left / right;
        }

        if (opr == '+') {
            return left + right;
        }
        return left - right;
    }

    private int toNum(char[] chars, int from, int to) {
        int result = 0;
        for (int i = to, mul = 1; i >= from; --i, mul *= 10) {
            result += (chars[i] - '0') * mul;
        }
        return result;
    }

}
