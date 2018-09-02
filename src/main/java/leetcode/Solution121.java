package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *  121. Best Time to Buy and Sell Stock
 * </pre>
 * on 2018/8/27.
 */
public class Solution121 extends BaseTest {

    @Test
    public void test() {
        assertEquals(5, maxProfit(arr(7, 1, 5, 3, 6, 4)));
        assertEquals(0, maxProfit(arr(7, 6, 4, 3, 1)));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int max = 0;
        for (int i = 1, cur = prices[0]; i < prices.length; ++i) {
            if (prices[i] > cur) {
                if (prices[i] - cur > max) max = prices[i] - cur;
            } else {
                cur = prices[i];
            }
        }
        return max;
    }
}
