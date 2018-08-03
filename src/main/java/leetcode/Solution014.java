package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/longest-common-prefix/description/
 *  14. Longest Common Prefix
 * </pre>
 * on 2018/8/2.
 */
public class Solution014 {
    public static void main(String[] args) {
        Solution014 solution11 = new Solution014();
        System.err.println(solution11.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        int totalSize;
        if (strs == null || (totalSize = strs.length) == 0) return "";
        if (totalSize == 1) return strs[0];

        StringBuilder result = new StringBuilder();
        boolean end = false;
        for (int index = 0, length = strs[0].length(); index < length; ++index) {
            char target = strs[0].charAt(index);
            boolean found = true;
            for (int j = 1; j < totalSize; ++j) {
                if (index < strs[j].length()) {
                    if (strs[j].charAt(index) != target) {
                        end = true;
                        found = false;
                        break;
                    }
                } else {
                    end = true;
                    found = false;
                    break;
                }
            }
            if (found) result.append(target);
            if (end) break;
        }
        return result.toString();
    }

}
