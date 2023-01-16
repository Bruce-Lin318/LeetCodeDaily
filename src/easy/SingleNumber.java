package easy;

/**
 * https://leetcode.cn/problems/single-number/
 * 136. 只出现一次的数字
 *
 * @author Lin
 * @date 2023/1/16
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
