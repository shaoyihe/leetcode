package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 *  787. Cheapest Flights Within K Stops
 * </pre>
 * on 2018/10/16.
 */
public class Solution787 extends BaseTest {

    @Test
    public void test() {
        assertEquals(500, findCheapestPrice(3, new int[][]{arr(0, 1, 100), arr(1, 2, 100), arr(0, 2, 500)}, 0, 2, 0));
        assertEquals(200, findCheapestPrice(3, new int[][]{arr(0, 1, 100), arr(1, 2, 100), arr(0, 2, 500)}, 0, 2, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        Arrays.sort(flights, Comparator.comparingInt(o -> o[0]));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(flights[0][0], 0);
        for (int i = 1, before = flights[0][0]; i < flights.length; ++i) {
            if (before != flights[i][0]) {
                map.put(flights[i][0], i);
                before = flights[i][0];
            }
        }
        int[][] cache = new int[n][n];
        return findCheapestPrice(n, flights, src, dst, K, 0, map, cache);
    }

    private int findCheapestPrice(int n, int[][] flights, int src, int dst, int K, int stop, Map<Integer, Integer> map, int[][] cache) {
        if (stop > K) return -1;

        if (cache[src][stop] != 0) return cache[src][stop];

        Integer from = map.get(src);
        if (from != null) {
            int minVal = -1;
            for (int i = from; i < flights.length && flights[i][0] == src; ++i) {
                int curPrice = flights[i][2];
                int targetFlight = flights[i][1];

                int curTargetPrice = curPrice;
                if (targetFlight != dst) {
                    int nextPrice = findCheapestPrice(n, flights, targetFlight, dst, K, stop + 1, map, cache);
                    if (nextPrice == -1) {
                        curTargetPrice = -1;
                    } else {
                        curTargetPrice = curPrice + nextPrice;
                    }
                }
                if (minVal == -1) {
                    minVal = curTargetPrice;
                } else if (curTargetPrice != -1 && curTargetPrice < minVal) {
                    minVal = curTargetPrice;
                }
            }
            return cache[src][stop] = minVal;
        }
        return -1;
    }

}
