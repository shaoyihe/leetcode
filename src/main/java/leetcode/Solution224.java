package leetcode;

import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/contains-duplicate-iii/description/
 *  220. Contains Duplicate III
 * </pre>
 * on 2018/8/2.
 */
public class Solution224 {
    public static void main(String[] args) {
        Solution224 solution11 = new Solution224();
        System.err.println(solution11.calculate("1+1"));
        System.err.println(solution11.calculate("(1+(4+5+2)-3)+(6+8)"));
    }


    public int calculate(String s) {
        Stack<Object> stack = new Stack<>();
        stack.push("/");

        char[] chars = s.toCharArray();
        int length = chars.length;
        Character lastOpr = '/';
        for (int i = 0; i < length; ++i) {
            char curChar = chars[i];
            if (curChar >= '0' && curChar <= '9') {
                //find number
                int from = i;
                for (; i + 1 < length && chars[i + 1] >= '0' && chars[i + 1] <= '9'; ++i) ;
                Integer num = toNum(chars, from, i);
                if (lastOpr == '+' || lastOpr == '-') {
                    Character opr = (Character) stack.pop();
                    Integer leftVal = (Integer) stack.pop();
                    stack.push(opr == '+' ? num + leftVal : leftVal - num);
                    lastOpr = '/';
                } else {
                    stack.push(num);
                }

            } else if (curChar == ')') {
                // compute
                Integer rightVal = (Integer) stack.pop();
                for (boolean hadPop = false; ; ) {
                    Character opr = (Character) stack.pop();
                    if (opr == '(') {
                        hadPop = true;
                    } else {
                        Integer leftVal = (Integer) stack.pop();
                        rightVal = opr == '+' ? rightVal + leftVal : leftVal - rightVal;

                        Object peek = stack.peek();
                        if (peek instanceof Character && (Character) stack.peek() == '(') {
                            if (hadPop) {
                                break;
                            }
                            hadPop = true;
                            stack.pop();
                        }
                    }

                    Object peek = stack.peek();
                    if (peek instanceof Character && ((Character) peek == '+' || (Character) peek == '-')) {

                    } else {
                        break;
                    }
                }
                stack.push(rightVal);
            } else if (curChar != ' ') {
                lastOpr = curChar;
                stack.push(curChar);
            }
        }
        return (int) stack.pop();
    }

    private int toNum(char[] chars, int from, int to) {
        int result = 0;
        for (int i = to, mul = 1; i >= from; --i, mul *= 10) {
            result += (chars[i] - '0') * mul;
        }
        return result;
    }

}
