package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.*;

/**
 * <pre>
 *  https://leetcode.com/problems/distinct-subsequences/description/
 *  115. Distinct Subsequences
 * </pre>
 * on 2018/8/27.
 */
public class Solution115 extends BaseTest {

    @Test
    public void test() {
        assertEquals(3, numDistinct("rabbbit", "rabbit"));
        assertEquals(5, numDistinct("babgbag", "bag"));
    }

    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
        if (t.length() > s.length()) return 0;
        if (t.isEmpty()) return 1;

        Map<Character, List<Integer>> charToPos = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            charToPos.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }
        int[][] cache = new int[s.length()][t.length()];
        for (int[] temp : cache) Arrays.fill(temp, -1);

        return numDistinct(s, t, charToPos, 0, 0, cache);
    }

    private int numDistinct(String s, String t, Map<Character, List<Integer>> charToPos, int sIndex, int tIndex, int[][] cache) {
        if (tIndex == t.length()) return 1;
        if (sIndex == s.length()) return 0;
        if (cache[sIndex][tIndex] >= 0) return cache[sIndex][tIndex];

        int total = 0;

        char tChar = t.charAt(tIndex);
        List<Integer> poses = charToPos.get(tChar);
        if (poses != null) {
            for (int i = foundFirstBig(poses, sIndex); i < poses.size() && s.length() - poses.get(i) >= t.length() - tIndex; ++i) {
                total += numDistinct(s, t, charToPos, poses.get(i) + 1, tIndex + 1, cache);
            }
        }
        return cache[sIndex][tIndex] = total;
    }

    private int foundFirstBig(List<Integer> poses, int sIndex) {
        for (int from = 0, to = poses.size() - 1; from <= to; ) {
            int middleIndex = (from + to) / 2;
            if (poses.get(middleIndex) < sIndex) {
                from = middleIndex + 1;
            } else if (poses.get(middleIndex) > sIndex) {
                if (middleIndex == 0 || poses.get(middleIndex - 1) < sIndex) return middleIndex;
                to = middleIndex - 1;
            } else return middleIndex;
        }
        return poses.size();
    }
}
