package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/jump-game/description/
 *  55. Jump Game
 * </pre>
 * on 2018/8/2.
 */
public class Solution055 {

    @Test
    public void test() {
        Assert.assertTrue(canJump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(canJump(new int[]{3, 2, 1, 0, 4}));

        Assert.assertTrue(canJump2(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(canJump2(new int[]{3, 2, 1, 0, 4}));

        Assert.assertTrue(canJump3(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(canJump3(new int[]{3, 2, 1, 0, 4}));
    }


    public boolean canJump(int[] nums) {
        boolean[] canReached = new boolean[nums.length];
        Arrays.fill(canReached, true); // true no point,jut use false
        return canJump(nums, 0, canReached);
    }

    private boolean canJump(int[] nums, int index, boolean[] canReached) {
        if (index == nums.length) return true;
        if (!canReached[index]) return false;
        if (index + nums[index] >= nums.length - 1) return true;

        for (int i = 1; i <= nums[index]; ++i) {
            if (canJump(nums, index + i, canReached)) {
                return true;
            }
        }
        return canReached[index] = false;
    }

    public boolean canJump2(int[] nums) {
        boolean[] canReached = new boolean[nums.length];
        canReached[canReached.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; --i) {
            if (i + nums[i] >= nums.length - 1) {
                canReached[i] = true;
                continue;
            }

            for (int j = 1; j <= nums[i]; ++j) {
                if (canReached[i + j]) {
                    canReached[i] = true;
                    break;
                }
            }
        }
        return canReached[0];
    }


    public boolean canJump3(int[] nums) {
        int canReachedMinIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (i + nums[i] >= canReachedMinIndex) {
                canReachedMinIndex = i;
            }
        }
        return canReachedMinIndex == 0;
    }


}
