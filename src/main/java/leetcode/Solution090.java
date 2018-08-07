package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/subsets/description/
 *  78. Subsets
 * </pre>
 * on 2018/8/2.
 */
public class Solution090 {
    public static void main(String[] args) {
        Solution090 solution090 = new Solution090();
        System.err.println(solution090.subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums != null) {
            Arrays.sort(nums);
            loop(result, new ArrayList<>(), 0, nums);
        }
        return result;
    }

    private void loop(List<List<Integer>> result, List<Integer> cur, int index, int[] nums) {
        if (index == nums.length) {
            result.add(cur);
        } else {
            int countRepeat = 1;
            for (int i = index + 1; i < nums.length && nums[index] == nums[i]; ++i, ++countRepeat) ;

            // resolve repeat num
            int nextIndex = index + countRepeat;
            for (int i = countRepeat; i >= 0; --i) {
                loop(result, i == 0 ? cur : addRepeatNum(cur, nums[index], i), nextIndex, nums);
            }

        }
    }

    private List<Integer> addRepeatNum(List<Integer> cur, int num, int repeatTimes) {
        List<Integer> result = new ArrayList<>(cur);
        for (int i = 0; i < repeatTimes; ++i) result.add(num);
        return result;
    }

}
