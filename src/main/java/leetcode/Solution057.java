package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/plus-one/description/
 *  66. Plus One
 * </pre>
 * on 2018/8/2.
 */
public class Solution057 {
    public static void main(String[] args) {
        Solution057 solution11 = new Solution057();
        int[][] result = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null) return Arrays.asList(newInterval);

        boolean found = false;
        for (int i = 0; !found && i < intervals.size(); ++i) {
            Interval interval = intervals.get(i);
            if ((newInterval.start >= interval.start && newInterval.start <= interval.end) || (interval.start >= newInterval.start && interval.start <= newInterval.end)) {
                int newStart = Math.min(newInterval.start, interval.start);
                int newEnd = Math.max(newInterval.end, interval.end);
                int curI = i;
                for (; i + 1 < intervals.size() && newEnd >= intervals.get(i + 1).start; ) {
                    newEnd = Math.max(newEnd, intervals.get(i + 1).end);
                    intervals.remove(i + 1);
                }

                interval.start = newStart;
                interval.end = newEnd;
                found = true;
            } else if (newInterval.end < interval.start) {
                intervals.add(i, newInterval);
                found = true;
            }
        }
        if (!found) intervals.add(newInterval);
        return intervals;
    }

    /**
     * Definition for an interval.
     */

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


}
