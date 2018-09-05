package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/push-dominoes/description/
 *  838. Push Dominoes
 * </pre>
 * on 2018/09/03.
 */
public class Solution838 extends BaseTest {

    @Test
    public void test() {
        assertEquals("LL.RR.LLRRLL..", pushDominoes(".L.R...LR..L.."));
        assertEquals("RR.L", pushDominoes("RR.L"));
    }

    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() < 2) return dominoes;

        char[] result = dominoes.toCharArray();

        for (int i = 0; i < result.length; ++i) {
            if (result[i] == '.') {
                int notPushedI = i;
                // find last not push pos
                for (; i + 1 < result.length && result[i + 1] == '.'; ++i) ;

                if (notPushedI == 0 || result[notPushedI - 1] == 'L') {
                    if (i + 1 < result.length && result[i + 1] == 'L') Arrays.fill(result, notPushedI, i + 1, 'L');
                } else if (i + 1 == result.length || result[i + 1] == 'R') {
                    Arrays.fill(result, notPushedI, i + 1, 'R');
                } else {
                    // i -1 R and i+1 L
                    for (int left = notPushedI, right = i; right > left; ++left, --right) {
                        result[left] = 'R';
                        result[right] = 'L';
                    }
                }
            }
        }
        return new String(result);
    }

}
