package leetcode;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/3sum-closest/description/
 *  16. 3Sum Closest
 * </pre>
 * on 2018/8/2.
 */
public class Solution016 {
    public static void main(String[] args) {
        Solution016 solution11 = new Solution016();
        System.err.println(solution11.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return Integer.MAX_VALUE;
        Arrays.sort(nums);

        int closetAbs = Integer.MAX_VALUE;
        int closet = -1;
        for (int i = 0; i < nums.length - 2; ++i) {
            int required = target - nums[i];
            for (int j = i + 1, t = nums.length - 1; j < t; ) {
                //计算相对偏差
                int deviation = nums[j] + nums[t] - required;
                if (Math.abs(deviation) < closetAbs) {
                    closetAbs = Math.abs(deviation);
                    closet = nums[j] + nums[t] + nums[i];
                }
                if (deviation > 0) {
                    --t;
                } else if (deviation == 0) {
                    return closet;
                } else {
                    ++j;
                }
            }
            for (; i < nums.length - 2 && nums[i + 1] == nums[i]; ++i) ;
        }
        return closet;
    }

}
