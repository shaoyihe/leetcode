package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * <pre>
 *  https://leetcode.com/problems/ugly-number-ii/description/
 * 264. Ugly Number II
 * </pre>
 * on 2018/09/11.
 */
public class Solution264 extends BaseTest {

    @Test
    public void test() {
        assertEquals(12, nthUglyNumber(10));
        assertEquals(1399680000, nthUglyNumber(1600));
    }

    public int nthUglyNumber(int n) {
        assert n >= 1;

        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);

        long finalVal = 0;
        for (; n > 0; ) {
            Long minVal = queue.poll();
            if (minVal > finalVal) {
                finalVal = minVal;
                queue.add(minVal * 2);
                queue.add(minVal * 3);
                queue.add(minVal * 5);
                --n;
            }
        }
        return (int) finalVal;
    }
}
