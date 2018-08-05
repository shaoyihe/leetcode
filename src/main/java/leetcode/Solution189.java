package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/rotate-array/description/
 *  189. Rotate Array
 * </pre>
 * on 2018/8/2.
 */
public class Solution189 {
    public static void main(String[] args) {
        Solution189 solution090 = new Solution189();
        int[] nums = {1, 2, 3};
        solution090.rotate(nums, 2);
        System.err.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        k %= nums.length;
        if (k > 0) {
            int[] temp = Arrays.copyOfRange(nums, nums.length - k, nums.length);
            // right
            System.arraycopy(nums, 0, nums, k, nums.length - k);
            System.arraycopy(temp, 0, nums, 0, k);
        }
    }

}
