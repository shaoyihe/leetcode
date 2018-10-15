package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/minimum-number-of-refueling-stops/description/
 *  871. Minimum Number of Refueling Stops
 * </pre>
 * on 2018/10/10.
 */
public class Solution871 extends BaseTest {

    @Test
    public void test() {
        assertEquals(2, minRefuelStops(100, 10, new int[][]{arr(10, 60), arr(20, 30), arr(30, 30), arr(60, 40)}));
        assertEquals(2, minRefuelStops(1000000000, 145267354, new int[][]{
                arr(32131797,142290934),
                arr(86397166,44642653),
                arr(99237057,56978680),
                arr(130019011,99649968)
        }));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Map<Long, Integer>[] maps = new Map[stations.length];
        return minRefuelStops(target, startFuel, stations, maps, 0);
    }

    private int minRefuelStops(int target, long startFuel, int[][] stations, Map<Long, Integer>[] cache, int curStationIndex) {
        if (startFuel >= target) return 0;
        if (curStationIndex >= stations.length || startFuel < stations[curStationIndex][0]) return -1;

        if (cache[curStationIndex] == null) cache[curStationIndex] = new HashMap<>();
        Integer integer = cache[curStationIndex].get(startFuel);
        if (integer != null) {
            return integer;
        } else {
            int result = -1;
            // add
            int addResult = minRefuelStops(target, startFuel + stations[curStationIndex][1], stations, cache, curStationIndex + 1);
            if (addResult != -1) result = 1 + addResult;

            if (curStationIndex == stations.length - 1 || startFuel >= stations[curStationIndex + 1][0]) {
                int notAddResult = minRefuelStops(target, startFuel, stations, cache, curStationIndex + 1);
                if (notAddResult != -1) {
                    if (result == -1) result = notAddResult;
                    else result = Math.min(result, notAddResult);
                }
            }

            cache[curStationIndex].put(startFuel, result);
            return result;
        }
    }

}
