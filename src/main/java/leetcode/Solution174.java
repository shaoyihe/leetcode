package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/dungeon-game/description/
 *  174. Dungeon Game
 * </pre>
 * on 2018/8/27.
 */
public class Solution174 extends BaseTest {

    @Test
    public void test() {
        calculateMinimumHP(new int[][]{{-1, 1}});

    }

    public int calculateMinimumHP(int[][] dungeon) {

        int[][] cache = new int[dungeon.length][dungeon[0].length];
        calculateMinimumHP(dungeon, dungeon.length - 1, dungeon[0].length - 1, cache, 1);
        return cache[0][0];
    }


    private void calculateMinimumHP(int[][] dungeon, int x, int y, int[][] cache, int requireHealth) {
        if (x < 0 || y < 0) return;
        //
        int curNeedHealth;
        if (dungeon[x][y] - requireHealth > 0) {
            //need 1
            curNeedHealth = 1;

        } else {
            curNeedHealth = -(dungeon[x][y] - requireHealth);
            if (curNeedHealth == 0) curNeedHealth = 1;
        }

        if (cache[x][y] == 0 || curNeedHealth < cache[x][y]) {
            cache[x][y] = curNeedHealth;
            calculateMinimumHP(dungeon, x - 1, y, cache, curNeedHealth);
            calculateMinimumHP(dungeon, x, y - 1, cache, curNeedHealth);
        }
    }
}
