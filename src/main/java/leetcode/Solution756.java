package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * <pre>
 *  https://leetcode.com/problems/pyramid-transition-matrix/description/
 *  756. Pyramid Transition Matrix
 * </pre>
 * on 2018/8/2.
 */
public class Solution756 {

    @Test
    public void test() {
        Assert.assertTrue(pyramidTransition("XYZ", new ArrayList<>(Arrays.asList("XYD", "YZE", "DEA", "FFF"))));
        Assert.assertFalse(pyramidTransition("XXYX", new ArrayList<>(Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ"))));

        Assert.assertFalse(pyramidTransition("BDD", new ArrayList<>(Arrays.asList("ACC", "AAD", "ABB", "DAB", "DCD", "ADA", "BBC", "CAB", "BCA", "DDC", "BAC", "BAA", "DDB", "CCD", "CAA", "DBC"))));
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        char[] pyramid = new char[bottom.length() * (bottom.length() + 1) / 2 + 1];

        int[] levelFroms = new int[bottom.length()];
        levelFroms[0] = 1;
        for (int i = 1; i < levelFroms.length; ++i) {
            levelFroms[i] = levelFroms[i - 1] + i;
        }

        for (int i = levelFroms[bottom.length() - 1], j = 0; i < pyramid.length; ++i) {
            pyramid[i] = bottom.charAt(j++);
        }

        allowed.sort((o1, o2) -> o1.compareTo(o2));
        Map<String, Integer> fromCache = new HashMap<>();
        for (int i = 0; i < allowed.size(); ++i) {
            fromCache.putIfAbsent(allowed.get(i).substring(0, 2), i);
        }
        return pyramidTransition(allowed, bottom.length() - 1, 0, pyramid, levelFroms, fromCache);
    }

    private boolean pyramidTransition(List<String> allowed, int level, int levelFrom, char[] pyramid, int[] levelFroms, Map<String, Integer> fromCache) {
        if (level == -1) return true;

        int leftIndex = levelFroms[level] + levelFrom;
        if (leftIndex + 1 >= pyramid.length) {
            return pyramidTransition(allowed, level - 1, 0, pyramid, levelFroms, fromCache);
        }
        if (level < levelFroms.length - 1) {
            if (leftIndex + 1 >= levelFroms[level + 1]) {
                return pyramidTransition(allowed, level - 1, 0, pyramid, levelFroms, fromCache);
            }
        }

        char left = pyramid[leftIndex];
        char right = pyramid[leftIndex + 1];
        Integer index = fromCache.get(new String(new char[]{left, right}));
        if (index == null) return false;
        for (int i = index; i < allowed.size() && allowed.get(i).charAt(0) == left; ++i) {
            char c = allowed.get(i).charAt(1);
            if (c == right) {
                pyramid[leftIndex - level] = allowed.get(i).charAt(2);
                if (pyramidTransition(allowed, level, levelFrom + 1, pyramid, levelFroms, fromCache)) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

}
