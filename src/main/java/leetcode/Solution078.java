package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/subsets/description/
 *  78. Subsets
 * </pre>
 * on 2018/8/2.
 */
public class Solution078 {
    public static void main(String[] args) {
        Solution078 solution078 = new Solution078();
        System.err.println(solution078.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums != null) loop(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void loop(List<List<Integer>> result, List<Integer> cur, int index, int[] nums) {
        if (index == nums.length) {
            result.add(cur);
        } else {
            // contain index
            List<Integer> newCur = new ArrayList<>(cur);
            newCur.add(nums[index]);
            loop(result, newCur, index + 1, nums);

            //not contain index
            loop(result, cur, index + 1, nums);
        }
    }

}
