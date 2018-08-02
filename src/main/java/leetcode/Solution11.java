package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/container-with-most-water
 *  11. Container With Most Water
 * </pre>
 * on 2018/8/2.
 */
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        //49
        System.err.println(solution11.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * o(n^2)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int maxArea = 0;
        int length = height.length;
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int curMaxArea = Math.min(height[i], height[j]) * (j - i);
                if (curMaxArea > maxArea) maxArea = curMaxArea;
            }
        }
        return maxArea;
    }

    /**
     * o(n)
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length < 2) return 0;
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return maxArea;
    }
}
