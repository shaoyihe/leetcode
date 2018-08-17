package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/total-hamming-distance/description/
 *  477. Total Hamming Distance
 * </pre>
 * on 2018/8/2.
 */
public class Solution477 {

    @Test
    public void test() {
        Assert.assertEquals(6, totalHammingDistance(new int[]{4, 14, 2}));

        Assert.assertEquals(6, totalHammingDistance2(new int[]{4, 14, 2}));
    }

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int total = 0;
        Map<Integer, Integer> cache = new HashMap<>(nums.length * nums.length);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int xor = nums[i] ^ nums[j];
                Integer val = cache.get(xor);
                if (val != null) total += val;
                else {
                    total += (val = hammingDistance(xor));
                    cache.put(xor, val);
                }
            }
        }
        return total;
    }

    private int hammingDistance(int num) {
        int total = 0;
        for (; num > 0; num >>= 1) {
            total += num & 1;
        }
        return total;
    }

    public int totalHammingDistance2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        //Elements of the given array are in the range of 0 to 10^9
        int[] count1Bits = new int[31];
        for (int num : nums) {
            for (int pos = 0; num > 0; num >>= 1) {
                count1Bits[pos++] += num & 1;
            }
        }
        int length = nums.length, total = 0;
        for (int count1Bit : count1Bits) {
            total += count1Bit * (length - count1Bit);
        }
        return total;
    }
}
