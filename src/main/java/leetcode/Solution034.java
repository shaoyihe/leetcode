package leetcode;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *  34. Find First and Last Position of Element in Sorted Array
 * </pre>
 * on 2018/8/2.
 */
public class Solution034 {
    public static void main(String[] args) {
        Solution034 solution11 = new Solution034();
        int[] arr = {1};
        System.err.println(Arrays.toString(solution11.searchRange(arr, 1)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        // 二分查找
        int foundIndex = -1;
        for (int from = 0, to = nums.length - 1; from <= to; ) {
            int middle = (from + to) / 2;
            int middleVal = nums[middle];
            if (middleVal == target) {
                foundIndex = middle;
                break;
            } else if (middleVal < target) {
                from = middle + 1;
            } else {
                to = middle - 1;
            }
        }

        if (foundIndex == -1) return new int[]{-1, -1};
        int left = foundIndex, right = foundIndex;
        for (; left >= 0 && nums[left] == target; --left) ;
        for (; right < nums.length && nums[right] == target; ++right) ;

        return new int[]{left + 1, right - 1};
    }

}
