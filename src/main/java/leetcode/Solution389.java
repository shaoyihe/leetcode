package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/find-the-difference/description/
 *  389. Find the Difference
 * </pre>
 * on 2018/8/2.
 */
public class Solution389 {

    @Test
    public void test() {
        Assert.assertEquals('e', findTheDifference("abcd", "abcde"));
    }


    public char findTheDifference(String s, String t) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }

        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return (char) result;
    }

}
