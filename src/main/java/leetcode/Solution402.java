package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/remove-k-digits/description/
 * 402. Remove K Digits
 * </pre>
 * on 2018/8/13.
 */
public class Solution402 extends BaseTest {

    @Test
    public void test() {
        assertEquals("1219", removeKdigits("1432219", 3));
        assertEquals("200", removeKdigits("10200", 1));
        assertEquals("0", removeKdigits("10", 1));
        assertEquals("11", removeKdigits("112", 1));
    }

    public String removeKdigits(String num, int k) {
        if (num == null || num.isEmpty() || k == num.length()) return "0";
        final int originK = k;
        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));

        int index;
        for (index = 1; index < num.length() && k > 0; ++index) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(index)) {
                stack.pop();
                --k;
            }
            stack.push(num.charAt(index));
        }


        char[] result = new char[num.length() - originK];
        int resultIndex = 0;
        int leadNotZero = -1;
        for (int i = 0; i < stack.size() & resultIndex < result.length; ++i) {
            result[resultIndex] = stack.get(i);
            if (leadNotZero == -1 && result[resultIndex] != '0') {
                leadNotZero = resultIndex;
            }
            ++resultIndex;
        }
        for (; index < num.length() && resultIndex < result.length; ++index) {
            result[resultIndex] = num.charAt(index);
            if (leadNotZero == -1 && result[resultIndex] != '0') {
                leadNotZero = resultIndex;
            }
            ++resultIndex;
        }

        return leadNotZero >= 0 ? new String(result, leadNotZero, result.length - leadNotZero) : "0";
    }
}
