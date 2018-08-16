package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/integer-replacement/description/
 *  397. Integer Replacement
 * </pre>
 * on 2018/8/2.
 */
public class Solution397 {

    @Test
    public void test() {
        Assert.assertEquals(3, integerReplacement(8L));

        Assert.assertEquals(3, integerReplacement2(8L));
    }

    public int integerReplacement(long n) {
        if (n == 1) return 0;
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        } else {
            return 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1));
        }
    }

    public int integerReplacement2(long n) {
        return integerReplacement2(n, new HashMap<>());
    }

    private int integerReplacement2(long n, Map<Long, Integer> cache) {
        if (n == 1) return 0;
        Integer times = cache.get(n);
        if (times != null) return times;

        if (n % 2 == 0) {
            times = 1 + integerReplacement2(n / 2, cache);
        } else {
            times = 1 + Math.min(integerReplacement2(n - 1, cache), integerReplacement2(n + 1, cache));
        }
        cache.put(n, times);
        return times;
    }


}
