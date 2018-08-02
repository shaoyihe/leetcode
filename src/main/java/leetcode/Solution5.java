package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/longest-palindromic-substring
 *  5. Longest Palindromic Substring
 * </pre>
 * on 2018/8/2.
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.err.println(solution5.longestPalindrome("babad"));
        System.err.println(solution5.longestPalindrome("cbbd"));
        System.err.println(solution5.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }

    /**
     * o(n^2) 遍历
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        char[] c = s.toCharArray();
        int mostLength = 1;
        int subFrom = 0, subTo = 1;
        int length = c.length, halfLength = length / 2;
        for (int from = 0; from < length; ++from) {
            //优化:如果剩余长度的2倍小于已找到的长度 停止再寻找
            if ((length - from) * 2 < mostLength) break;
            //from为中心
            int i, t;
            for (i = from - 1, t = from + 1; i >= 0 && t < length && c[i] == c[t]; --i, ++t) ;
            ++i;
            if (t - i > mostLength) {
                mostLength = t - i;
                subFrom = i;
                subTo = t;
            }
            if (from + 1 < length) {
                //from from +1为中心
                if (c[from] == c[from + 1]) {
                    for (i = from - 1, t = from + 2; i >= 0 && t < length && c[i] == c[t]; --i, ++t) ;
                    ++i;
                    if (t - i > mostLength) {
                        mostLength = t - i;
                        subFrom = i;
                        subTo = t;
                    }
                }
            }
        }
        return new String(c, subFrom, mostLength);
    }
}
