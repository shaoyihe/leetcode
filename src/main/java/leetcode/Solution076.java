package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * <pre>
 *  https://leetcode.com/problems/minimum-window-substring/description/
 * 76. Minimum Window Substring
 * </pre>
 * on 2018/8/13.
 */
public class Solution076 {

    @Test
    public void test() {
        Assert.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
        Assert.assertEquals("aa", minWindow("aa", "aa"));
    }


    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty() || s == null || s.isEmpty() || s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);

        int from = -1, to = -1;
        Map<Character, List<Integer>> map = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0, mostLeft = -1; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            Integer times = tMap.get(sChar);
            if (times != null) {
                if (mostLeft == -1) mostLeft = i;

                List<Integer> poses = map.get(sChar);
                treeSet.add(i);
                if (poses == null) {
                    List<Integer> value = new LinkedList<>();
                    value.add(i);
                    map.put(sChar, value);
                } else if (poses.size() < times) {
                    poses.add(i);
                } else {
                    poses.add(i);
                    int oldPos = poses.remove(0);
                    treeSet.remove(oldPos);
                    if (oldPos == mostLeft) {
                        mostLeft = treeSet.first();
                    }
                }

                if (treeSet.size() == t.length()) {
                    if (from == -1 || to - from > i - mostLeft) {
                        from = mostLeft;
                        to = i;
                    }
                }
            }
        }

        if (from == -1) return "";
        return s.substring(from, to + 1);
    }
}
