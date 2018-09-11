package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/ugly-number/description/
 * 263. Ugly Number
 * </pre>
 * on 2018/09/11.
 */
public class Solution263 extends BaseTest {

    @Test
    public void test() {
        assertTrue(isUgly(6));
        assertTrue(isUgly(8));
        assertTrue(isUgly(8));
        assertFalse(isUgly(14));
    }

    public boolean isUgly(int num) {
        if (num < 1) return false;

        while (num != 1) {
            if (num % 2 == 0) num >>= 1;
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
            else return false;
        }
        return true;
    }
}
