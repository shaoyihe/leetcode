package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/contains-duplicate-iii/description/
 *  220. Contains Duplicate III
 * </pre>
 * on 2018/8/2.
 */
public class Solution220 {
    public static void main(String[] args) {
        Solution220 solution11 = new Solution220();
        System.err.println(solution11.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.err.println(solution11.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.err.println(solution11.containsNearbyAlmostDuplicate(new int[]{2, 2}, 3, 0));
        System.err.println(solution11.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
    }


    /**
     * O(n) * O(k)
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) return false;
        if (k <= 0) return false;

        for (int i = 0; i < nums.length; ++i) {
            int limit = Math.min(k + i, nums.length - 1);
            for (int j = i + 1; j <= limit; ++j) {
                if (Math.abs((long) nums[j] - nums[i]) <= t) return true;
            }
        }
        return false;
    }

}
