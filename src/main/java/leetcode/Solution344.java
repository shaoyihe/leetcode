package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/reverse-string/description/
 *  344. Reverse String
 * </pre>
 * on 2018/8/27.
 */
public class Solution344 extends BaseTest {

    @Test
    public void test() {
        assertEquals("A man, a plan, a canal: Panama", reverseString("amanaP :lanac a ,nalp a ,nam A"));
    }

    public String reverseString(String s) {
        if (s == null || s.length() < 2) return s;

        char[] result = s.toCharArray();
        int limit = result.length / 2;
        for (int i = 0, j = result.length - 1; i < limit; ++i, --j) {
            char temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        return new String(result);
    }

}
