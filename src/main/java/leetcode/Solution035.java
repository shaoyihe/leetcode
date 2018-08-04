package leetcode;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/search-insert-position/
 *  35. Search Insert Position
 * </pre>
 * on 2018/8/2.
 */
public class Solution035 {
    public static void main(String[] args) {
        Solution035 solution11 = new Solution035();
        int[] arr = {1, 3, 5, 6};
        System.err.println(solution11.searchInsert(arr, 2));
        System.err.println(solution11.searchInsert(arr, 7));
        System.err.println(solution11.searchInsert(arr, 0));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int from, to;
        for (from = 0, to = nums.length - 1; from <= to; ) {
            int middleIndex = (from + to) / 2;
            int midVal = nums[middleIndex];
            if (midVal == target) {
                return middleIndex;
            } else if (midVal < target) {
                from = middleIndex + 1;
            } else {
                to = middleIndex - 1;
            }
        }

        if (from < nums.length) {
            return nums[from] < target ? from + 1 : from;
        } else {
            return nums[to] < target ? to + 1 : to;
        }
    }

}
