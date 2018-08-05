package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/target-sum/description/
 *  494. Target Sum
 * </pre>
 * on 2018/8/2.
 */
public class Solution494 {
    public static void main(String[] args) {
        Solution494 solution11 = new Solution494();
        int[] arr = {1, 1, 1, 1, 1};
        System.err.println(solution11.findTargetSumWays(arr, 3));
    }


    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        return loop(nums, S, 0);
    }

    private int loop(int[] nums, int target, int index) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        } else {
            return loop(nums, target + nums[index], index + 1) +
                    loop(nums, target - nums[index], index + 1);
        }
    }


}
