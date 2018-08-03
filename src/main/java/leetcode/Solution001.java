package leetcode;

import java.util.*;

/**
 * <pre>
 *  https://leetcode.com/problems/two-sum/description/
 *  1. Two Sum
 * </pre>
 * on 2018/8/2.
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution11 = new Solution001();
        System.err.println(Arrays.toString(solution11.twoSum3(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            int numI = nums[i];
            for (int j = i + 1; j < length; ++j) {
                if (numI + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null) return null;
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; ++i) {
            int numI = nums[i];
            //忽略重复元素
            if (set.add(numI)) {
                for (int j = i + 1; j < length; ++j) {
                    if (numI + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        if (nums == null) return null;
        int length = nums.length;
        //当长度较小时用双重循环
        if (length < 8) return twoSum4(nums, target);
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            valToIndex.put(nums[i], i);
        }
        for (int i = 0; i < length; ++i) {
            Integer index = valToIndex.get(target - nums[i]);
            if (index != null && i != index) return new int[]{i, index};
        }
        return null;
    }

    private int[] twoSum4(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            int numI = nums[i];
            for (int j = i + 1; j < length; ++j) {
                if (numI + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
