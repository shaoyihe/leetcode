package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/coin-change/description/
 *  322. Coin Change
 * </pre>
 * on 2018/8/2.
 */
public class Solution322 {

    @Test
    public void test() {
//        Assert.assertEquals(3, coinChange(new int[]{1, 2, 5}, 11));
//
//        Assert.assertEquals(-1, coinChange(new int[]{2}, 3));

        Assert.assertEquals(21, coinChange(new int[]{58, 92, 387, 421, 194, 208, 231}, 7798));
    }

    @Test
    public void test2() {
//        Assert.assertEquals(3, coinChange2(new int[]{1, 2, 5}, 11));
//
//        Assert.assertEquals(-1, coinChange2(new int[]{2}, 3));

        Assert.assertEquals(21, coinChange2(new int[]{58, 92, 387, 421, 194, 208, 231}, 7798));
    }

    @Test
    public void test3() {
//        Assert.assertEquals(3, coinChange2(new int[]{1, 2, 5}, 11));
//
//        Assert.assertEquals(-1, coinChange2(new int[]{2}, 3));

        Assert.assertEquals(21, coinChange3(new int[]{58, 92, 387, 421, 194, 208, 231}, 7798));
    }


    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, coins.length - 1);
    }

    private int coinChange(int[] coins, int amount, int index) {
        if (index < 0) {
            return amount > 0 ? -1 : 0;
        }

        int limit = amount / coins[index];
        int minCount = -1;
        for (int i = 0; i <= limit; ++i) {
            int times = coinChange(coins, amount - coins[index] * i, index - 1);
            if (times >= 0) {
                if (minCount == -1) minCount = times + i;
                else minCount = Math.min(minCount, times + i);
            }
        }
        return minCount;
    }

    public int coinChange2(int[] coins, int amount) {
        return coinChange(coins, amount, coins.length - 1, new HashMap<>());
    }

    private int coinChange(int[] coins, int amount, int index, Map<String, Integer> cache) {
        if (index < 0) {
            return amount > 0 ? -1 : 0;
        }
        Integer count = cache.get(amount + "/" + index);
        if (count != null) return count;

        int limit = amount / coins[index];
        int minCount = -1;
        for (int i = 0; i <= limit; ++i) {
            int times = coinChange(coins, amount - coins[index] * i, index - 1, cache);
            if (times >= 0) {
                if (minCount == -1) minCount = times + i;
                else minCount = Math.min(minCount, times + i);
            }
        }
        cache.put(amount + "/" + index, minCount);
        return minCount;
    }


    public int coinChange3(int[] coins, int amount) {

        Arrays.sort(coins);
        return coinChange3(coins, amount, 0);
    }

    private int coinChange3(int[] coins, int amount, int index) {
        if (index >= coins.length) {
            return amount > 0 ? -1 : 0;
        }

        int limit = amount / coins[index];
        int minCount = -1;
        for (int i = 0; i <= limit; ++i) {
            if (minCount > 0 && i >= minCount) break;

            int times = coinChange3(coins, amount - coins[index] * i, index + 1);
            if (times >= 0) {
                if (minCount == -1) minCount = times + i;
                else minCount = Math.min(minCount, times + i);
            }
        }
        return minCount;
    }

}
