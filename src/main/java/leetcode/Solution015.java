package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/3sum/description/
 *  15. 3Sum
 * </pre>
 * on 2018/8/2.
 */
public class Solution015 {
    public static void main(String[] args) {
        Solution015 solution11 = new Solution015();
        System.err.println(solution11.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            int required = -nums[i];
            for (int j = i + 1, t = nums.length - 1; j < t; ) {
                int total = nums[j] + nums[t];
                if (total > required) {
                    for (; j < t && nums[t - 1] == nums[t]; --t) ;
                    --t;
                } else if (total == required) {
                    // found
                    result.add(Arrays.asList(nums[i], nums[j], nums[t]));
                    for (; j < t && nums[j + 1] == nums[j]; ++j) ;
                    ++j;

                    for (; j < t && nums[t - 1] == nums[t]; --t) ;
                    --t;
                } else {
                    for (; j < t && nums[j + 1] == nums[j]; ++j) ;
                    ++j;
                }
            }
            for (; i < nums.length - 2 && nums[i + 1] == nums[i]; ++i) ;
        }
        return result;
    }

}
