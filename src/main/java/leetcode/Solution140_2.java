package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.*;

/**
 * <pre>
 *  https://leetcode.com/problems/word-break-ii/description/
 *  140. Word Break II
 * </pre>
 * on 2018/8/27.
 */
public class Solution140_2 extends BaseTest {

    @Test
    public void test() {
        assertToSetEqual(Arrays.asList("cats and dog", "cat sand dog"), wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        assertToSetEqual(Arrays.asList("pine apple pen apple",
                "pineapple pen apple",
                "pine applepen apple"), wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));

        assertToSetEqual(Arrays.asList("aggegbnngohbgga lojckbdfj akgnn jadhganf dkefeddjdnab mflabckflflja fdlmmbhij o jiaaifedaihn oinedhhnolc jdam"),
                wordBreak("aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam",
                        Arrays.asList("o", "b", "gbdfgiokkfnhl", "glibjohcmd", "bblcnhelanckn", "mflabckflflja", "mgda", "oheafhajjo", "cc", "cffalholojikojm", "haljiamccabh", "gjkdlonmhdacd", "ee", "bc", "mjj", "fdlmmbhij", "nn", "jiaaifedaihn", "nhligg", "hooaglldlei", "hajhebh", "ebijeeh", "me", "eibm", "ekkobhajgkem", "ohaofonhjakc", "n", "kjjogm", "mhn", "odcamjmodie", "edmagbkejiocacl", "kcbfnjialef", "lhifcohoe", "akgnn", "fbgakjhjb", "belggjekmn", "oinedhhnolc", "ddekcnag", "oneoakldakalb", "bodnokemafkhkhf", "dkefeddjdnab", "gflcngff", "fgnfmbcogmojgm", "ad", "jadhganf", "lojckbdfj", "gadkaoe", "jdam", "ljjndlnednnombl", "aggegbnngohbgga")));
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

    public List<String> wordBreak(String s, List<String> wordDict) {
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
        return wordBreak(s, wordDict, 0, new List[s.length()], root);
    }

    private List<String> wordBreak(String s, List<String> wordDict, int index, List<String>[] cache, Node root) {
        if (cache[index] != null) return cache[index];

        List<String> list = new ArrayList<>();
        Node cur = root;
        for (int i = index; i < s.length(); ++i) {
            Node node = cur.children.get(s.charAt(i));
            if (node == null) {
                break;
            } else if (node.markWordIndex >= 0) {
                //found one
                if (i == s.length() - 1) {
                    list.add(wordDict.get(node.markWordIndex));
                } else {
                    for (String subString : wordBreak(s, wordDict, i + 1, cache, root)) {
                        list.add(wordDict.get(node.markWordIndex) + " " + subString);
                    }
                }
            }
            cur = node;
        }
        return cache[index] = list;
    }


}
