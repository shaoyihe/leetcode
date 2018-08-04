package leetcode;

import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/search-in-rotated-sorted-array/
 *  33. Search in Rotated Sorted Array
 * </pre>
 * on 2018/8/2.
 */
public class Solution033 {
    public static void main(String[] args) {
        Solution033 solution11 = new Solution033();
        int[] arr = {5, 1, 3};
        System.err.println(solution11.search(arr, 5));
        System.err.println(solution11.search(arr, 3));
        System.err.println(solution11.search(arr, 1));

    }


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int[] result = new int[]{-1};
        loop(nums, 0, nums.length - 1, target, result);
        return result[0];
    }

    private void loop(int[] nums, int from, int to, int target, int[] result) {
        if (from <= to && result[0] == -1) {
            int middleIndex = (from + to) / 2;
            int midVal = nums[middleIndex];
            if (midVal == target) {
                result[0] = middleIndex;
            } else if (midVal > target) {
                loop(nums, from, middleIndex - 1, target, result);
                if (target <= nums[to]) {
                    loop(nums, middleIndex + 1, to, target, result);
                }
            } else {
                loop(nums, middleIndex + 1, to, target, result);
                if (nums[middleIndex] < nums[from]) {
                    loop(nums, from, middleIndex - 1, target, result);
                }
            }
        }
    }

}
