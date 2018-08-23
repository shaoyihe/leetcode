package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
 *  762. Prime Number of Set Bits in Binary Representation
 * </pre>
 * on 2018/8/2.
 */
public class Solution762 extends BaseTest {

    @Test
    public void test() {
        assertEquals(4, countPrimeSetBits(6, 10));
        assertEquals(5, countPrimeSetBits(10, 15));
    }

    public int countPrimeSetBits(int L, int R) {
        int[] prime = new int[32];
        prime[1] = -1;

        int result = 0;
        for (int i = L; i <= R; ++i) {
            int count = Integer.bitCount(i);
            if (prime[count] > 0) result++;
            else if (prime[count] == 0) {
                boolean isPrime = true;
                for (int j = 2; j < count / 2 + 1; ++j) {
                    if (count % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                prime[count] = isPrime ? 1 : -1;
                if (isPrime) result++;
            }
        }
        return result;
    }

}
