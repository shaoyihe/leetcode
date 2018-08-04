package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/plus-one/description/
 *  66. Plus One
 * </pre>
 * on 2018/8/2.
 */
public class Solution066 {
    public static void main(String[] args) {
        Solution066 solution11 = new Solution066();
        int[] result = new int[]{9, 9};
        System.err.println(Arrays.toString(solution11.plusOne(result)));
    }


    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;

        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0, result, 1, digits.length);
        result[0] = 1;
        return result;
    }

}
