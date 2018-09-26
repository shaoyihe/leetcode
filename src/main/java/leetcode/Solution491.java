package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.*;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *  646. Maximum Length of Pair Chain
 * </pre>
 * on 2018/9/26.
 */
public class Solution491 extends BaseTest {

    @Test
    public void test() {

    }

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 2) return result;
        Arrays.sort(nums);

        for (int i = 1, preVal = nums[0], occCount = 1; i < nums.length; ++i) {
            if (nums[i] == preVal) occCount++;
            else {
                occCount = 1;
                preVal = nums[i];
            }

            for (int j = 0, resultSize = result.size(); j < resultSize; ++j) {
                List<Integer> curIntegers = result.get(j);
                if (occCount >= 2) {
                    if (curIntegers.size() >= occCount - 1 && curIntegers.get(curIntegers.size() - 1) == nums[i] && curIntegers.get(curIntegers.size() - (occCount - 1)) == nums[i]) {
                        List<Integer> clone = (List<Integer>) ((ArrayList) curIntegers).clone();
                        clone.add(nums[i]);
                        result.add(clone);
                    }
                } else {
                    if (curIntegers.get(curIntegers.size() - 1) <= nums[i]) {
                        List<Integer> clone = (List<Integer>) ((ArrayList) curIntegers).clone();
                        clone.add(nums[i]);
                        result.add(clone);
                    }
                }
            }
            if (occCount == 2) {
                result.add(addTo(nums[i], nums[i]));
            }
            if (occCount >= 2) continue;

            for (int j = 0; j < i; ++j) {
                if (j > 0 && nums[j] == nums[j - 1]) continue;
                if (nums[j] <= nums[i]) {
                    result.add(addTo(nums[j], nums[i]));
                }
            }
        }
        return result;
    }

    private List<Integer> addTo(int a, int b) {
        List<Integer> cur = new ArrayList<>();
        cur.add(a);
        cur.add(b);
        return cur;
    }

}
