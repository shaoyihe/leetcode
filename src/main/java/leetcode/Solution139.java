package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/word-break/description/
 *  139. Word Break
 * </pre>
 * on 2018/8/27.
 */
public class Solution139 extends BaseTest {

    @Test
    public void test() {
        assertTrue(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        assertTrue(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        assertFalse(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

    }


    private class Node {
        /**
         * key is child c
         */
        private Map<Character, Node> children = new HashMap<>();
        private char c;
        private int markWordIndex = -1;

        public Node(char c) {
            this.c = c;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node((char) 0);
        for (int i = 0; i < wordDict.size(); ++i) {
            String word = wordDict.get(i);
            Node cur = root;
            for (char c : word.toCharArray()) {
                Node node = cur.children.get(c);
                if (node == null) {
                    cur.children.put(c, node = new Node(c));
                }
                cur = node;
            }
            cur.markWordIndex = i;
        }
        return wordBreak(s, wordDict, 0, new int[s.length()], root);
    }

    private boolean wordBreak(String s, List<String> wordDict, int index, int[] cache, Node root) {
        if (cache[index] > 0) return false;

        Node cur = root;
        for (int i = index; i < s.length(); ++i) {
            Node node = cur.children.get(s.charAt(i));
            if (node == null) {
                break;
            } else if (node.markWordIndex >= 0) {
                //found one
                if (i == s.length() - 1 || wordBreak(s, wordDict, i + 1, cache, root)) {
                    return true;
                }
            }
            cur = node;
        }
        cache[index] = 1;
        return false;
    }

}
