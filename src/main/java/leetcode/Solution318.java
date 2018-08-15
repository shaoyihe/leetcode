package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 * 318. Maximum Product of Word Lengths
 * </pre>
 * on 2018/8/13.
 */
public class Solution318 {

    @Test
    public void test() {

        Assert.assertEquals(16, maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        Assert.assertEquals(4, maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        Assert.assertEquals(0, maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));

    }

    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;

        int maxLength = 0;
        int[] vals = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            int result = 0;
            for (int j = 0; j < words[i].length(); ++j) {
                result |= (1 << (words[i].charAt(j) - 'a'));
            }
            vals[i] = result;

            for (int j = 0; j < i; ++j) {
                if ((result & vals[j]) == 0 && words[j].length() * words[i].length() > maxLength) {
                    maxLength = words[j].length() * words[i].length();
                }
            }
        }
        return maxLength;
    }
}
