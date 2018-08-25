package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/integer-break/discuss/163169/simple-dp
 *  343. Integer Break
 * </pre>
 * on 2018/8/2.
 */
public class Solution343 extends BaseTest {

    @Test
    public void test() {
        assertEquals(1, integerBreak(2));
        assertEquals(4, integerBreak(4));
        assertEquals(36, integerBreak(10));
    }

    public int integerBreak(int n) {
        return integerBreak(n, new int[n + 1]);
    }

    private int integerBreak(int n, int[] memory) {
        if (n <= 2) return 1;
        if (memory[n] > 0) return memory[n];

        int max = 0;
        for (int i = 1; i < n; ++i) {
            max = Math.max(max, Math.max(i * integerBreak(n - i, memory), i * (n - i)));
        }
        return memory[n] = max;
    }

}
