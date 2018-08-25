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
}
