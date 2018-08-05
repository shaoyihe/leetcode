package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *  https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *  209. Minimum Size Subarray Sum
 * </pre>
 * on 2018/8/2.
 */
public class Solution209 {
    public static void main(String[] args) {
        Solution209 solution11 = new Solution209();
        System.err.println(solution11.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }


    /**
     * O(n)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int mostShort = 0;
        for (int i = 0, from = 0, sum = 0; i < nums.length; ++i) {
            int curSum = sum + nums[i];
            if (curSum >= s) {
                if (nums[i] >= s) return 1;
                // add from until most least s
                for (; curSum - nums[from] >= s; curSum -= nums[from++]) ;

                if (mostShort == 0 || i - from + 1 < mostShort) {
                    mostShort = i - from + 1;
                }
            }
            sum = curSum;
        }
        return mostShort;
    }

}
