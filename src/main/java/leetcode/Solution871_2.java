package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/minimum-number-of-refueling-stops/description/
 *  871. Minimum Number of Refueling Stops
 * </pre>
 * on 2018/10/10.
 */
public class Solution871_2 extends BaseTest {

    @Test
    public void test() {
        assertEquals(2, minRefuelStops(100, 10, new int[][]{arr(10, 60), arr(20, 30), arr(30, 30), arr(60, 40)}));

    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        return minRefuelStops(target, startFuel, stations, 0);
    }

    private int minRefuelStops(int target, long startFuel, int[][] stations, int curStationIndex) {
        if (startFuel >= target) return 0;
        if (curStationIndex >= stations.length || startFuel < stations[curStationIndex][0]) return -1;

        int result = -1;
        // add
        int addResult = minRefuelStops(target, startFuel + stations[curStationIndex][1], stations, curStationIndex + 1);
        if (addResult != -1) result = 1 + addResult;

        if (curStationIndex == stations.length - 1 || startFuel >= stations[curStationIndex + 1][0]) {
            int notAddResult = minRefuelStops(target, startFuel, stations, curStationIndex + 1);
            if (notAddResult != -1) {
                if (result == -1) result = notAddResult;
                else result = Math.min(result, notAddResult);
            }
        }
        return result;
    }

}
