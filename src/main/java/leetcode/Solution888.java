package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/contest/weekly-contest-97/problems/uncommon-words-from-two-sentences/
 *  888. Uncommon Words from Two Sentences
 * </pre>
 * on 2018/8/12.
 */
public class Solution888 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new String[]{"sweet", "sour"}, uncommonFromSentences("this apple is    sweet", "this apple is sour"));
    }


    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String temp : A.split(" +")) {
            Integer time = count.get(temp);
            if (time == null || time == 1) {
                count.put(temp, time == null ? 1 : 2);
            }
        }

        for (String temp : B.split(" +")) {
            Integer time = count.get(temp);
            if (time == null || time == 1) {
                count.put(temp, time == null ? 1 : 2);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) result.add(entry.getKey());
        }
        return result.toArray(new String[]{});
    }
}
