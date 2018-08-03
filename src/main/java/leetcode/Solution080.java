package leetcode;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *  80. Remove Duplicates from Sorted Array II
 * </pre>
 * on 2018/8/2.
 */
public class Solution080 {
    public static void main(String[] args) {
        Solution080 solution11 = new Solution080();
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.err.println(solution11.removeDuplicates(arr));
        System.err.println(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int totalLength = 1;
        boolean beyondRepeat2 = false;
        for (int i = 1, lastValidPos = 0; i < nums.length; ++i) {
            if (nums[i] != nums[lastValidPos] || !beyondRepeat2) {
                beyondRepeat2 = nums[i] == nums[lastValidPos];
                lastValidPos++;
                if (i != lastValidPos) nums[lastValidPos] = nums[i];
                totalLength++;
            }
        }
        return totalLength;
    }

}
