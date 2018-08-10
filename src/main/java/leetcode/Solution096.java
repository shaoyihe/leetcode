package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/unique-binary-search-trees/description/
 *  96. Unique Binary Search Trees
 * </pre>
 * on 2018/8/2.
 */

public class Solution096 {

    @Test
    public void test() {
        Assert.assertEquals(2, numTrees(2));
        Assert.assertEquals(5, numTrees(3));

        Assert.assertEquals(5, numTrees(3));

        Assert.assertEquals(14, numTrees(4));
        System.err.println("====");
        Assert.assertEquals(1, numTrees(1));
        System.err.println("====");
        Assert.assertEquals(42, numTrees(5));
        Assert.assertEquals(132, numTrees(6));
    }


    public int numTrees(int n) {
        return numTrees(1, n);
    }

    public int numTrees(int from, int to) {
        if (from >= to) return 1;
        int total = 0;
        for (int i = from; i <= to; ++i) {
            total += numTrees(from, i - 1) * numTrees(i + 1, to);
        }
        return total;
    }

    public int numTrees2(int n) {
        return numTrees(1, n, new int[n]);
    }

    public int numTrees(int from, int to, int[] cache) {
        if (from >= to) return 1;
        if (cache[to - from] > 0) return cache[to - from];
        int total = 0;
        for (int i = from; i <= to; ++i) {
            total += numTrees(from, i - 1, cache) * numTrees(i + 1, to, cache);
        }
        return cache[to - from] = total;
    }

}
