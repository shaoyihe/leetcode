package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/coin-change/
 *  322. Coin Change
 * </pre>
 * on 2018/8/2.
 */
public class Solution332 {
    @Test
    public void test() {
        Assert.assertEquals(3, coinChange(new int[]{1, 2, 5}, 11));
    }


    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null || coins.length < 1 || amount < 0) return -1;
        Arrays.sort(coins);
        Map<Integer, Integer> amountToTimes = new HashMap<>();
        return innerCoinChange(coins, amount, amountToTimes);
    }

    public int innerCoinChange(int[] coins, int amount, Map<Integer, Integer> amountToTimes) {
        if (amountToTimes.containsKey(amount)) {
            return amountToTimes.get(amount);
        }

        int minTimes = -1;
        for (int i = coins.length - 1; i >= 0; --i) {
            int coin = coins[i];
            int remainAmount = amount - coin;
            int result = -1;
            if (remainAmount > 0) {
                result = innerCoinChange(coins, remainAmount, amountToTimes);
            } else if (remainAmount == 0) {
                result = 0;
            }
            if (result != -1) {
                if (minTimes == -1 || result < minTimes) {
                    minTimes = result;
                    if (minTimes == 0) break;
                }
            }
        }
        amountToTimes.put(amount, minTimes = minTimes == -1 ? -1 : minTimes + 1);
        return minTimes;
    }

}
