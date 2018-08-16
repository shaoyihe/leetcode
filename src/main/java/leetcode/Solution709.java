package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *  80. Remove Duplicates from Sorted Array II
 * </pre>
 * on 2018/8/2.
 */
public class Solution709 {
    public static void main(String[] args) {
        Solution709 solution11 = new Solution709();
        int[] arr = {1, 1, 1, 2, 2, 3};

        System.err.println(solution11.toLowerCase("acADc"));
    }


    public String toLowerCase(String str) {
        if (str == null || str.isEmpty()) return str;

        char[] result = new char[str.length()];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            result[i] = (c >= 'A' && c <= 'Z') ? (char) ((c - 'A') + 'a') : c;
        }
        return new String(result);
    }

}
