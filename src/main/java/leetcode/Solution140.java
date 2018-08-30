package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/word-break-ii/description/
 *  140. Word Break II
 *
 *  error implementation
 * </pre>
 * on 2018/8/27.
 */
public class Solution140 extends BaseTest {

    @Test
    public void test() {
        assertToSetEqual(Arrays.asList("cats and dog", "cat sand dog"), wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        assertToSetEqual(Arrays.asList("pine apple pen apple",
                "pineapple pen apple",
                "pine applepen apple"), wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));

        assertToSetEqual(Arrays.asList("aggegbnngohbgga lojckbdfj akgnn jadhganf dkefeddjdnab mflabckflflja fdlmmbhij o jiaaifedaihn oinedhhnolc jdam"),
                wordBreak("aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam",
                        Arrays.asList("o","b","gbdfgiokkfnhl","glibjohcmd","bblcnhelanckn","mflabckflflja","mgda","oheafhajjo","cc","cffalholojikojm","haljiamccabh","gjkdlonmhdacd","ee","bc","mjj","fdlmmbhij","nn","jiaaifedaihn","nhligg","hooaglldlei","hajhebh","ebijeeh","me","eibm","ekkobhajgkem","ohaofonhjakc","n","kjjogm","mhn","odcamjmodie","edmagbkejiocacl","kcbfnjialef","lhifcohoe","akgnn","fbgakjhjb","belggjekmn","oinedhhnolc","ddekcnag","oneoakldakalb","bodnokemafkhkhf","dkefeddjdnab","gflcngff","fgnfmbcogmojgm","ad","jadhganf","lojckbdfj","gadkaoe","jdam","ljjndlnednnombl","aggegbnngohbgga")));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDict.sort(String::compareTo);
        List[] cache = new List[s.length()];
        List list = wordBreak(s, wordDict, 0, cache);
        return list;
    }

    private List<String> wordBreak(String s, List<String> wordDict, int index, List<String>[] cache) {
        if (cache[index] != null) return cache[index];

        //found equal index
        int foundIndex = -1;
        for (int i = 0, j = wordDict.size() - 1; i <= j; ) {
            int middle = (i + j) / 2;
            int compareVal = compare(s, index, wordDict.get(middle));
            if (compareVal == 0) {
                foundIndex = middle;
                break;
            } else if (compareVal < 0) {
                j = middle - 1;
            } else {
                i = middle + 1;
            }
        }
        if (foundIndex == -1) {
            return cache[index] = Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        innerWordBreak(s, wordDict, index, foundIndex, list, cache);
        //left
        for (int i = foundIndex - 1; i >= 0; --i) {
            if (compare(s, index, wordDict.get(i)) == 0) {
                innerWordBreak(s, wordDict, index, i, list, cache);
            } else break;
        }

        //right
        for (int i = foundIndex + 1; i < wordDict.size(); ++i) {
            if (compare(s, index, wordDict.get(i)) == 0) {
                innerWordBreak(s, wordDict, index, i, list, cache);
            } else break;
        }

        return cache[index] = list;
    }

    private void innerWordBreak(String s, List<String> wordDict, int index, int foundIndex, List<String> list, List<String>[] cache) {
        int nextIndex = wordDict.get(foundIndex).length() + index;
        if (nextIndex != s.length()) {
            List<String> strings = wordBreak(s, wordDict, nextIndex, cache);
            for (String string : strings) {
                list.add(wordDict.get(foundIndex) + " " + string);
            }
        } else {
            list.add(wordDict.get(foundIndex));
        }
    }

    private int compare(String s, int index, String target) {
        int limit = Math.min(target.length(), s.length() - index);
        for (int i = 0; i < limit; ++i) {
            if (s.charAt(index + i) < target.charAt(i)) {
                return -1;
            } else if (s.charAt(index + i) > target.charAt(i)) {
                return 1;
            }
        }
        if (s.length() - index < target.length()) return -1;
        return 0;
    }

}
