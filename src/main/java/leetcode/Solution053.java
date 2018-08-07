package leetcode;

import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-subarray/description/
 *  53. Maximum Subarray
 * </pre>
 * on 2018/8/2.
 */
public class Solution053 {
    public static void main(String[] args) {
        Solution053 solution11 = new Solution053();
        System.err.println(solution11.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1, consMaxSum = maxSum; i < nums.length; ++i) {
            consMaxSum = Math.max(consMaxSum + nums[i], nums[i]);
            if (consMaxSum > maxSum) {
                maxSum = consMaxSum;
            }
        }
        return maxSum;
    }

}
