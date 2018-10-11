package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *  746. Min Cost Climbing Stairs
 * </pre>
 * on 2018/10/10.
 */
public class Solution746 extends BaseTest {

    @Test
    public void test() {
        assertEquals(15, minCostClimbingStairs(arr(10, 15, 20)));
        assertEquals(6, minCostClimbingStairs(arr(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        return Math.min(minCostClimbingStairs(cost, cache, 0), minCostClimbingStairs(cost, cache, 1));
    }

    private int minCostClimbingStairs(int[] cost, int[] cache, int index) {
        if (index >= cost.length) return 0;
        if (cache[index] > 0) return cache[index];

        return cache[index] = cost[index] + Math.min(minCostClimbingStairs(cost, cache, index + 1), minCostClimbingStairs(cost, cache, index + 2));
    }

}
