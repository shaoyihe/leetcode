package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *  309. Best Time to Buy and Sell Stock with Cooldown
 * </pre>
 * on 2018/8/27.
 */
public class Solution309_2 extends BaseTest {

    @Test
    public void test() {
        assertEquals(3, maxProfit(arr(1, 2, 3, 0, 2)));
        assertEquals(3, maxProfit(arr(1, 2, 4)));
    }


    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, COOLDOWN, 0, new Integer[prices.length]);
    }

    private static final int BUY = 0;
    private static final int SELL = 1;
    private static final int COOLDOWN = 2;

    private int maxProfit(int[] prices, int index, int preStates, int buyPriceIndex, Integer[] cache) {
        if (index >= prices.length) {
            // not allowed
            if (preStates == BUY) {
                return Integer.MIN_VALUE;
            }
            return 0;
        }
        if (preStates == COOLDOWN) {
            if (cache[index] != null) return cache[index];
        }

        int maxPrice;
        if (preStates == COOLDOWN) {
            // 2 choice : cool down or buy
            maxPrice = cache[index] = Math.max(maxProfit(prices, index + 1, preStates, buyPriceIndex, cache), maxProfit(prices, index + 1, BUY, index, cache));
        } else {
            // buy state

            // 2 choice : SELL or cool down
            maxPrice = maxProfit(prices, index + 1, preStates, buyPriceIndex, cache);
            if (prices[index] - prices[buyPriceIndex] > 0) {
                maxPrice = Math.max(prices[index] - prices[buyPriceIndex] + maxProfit(prices, index + 2, COOLDOWN, 0, cache), maxPrice);
            }
        }
        return maxPrice;
    }

}
