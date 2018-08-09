package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/reverse-linked-list-ii/
 *  92. Reverse Linked List II
 * </pre>
 * on 2018/8/2.
 */

public class Solution096 {

    @Test
    public void test() {
//        Assert.assertEquals(2, numTrees(2));
//        Assert.assertEquals(5, numTrees(3));
        Assert.assertEquals(14, numTrees(4));
        System.err.println("====");
        Assert.assertEquals(42, numTrees(5));
    }

    public int numTrees(int n) {
        return numTrees(1, n);
    }

    public int numTrees(int from, int to) {
        if (from >= to) return 0;

        int total = to - from + 1;
        for (int i = from; i <= to; ++i) {
            total += minus(numTrees(from, i - 1)) + minus(numTrees(i + 1, to));
        }
        System.err.println(from + " -> " + to + " : " + total);
        return total;
    }

    private int minus(int num) {
        return num > 1 ? num - 1 : num;
    }
}
