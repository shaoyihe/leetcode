package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/add-binary/description/
 *  67. Add Binary
 * </pre>
 * on 2018/8/2.
 */

public class Solution067 {

    @Test
    public void test() {
        Assert.assertEquals("100", addBinary("11", "1"));
        Assert.assertEquals("10101", addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        char[] result = new char[Math.max(a.length(), b.length())];
        int carryBit = 0;
        for (int a1 = a.length() - 1, a2 = b.length() - 1; a1 >= 0 || a2 >= 0; --a1, --a2) {
            int c1 = a1 < 0 ? 0 : (a.charAt(a1) - '0');
            int c2 = a2 < 0 ? 0 : (b.charAt(a2) - '0');
            result[Math.max(a1, a2)] = (char) ((c1 + c2 + carryBit) % 2 + (int) '0');

            if ((c1 + c2 + carryBit) / 2 > 0) carryBit = 1;
            else carryBit = 0;
        }
        return (carryBit > 0 ? "1" : "") + new String(result);
    }

}
