package easy;

/**
 * https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/
 * 2441. 与对应负数同时存在的最大正整数
 *
 * @author Lin
 * @date 2023/5/13
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        boolean[] negative = new boolean[1001];
        int res = 0;
        for (int num : nums) {
            if (num < 0) {
                negative[-num] = true;
            }
        }
        for (int num : nums) {
            if (num > 0 && negative[num] && num > res) {
                res = num;
            }
        }
        return res;
    }
}
