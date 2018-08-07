package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *  81. Search in Rotated Sorted Array II
 * </pre>
 * on 2018/8/2.
 */
public class Solution084 {
    public static void main(String[] args) {
        Solution084 solution11 = new Solution084();
        System.err.println(solution11.largestRectangleArea(new int[]{5, 4, 5}));
        System.err.println(solution11.largestRectangleArea2(new int[]{5, 4, 5}));
        System.err.println(solution11.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.err.println(solution11.largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
        System.err.println(solution11.largestRectangleArea2(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 2147483647}));

    }


    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        return loop(heights, 1, 1, heights[0]);
    }

    private int loop(int[] heights, int from, int width, int curHeight) {
        if (from < heights.length) {
            if (heights[from] > curHeight) {
                return Math.max(loop(heights, from + 1, width + 1, curHeight), loop(heights, from + 1, 1, heights[from]));
            } else if (heights[from] == curHeight) {
                return loop(heights, from + 1, width + 1, curHeight);
            } else {
                return Math.max(Math.max(width * curHeight, (width + 1) * heights[from]), loop(heights, from + 1, (width + 1), heights[from]));
            }
        }
        return width * curHeight;
    }


    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        return loop2(heights, 0, heights.length - 1);
    }

    private int loop2(int[] heights, int from, int to) {
        if (from > to) return 0;
        if (from == to) return heights[from];

        int minIndex = -1;
        int minVal = -1;
        for (int i = from; i <= to; ++i) {
            if (minVal == -1 || heights[i] < minVal) {
                minVal = heights[i];
                minIndex = i;
            }
        }

        return Math.max(Math.max((to - from + 1) * minVal, loop2(heights, 0, minIndex - 1)), loop2(heights, minIndex + 1, to));
    }

}
