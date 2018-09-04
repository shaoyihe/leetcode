package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/frog-jump/description/
 *  403. Frog Jump
 * </pre>
 * on 2018/09/03.
 */
public class Solution403 extends BaseTest {

    @Test
    public void test() {
        assertTrue(canCross(arr(0, 1, 3, 5, 6, 8, 12, 17)));
        assertFalse(canCross(arr(0, 1, 2, 3, 4, 8, 9, 11)));
    }

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;

        Map<Integer, Integer> stonesMap = new HashMap<>();
        for (int i = 0; i < stones.length; ++i) {
            stonesMap.put(stones[i], i);
        }
        return canCross(stonesMap, 1, 1, 1, stones[stones.length - 1], new int[stones.length][stones.length]);
    }

    private boolean canCross(Map<Integer, Integer> stones, int curStonePos, int curStoneIndex, int k, int targetVal, int[][] cache) {
        if (curStonePos == targetVal) return true;

        return choiceK(stones, curStonePos, k - 1, targetVal, cache, curStoneIndex)      //  choice k-1
                || choiceK(stones, curStonePos, k, targetVal, cache, curStoneIndex)          //choice k
                || choiceK(stones, curStonePos, k + 1, targetVal, cache, curStoneIndex); //choice k+1
    }

    private boolean choiceK(Map<Integer, Integer> stones, int curStonePos, int k, int targetVal, int[][] cache, int curStoneIndex) {
        if (k <= 0) return false;
        Integer stonesIndex = stones.get(curStonePos + k);
        if (stonesIndex != null && cache[curStoneIndex][stonesIndex] == 0) {
            if (canCross(stones, curStonePos + k, stonesIndex, k, targetVal, cache)) {
                return true;
            }
            cache[curStoneIndex][stonesIndex] = 1;
        }
        return false;
    }
}
