package leetcode;

/**
 * <pre>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Longest Substring Without Repeating Characters
 * </pre>
 * on 2018/8/2.
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        assert solution3.lengthOfLongestSubstring("abcabcbb") == 3;
        assert solution3.lengthOfLongestSubstring("bbbbb") == 1;
        assert solution3.lengthOfLongestSubstring(" ") == 1;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        return lengthOfLongestSubstring(s.toCharArray(), 0, 0);
    }

    private int lengthOfLongestSubstring(char[] c, int from, int to) {
        if (to == c.length) return to - from;
        int subIndex = subIndexIfNotRepeat(c, from, to);
        //to是连续非重复子串一部分
        if (subIndex == -1) {
            return lengthOfLongestSubstring(c, from, to + 1);
        } else {
            // to 左部分长度
            int leftLength = to - from;
            //从subIndex+1开始的长度
            int rightLength = lengthOfLongestSubstring(c, subIndex + 1, to + 1);
            return Math.max(leftLength, rightLength);
        }
    }

    private int subIndexIfNotRepeat(char[] c, int from, int to) {
        for (int i = from; i < to; ++i) {
            if (c[i] == c[to]) {
                return i;
            }
        }
        return -1;
    }
}
