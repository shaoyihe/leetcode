package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-swap/
 *  670. Maximum Swap
 * </pre>
 * on 2018/8/2.
 */
public class Solution670 {
    @Test
    public void test() {
        Assert.assertEquals(7236, maximumSwap(2736));
        Assert.assertEquals(9973, maximumSwap(9973));
        Assert.assertEquals(9913, maximumSwap(1993));
    }


    public int maximumSwap(int num) {
        if (num <= 10) return num;

        char[] numChars = Integer.toString(num).toCharArray();
        for (int i = 0, lastChar = '9'; i < numChars.length; ++i) {
            char cur = numChars[i];
            if (cur == lastChar) continue;

            char curMax = cur;
            int curMaxIndex = i;
            for (int j = i + 1; j < numChars.length; ++j) {
                if (numChars[j] > curMax || (numChars[j] == curMax && curMax != cur)) {
                    curMax = numChars[j];
                    curMaxIndex = j;
                }
            }
            if (curMax != cur) {
                //found swap
                numChars[curMaxIndex] = cur;
                numChars[i] = curMax;
                break;
            } else {
                lastChar = cur;
            }
        }
        return Integer.parseInt(new String(numChars));
    }

}
