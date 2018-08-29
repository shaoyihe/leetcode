package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/combination-sum-iv/description/
 *  377. Combination Sum IV
 * </pre>
 * on 2018/8/27.
 */
public class Solution410 extends BaseTest {

    @Test
    public void test() {
        assertEquals(18, splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] nums, int m) {
        return splitArray(nums, m, 0, new int[m + 1][nums.length]);
    }

    private int splitArray(int[] nums, int m, int index, int[][] cache) {
        if (m == 0) return 0;

        int minSum = Integer.MAX_VALUE;
        for (int i = index; i <= nums.length - m; ++i) {
            if (cache[m][i] == 0) {
                cache[m][i] = Math.max(sum(index, i, nums), splitArray(nums, m - 1, i + 1, cache));
            }
            minSum = Math.min(minSum, cache[m][i]);
        }
        return minSum;
    }

    private int sum(int i, int j, int[] nums) {
        int sum = 0;
        for (int t = i; t <= j; ++t) sum += nums[t];
        return sum;
    }
}
