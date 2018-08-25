package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/climbing-stairs/description/
 *  70. Climbing Stairs
 * </pre>
 * on 2018/8/2.
 */
public class Solution070 extends BaseTest {

    @Test
    public void test() {
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
    }

    public int climbStairs(int n) {
        return climbStairs(n, new int[n + 1]);
    }

    private int climbStairs(int n, int[] cache) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (cache[n] > 0) return cache[n];
        return cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
    }
}
