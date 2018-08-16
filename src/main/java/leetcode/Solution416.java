package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *  https://leetcode.com/problems/target-sum/description/
 *  494. Target Sum
 * </pre>
 * on 2018/8/2.
 */
public class Solution416 {
    public static void main(String[] args) {
        Solution416 solution11 = new Solution416();
        int[] arr = {1, 1, 1, 1, 1};
        System.err.println(solution11.canPartition(new int[]{1, 5, 11, 5}));
        System.err.println(solution11.canPartition3(new int[]{1, 5, 11, 3}));
        System.err.println(solution11.canPartition(new int[]{1, 2, 3, 5}));
        System.err.println(solution11.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
        System.err.println(solution11.canPartition2(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
        System.err.println(solution11.canPartition3(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
    }


    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) return false;

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;
        boolean[][] cache = new boolean[nums.length + 1][sum / 2 + 1];
        return loop(nums, sum / 2, 0, cache);
    }

    private boolean loop(int[] nums, int target, int index, boolean[][] cache) {
        if (target == 0) return true;

        boolean result = cache[index][target];
        if (result) return false;

        if (index == nums.length || target < 0 || target < nums[index]) {
            result = false;
        } else {
            result = loop(nums, target, index + 1, cache) || loop(nums, target - nums[index], index + 1, cache);
        }
        cache[index][target] = !result;
        return result;
    }

    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length <= 1) return false;

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;

        Set<Integer> cache = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        for (int num : nums) {
            for (Integer integer : cache) {
                temp.add(integer + num);
            }
            cache.addAll(temp);
            cache.add(num);
            temp.clear();
        }
        return cache.contains(sum / 2);
    }

    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length <= 1) return false;

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;

        // see canPartition2
        boolean[] cache = new boolean[sum * 2 + 1];
        cache[0] = true;

        int total = 0;
        for (int num : nums) {
            total += num;
            // must from total -> num + 1 ,not num + 1 -> total ,because or it can use multi num
            for (int newSum = total; newSum >= num + 1; --newSum) {
                //if contain num
                cache[newSum] = cache[newSum] || cache[newSum - num];
            }
            // only contain num
            cache[num] = true;
        }
        return cache[sum / 2];
    }
}
