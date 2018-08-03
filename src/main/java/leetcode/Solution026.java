package leetcode;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *  26. Remove Duplicates from Sorted Array
 * </pre>
 * on 2018/8/2.
 */
public class Solution026 {
    public static void main(String[] args) {
        Solution026 solution11 = new Solution026();
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.err.println(solution11.removeDuplicates(arr));
        System.err.println(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int totalLength = 1;
        for (int i = 1, lastValidPos = 0; i < nums.length; ++i) {
            if (nums[i] != nums[lastValidPos]) {
                lastValidPos++;
                if (i != lastValidPos) swap(nums, i, lastValidPos);
                totalLength++;
            }
        }
        return totalLength;
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
