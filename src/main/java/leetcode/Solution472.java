package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.*;

/**
 * <pre>
 *  https://leetcode.com/problems/concatenated-words/description/
 * 472. Concatenated Words
 * </pre>
 * on 2018/09/11.
 */
public class Solution472 extends BaseTest {

    @Test
    public void test() {
        assertToSetEqual(Arrays.asList("catsdogcats", "dogcatsdog", "ratcatdogcat"), findAllConcatenatedWordsInADict(arr("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat")));
    }

    private class Node {
        /**
         * key is child c
         */
        private Map<Character, Node> children = new HashMap<>();
        private char c;
        private boolean isWord = false;

        public Node(char c) {
            this.c = c;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length < 3) return result;

        int minLength = words[0].length();
        Node root = new Node((char) 0);
        for (String word : words) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                Node node = cur.children.get(c);
                if (node == null) {
                    cur.children.put(c, node = new Node(c));
                }
                cur = node;
            }
            cur.isWord = true;
            if (word.length() < minLength) minLength = word.length();
        }

        for (String word : words) {
            if (word.length() >= 2 * minLength && isConcatenatedWord(word, root, 0)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isConcatenatedWord(String word, Node root, int index) {
        Node cur = root;
        for (int i = index; i < word.length(); ++i) {
            Node node = cur.children.get(word.charAt(i));
            if (node == null) return false;
            if (node.isWord) {
                if (i == word.length() - 1) return index > 0;
                else if (isConcatenatedWord(word, root, i + 1)) {
                    return true;
                }
            }
            cur = node;
        }
        return false;
    }
}
