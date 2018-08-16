package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/4sum/description/
 *  118. 4Sum
 * </pre>
 * on 2018/8/2.
 */
public class Solution018 {
    public static void main(String[] args) {
        Solution018 solution11 = new Solution018();
        System.err.println(solution11.fourSum(new int[]{0, 0, 0, 0}, 1));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return Collections.emptyList();
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            for (int x = i + 1; x < nums.length - 2; ++x) {
                int required = target - (nums[i] + nums[x]);
                for (int j = x + 1, t = nums.length - 1; j < t; ) {
                    int total = nums[j] + nums[t];
                    if (total > required) {
                        for (; j < t && nums[t - 1] == nums[t]; --t) ;
                        --t;
                    } else if (total == required) {
                        // found
                        result.add(Arrays.asList(nums[i], nums[x], nums[j], nums[t]));
                        for (; j < t && nums[j + 1] == nums[j]; ++j) ;
                        ++j;

                        for (; j < t && nums[t - 1] == nums[t]; --t) ;
                        --t;
                    } else {
                        for (; j < t && nums[j + 1] == nums[j]; ++j) ;
                        ++j;
                    }
                }
                for (; x < nums.length - 2 && nums[x + 1] == nums[x]; ++x) ;
            }
            for (; i < nums.length - 3 && nums[i + 1] == nums[i]; ++i) ;
        }
        return result;
    }

}
