package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/binary-watch/description/
 *  401. Binary Watch
 * </pre>
 * on 2018/8/2.
 */
public class Solution401 extends BaseTest {

    @Test
    public void test() {
        assertEquals(newSet("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"), newSet(readBinaryWatch(1)));
    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        if (num >= 9 || num < 0) return result;
        if (num == 0) {
            result.add("0:00");
            return result;
        }

        List<Integer> hours = new ArrayList<>();
        List<Integer> minutes = new ArrayList<>();
        for (int hourBits = Math.max(num - 5, 0); hourBits <= Math.min(3, num); ++hourBits) {
            // 取hour
            loop(hours, 3, hourBits, 11, 0);
            loop(minutes, 5, num - hourBits, 59, 0);

            for (Integer hour : hours) {
                for (Integer minute : minutes) {
                    result.add(hour + ":" + (minute < 10 ? "0" : "") + minute);
                }
            }
            hours.clear();
            minutes.clear();
        }

        return result;
    }

    private void loop(List<Integer> hour, int index, int remain1, int maxVal, int cur) {
        if (remain1 == 0) {
            if (cur <= maxVal) hour.add(cur);
        } else if (index < 0 || remain1 > index + 1) {
            //ignore
        } else if (remain1 == index + 1) {
            loop(hour, index - 1, remain1 - 1, maxVal, cur | 1 << index);
        } else {
            loop(hour, index - 1, remain1, maxVal, cur);
            loop(hour, index - 1, remain1 - 1, maxVal, cur | 1 << index);
        }
    }

}
