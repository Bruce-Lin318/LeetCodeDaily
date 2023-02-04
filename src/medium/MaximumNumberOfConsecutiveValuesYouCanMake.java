package medium;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/
 * 1798. 你能构造出连续值的最大数目
 *
 * @author Lin
 * @date 2023/2/4
 */
public class MaximumNumberOfConsecutiveValuesYouCanMake {
    public int getMaximumConsecutive(int[] coins) {
        int max = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > max) {
                break;
            }
            max += coin;
        }
        return max;
    }
}
