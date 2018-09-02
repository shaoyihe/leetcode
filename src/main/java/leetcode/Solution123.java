package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *  123. Best Time to Buy and Sell Stock III
 * </pre>
 * on 2018/8/27.
 */
public class Solution123 extends BaseTest {

    @Test
    public void test() {
        assertEquals(6, maxProfit(arr(3, 3, 5, 0, 0, 3, 1, 4)));
        assertEquals(4, maxProfit(arr(1, 2, 3, 4, 5)));
        assertEquals(3, maxProfit(arr(2, 1, 4)));

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        Integer[][][] cache = new Integer[2][prices.length][prices.length];
        int maxProfit = maxProfit(prices, 1, cache, 2, 0);
        return maxProfit;
    }

    private int maxProfit(int[] prices, int index, Integer[][][] cache, int remainTimes, int holdIndex) {
        if (remainTimes == 0 || index >= prices.length) return 0;
        if (cache[remainTimes - 1][holdIndex][index] != null) return cache[remainTimes - 1][holdIndex][index];

        int maxVal = 0;
        if (prices[index] > prices[holdIndex]) {
            //sell or not
            return cache[remainTimes - 1][holdIndex][index] =
                    Math.max(
                            prices[index] - prices[holdIndex] + maxProfit(prices, index + 2, cache, remainTimes - 1, index + 1),
                            maxProfit(prices, index + 1, cache, remainTimes, holdIndex));

        } else {
            return cache[remainTimes - 1][holdIndex][index] = maxProfit(prices, index + 1, cache, remainTimes, index);
        }

    }

}
