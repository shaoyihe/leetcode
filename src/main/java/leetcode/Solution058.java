package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *  80. Remove Duplicates from Sorted Array II
 * </pre>
 * on 2018/8/2.
 */
public class Solution058 {
    public static void main(String[] args) {
        Solution058 solution11 = new Solution058();
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.err.println(solution11.lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord(String s) {
        if (s == null) return 0;

        int maxLength = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                if (maxLength > 0) return maxLength;
            } else {
                ++maxLength;
            }
        }
        return maxLength;
    }

}
