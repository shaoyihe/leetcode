package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
 *  873. Length of Longest Fibonacci Subsequence
 * </pre>
 * on 2018/8/27.
 */
public class Solution583 extends BaseTest {

    @Test
    public void test() {

    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) return word2 == null ? 0 : word2.length();
        if (word2 == null || word2.isEmpty()) return word1.length();

        int[][] lengthCache = new int[word1.length()][word2.length()];
        int[][] maxLengthPos = new int[word1.length()][word2.length()];
        for (int[] temp : maxLengthPos) Arrays.fill(temp, -1);


        for (int i = 0; i < word1.length(); ++i) {
            int beforeMaxLength = 0, beforeMaxLengthPos = -1;
            for (int j = 0; j < word2.length(); ++j) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (beforeMaxLength == 0) {

                    } else {

                    }
                } else {

                }
            }
        }
        return 0;
    }
}
