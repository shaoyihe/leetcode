package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *  https://leetcode.com/problemset/all/
 *  217. Contains Duplicate
 * </pre>
 * on 2018/8/2.
 */
public class Solution219 {
    public static void main(String[] args) {
        Solution219 solution11 = new Solution219();
        System.err.println(solution11.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 7));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return false;
        if (k <= 0) return false;

        Map<Integer, Integer> valToInx = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            Integer lastInx = valToInx.put(num, i);
            if (lastInx != null && i - lastInx <= k) {
                return true;
            }
        }
        return false;
    }

}
