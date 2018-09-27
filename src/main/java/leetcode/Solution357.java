package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *  357. Count Numbers with Unique Digits
 * </pre>
 * on 2018/9/26.
 */
public class Solution357 extends BaseTest {

    @Test
    public void test() {
        assertEquals(91, countNumbersWithUniqueDigits(2));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0) return 1;
        if (n > 10) n = 10;

        int result = 10;
        int[] cache = new int[]{9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 2; i <= n; ++i) {
            int size = 1;
            for (int j = i, length = 0; j >= 1; --j) {
                size *= cache[length++];
            }
            result += size;
        }
        return result;
    }

}
