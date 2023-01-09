package medium;

/**
 * https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 * 1806. 还原排列的最少操作步数
 * 思路：追踪单一元素的路径就可以，路径唯一
 *
 * @author Lin
 * @date 2023/1/9
 */
public class MinimumNumberOfOperationsToReinitializePermutation {
    public int reinitializePermutation(int n) {
        int res = 0;
        int index = 1;
        do {
            index = index % 2 == 0 ? index / 2 : n / 2 + (index - 1) / 2;
            res++;
        } while (index != 1);
        return res;
    }
}
