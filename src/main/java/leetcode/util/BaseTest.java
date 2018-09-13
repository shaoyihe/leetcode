package leetcode.util;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * on 2018/8/21.
 */
public abstract class BaseTest extends Assert {
    protected <T> Set<T> newSet(T... objs) {
        return newSet(Arrays.asList(objs));
    }

    protected <T> Set<T> newSet(List<T> objs) {
        return new HashSet<T>(objs);
    }

    protected <T> void assertToSetEqual(List<T> expect, List<T> actual) {
        assertEquals(newSet(expect), newSet(actual));
    }

    protected void assertArrEqual(int[] expect, int[] actual) {
        boolean equal = true;
        if (expect.length == actual.length) {
            for (int i = 0; i < expect.length; ++i) {
                if (expect[i] != actual[i]) {
                    equal = false;
                    break;
                }
            }
        } else equal = false;

        if (!equal) {
            fail("expect " + Arrays.toString(expect) + "; and actual " + Arrays.toString(actual));
        }
    }

    protected int[] arr(int... objs) {
        return objs;
    }

    protected String[] arr(String... objs) {
        return objs;
    }
}
