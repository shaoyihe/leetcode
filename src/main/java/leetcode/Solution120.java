package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/triangle/description/
 *  120. Triangle
 * </pre>
 * on 2018/09/03.
 */
public class Solution120 extends BaseTest {

    @Test
    public void test() {
        assertEquals(11, minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;
        return minimumTotal(triangle, 1, 0, new Integer[triangle.get(triangle.size() - 1).size()][triangle.size()])
                + triangle.get(0).get(0);
    }


    private int minimumTotal(List<List<Integer>> triangle, int curIndex, int beforeChoice, Integer[][] cache) {
        if (curIndex == triangle.size()) return 0;
        if (cache[beforeChoice][curIndex] != null) return cache[beforeChoice][curIndex];

        //
        List<Integer> curInts = triangle.get(curIndex);
        return cache[beforeChoice][curIndex] =
                Math.min(curInts.get(beforeChoice) + minimumTotal(triangle, curIndex + 1, beforeChoice, cache),
                        curInts.get(beforeChoice + 1) + minimumTotal(triangle, curIndex + 1, beforeChoice + 1, cache));
    }

}
