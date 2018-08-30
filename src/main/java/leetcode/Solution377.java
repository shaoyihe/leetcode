package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/combination-sum-iv/description/
 *  377. Combination Sum IV
 * </pre>
 * on 2018/8/27.
 */
public class Solution377 extends BaseTest {

    @Test
    public void test() {
        assertEquals(7, combinationSum4(new int[]{1, 2, 3}, 4));

        assertEquals(181997601, combinationSum4(new int[]{1, 2, 3}, 32));

        assertEquals(181997601, combinationSum5(new int[]{1, 2, 3}, 32));
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return combinationSum(nums, target);
    }

    private int combinationSum(int[] nums, int target) {
        if (target == 0) return 1;

        int total = 0;
        for (int i = 0; i < nums.length && target >= nums[i]; ++i) {
            total += combinationSum(nums, target - nums[i]);
        }
        return total;
    }

    public int combinationSum5(int[] nums, int target) {
        Arrays.sort(nums);
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);
        return combinationSum(nums, target, cache);
    }

    private int combinationSum(int[] nums, int target, int[] cache) {
        if (target == 0) return 1;
        if (cache[target] >= 0) return cache[target];

        int total = 0;
        for (int i = 0; i < nums.length && target >= nums[i]; ++i) {
            total += combinationSum(nums, target - nums[i], cache);
        }
        return cache[target] = total;
    }

}
