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
    protected <T> Set<T> nweSet(T... objs) {
        return nweSet(Arrays.asList(objs));
    }

    protected <T> Set<T> nweSet(List<T> objs) {
        return new HashSet<T>(objs);
    }
}
