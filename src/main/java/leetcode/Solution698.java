package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * <pre>
 *  https://leetcode.com/problems/target-sum/description/
 *  494. Target Sum
 * </pre>
 * on 2018/8/2.
 */
public class Solution698 {
    public static void main(String[] args) {
        Solution698 solution11 = new Solution698();
        int[] arr = {1, 1, 1, 1, 1};
        System.err.println(solution11.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.err.println(solution11.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
        System.err.println(solution11.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.err.println(solution11.canPartitionKSubsets(new int[]{5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3}, 15));
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null) return false;
        if (k == 1) return true;

        TreeMap<Integer, Integer> valToCount = new TreeMap<>();
        int sum = 0;
        for (int n : nums) {
            sum += n;

            Integer oldCount = valToCount.put(n, 1);
            if (oldCount != null) valToCount.put(n, oldCount + 1);
        }
        if (sum % k != 0) return false;
        int kSum = sum / k;
        if (valToCount.lastEntry().getKey() > kSum) return false;
        for (int require = kSum; k > 1; ) {
            Map.Entry<Integer, Integer> lastEntry = valToCount.floorEntry(require);
            if (lastEntry == null) return false;

            Integer key = lastEntry.getKey();
            Integer count = lastEntry.getValue();

            require -= key;
            if (require == 0) {
                --k;
                require = kSum;
            }

            if (count > 1) valToCount.put(key, count - 1);
            else valToCount.remove(key);
        }

        return k <= 1;
    }
}
