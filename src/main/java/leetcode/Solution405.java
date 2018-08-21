package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 *  405. Convert a Number to Hexadecimal
 * </pre>
 * on 2018/8/2.
 */
public class Solution405 {

    @Test
    public void test() {
        Assert.assertEquals("1a", toHex(26));
        Assert.assertEquals("ffffffff", toHex(-1));

        Assert.assertEquals("1a", toHex2(26));
        Assert.assertEquals("ffffffff", toHex2(-1));
    }

    public String toHex(int num) {
        if (num == 0) return "0";

        boolean negative = false;
        if (num < 0) {
            negative = true;
            num -= Integer.MIN_VALUE;
        }
        String result = "";
        for (; num > 0; ) {
            int cur = 0;
            for (int j = 0; j < 4 && num > 0; ++j, num >>= 1) {
                if ((num & 1) == 1) cur |= 1 << j;
            }
            if (negative && result.length() == 7) cur |= 1 << 3;
            result = (cur < 10 ? (char) (cur + '0') : (char) (cur - 10 + 'a')) + result;
        }
        if (negative && result.length() < 8) {
            //make up 0 to length 7
            while (result.length() < 7) result = "0" + result;
            result = "8" + result;
        }
        return result;
    }

    public String toHex2(int num) {
        if (num == 0) return "0";

        char[] result = new char[8];
        int to = result.length - 1;
        for (; num != 0; ) {
            int cur = 0;
            for (int j = 0; j < 4 && num != 0; ++j, num >>>= 1) {
                if ((num & 1) == 1) cur |= 1 << j;
            }
            result[to--] = (char) (cur < 10 ? (cur + '0') : (cur - 10 + 'a'));
        }

        return new String(result, to + 1, 7 - to);
    }

}
