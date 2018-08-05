package leetcode;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/merge-sorted-array/description/
 *  88. Merge Sorted Array
 * </pre>
 * on 2018/8/2.
 */
public class Solution088 {
    public static void main(String[] args) {
        Solution088 solution11 = new Solution088();
        int[] num1 = {1, 2, 4, 5, 6, 0};
        int[] num2 = {3};
        solution11.merge(num1, 5, num2, 1);
        System.err.println(Arrays.toString(num1));
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        System.arraycopy(nums1, 0, nums1, n, m);
        for (int num1From = n, num2From = 0, pos = 0; ; ) {
            //end
            if (num1From == n + m) {
                System.arraycopy(nums2, num2From, nums1, pos, n - num2From);
                break;
            }

            if (num2From == n) {
                System.arraycopy(nums1, num1From, nums1, pos, n + m - num1From);
                break;
            }

            if (nums1[num1From] <= nums2[num2From]) {
                nums1[pos++] = nums1[num1From++];
            } else {
                nums1[pos++] = nums2[num2From++];
            }

        }
    }

}
