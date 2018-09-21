package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/candy/description/
 *  135. Candy
 * </pre>
 * on 2018/9/21.
 */
public class Solution135 extends BaseTest {

    @Test
    public void test() {
        assertEquals(4, candy(arr(1, 2, 2)));
        assertEquals(5, candy(arr(1, 0, 2)));
    }

    private final int UNKNOWN = 0;
    private final int ASC = 1;
    private final int DESC = 2;

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int[] cache = new int[ratings.length];
        int begin = 0, sortType = 0;
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                if (sortType == DESC) {
                    writeVal(cache, begin, i - 1, sortType);
                    begin = i - 1;
                }
                sortType = ASC;
            } else if (ratings[i] < ratings[i - 1]) {
                if (sortType == ASC) {
                    writeVal(cache, begin, i - 1, sortType);
                    begin = i - 1;
                }
                sortType = DESC;
            } else {
                writeVal(cache, begin, i - 1, sortType);
                sortType = UNKNOWN;
                begin = i;
            }
        }
        writeVal(cache, begin, ratings.length - 1, sortType);
        return Arrays.stream(cache).sum();
    }

    private void writeVal(int[] cache, int from, int to, int sortType) {
        if (ASC == sortType) {
            for (int i = from, val = 1; i <= to; ++i) {
                cache[i] = Math.max(cache[i], val++);
            }
        } else {
            for (int i = to, val = 1; i >= from; --i) {
                cache[i] = Math.max(cache[i], val++);
            }
        }
    }

}
