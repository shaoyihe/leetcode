package leetcode;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * <pre>
 *  https://leetcode.com/problems/simplify-path/description/
 *  71. Simplify Path
 * </pre>
 * on 2018/8/2.
 */

public class Solution071 {

    @Test
    public void test() {
        assertEquals(simplifyPath("/."), "/");
        assertEquals(simplifyPath("/home/"), "/home");
        assertEquals(simplifyPath("/a/./b/../..///c/"), "/c");
        assertEquals("/.aa/....hidden", simplifyPath("/.aa/....hidden"));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        char[] chars = path.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (c == '.') {
                //find next /
                if ((i + 1 >= chars.length || (chars[i + 1] == '.' || chars[i + 1] == '/')) && (i + 2 >= chars.length || chars[i + 1] == '/' || chars[i + 2] == '/')) {
                    stack.pop();
                    if (i + 1 < chars.length && chars[i + 1] == '.') {
                        if (!stack.isEmpty()) {
                            stack.pop();
                            stack.pop();
                        }
                        ++i;
                    }
                } else {
                    //char
                    int curIndex = i;
                    for (; i + 1 < chars.length && chars[i + 1] != '/'; ++i) ;
                    stack.push(new String(chars, curIndex, i - curIndex + 1));
                }
            } else if (c == '/') {
                if (i == 0 || chars[i - 1] != '/') {
                    stack.push(c + "");
                }
            } else {
                //char
                int curIndex = i;
                for (; i + 1 < chars.length && chars[i + 1] != '/'; ++i) ;
                stack.push(new String(chars, curIndex, i - curIndex + 1));
            }
        }

        if (stack.isEmpty()) return "/";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.size(); ++i) {
            if (stack.get(i).equals("/") && i > 0 && i == stack.size() - 1) {

            } else {
                result.append(stack.get(i));
            }
        }
        return result.toString();
    }
}
