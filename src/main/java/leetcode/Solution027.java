package leetcode;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *  26. Remove Duplicates from Sorted Array
 * </pre>
 * on 2018/8/2.
 */
public class Solution027 {
    public static void main(String[] args) {
        Solution027 solution11 = new Solution027();
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        System.err.println(solution11.removeElement(arr, 2));
        System.err.println(Arrays.toString(arr));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        int endLength = nums.length - 1;
        for (; endLength >= 0 && nums[endLength] == val; --endLength) ;

        int i = 0;
        for (; i <= endLength; ++i) {
            if (nums[i] == val) {
                nums[i] = nums[endLength--];
                for (; endLength >= 0 && nums[endLength] == val; --endLength) ;
            }
        }
        return i;
    }
}
