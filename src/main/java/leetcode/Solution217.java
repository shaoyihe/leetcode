package leetcode;

import java.util.*;

/**
 * <pre>
 *  https://leetcode.com/problemset/all/
 *  217. Contains Duplicate
 * </pre>
 * on 2018/8/2.
 */
public class Solution217 {
    public static void main(String[] args) {
        Solution217 solution11 = new Solution217();
        System.err.println(solution11.containsDuplicate(new int[]{1, 2, 4}));
    }


    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;

        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

}
