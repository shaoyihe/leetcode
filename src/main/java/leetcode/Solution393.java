package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/utf-8-validation/description/
 *  393. UTF-8 Validation
 * </pre>
 * on 2018/8/2.
 */
public class Solution393 {
    @Test
    public void test() {
        Assert.assertTrue(validUtf8(new int[]{197, 130, 1}));
        Assert.assertFalse(validUtf8(new int[]{235, 140, 4}));
    }

    private static int utf8Bit3 = (1 << 2 | 1 << 1);
    private static int utf8Bit4 = (1 << 3 | 1 << 2 | 1 << 1);
    private static int utf8Bit5 = (1 << 4 | 1 << 3 | 1 << 2 | 1 << 1);

    public boolean validUtf8(int[] data) {
        return validUtf8(data, 0);
    }

    private boolean validUtf8(int[] data, int index) {
        if (index == data.length) return true;

        int cur = data[index];
        //0xxxxxxx
        if ((cur & 1 << 7) == 0) {
            return validUtf8(data, index + 1);
        } else {
            //110xxxxx 10xxxxxx
            if (((cur >>> 5) ^ utf8Bit3) == 0) {
                if (checkOtherBit(data, index + 1, index + 1)) return validUtf8(data, index + 2);
                return false;
            }
            //1110xxxx 10xxxxxx 10xxxxxx
            if (((cur >>> 4) ^ utf8Bit4) == 0) {
                if (checkOtherBit(data, index + 1, index + 2)) return validUtf8(data, index + 3);
                return false;
            }
            //11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
            if (((cur >>> 3) ^ utf8Bit5) == 0) {
                if (checkOtherBit(data, index + 1, index + 3)) return validUtf8(data, index + 4);
                return false;
            }
            return false;
        }
    }

    private boolean checkOtherBit(int[] data, int from, int to) {
        if (to >= data.length) return false;
        for (int i = from; i <= to; ++i) {
            if (((data[i] >>> 6) ^ 2) != 0) return false;
        }
        return true;
    }
}
