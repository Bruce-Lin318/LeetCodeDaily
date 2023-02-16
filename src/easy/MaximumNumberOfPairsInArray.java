package easy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 * 2341. 数组能形成多少数对
 *
 * @author Lin
 * @date 2023/2/16
 */
public class MaximumNumberOfPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index] == nums[index + 1]) {
                count++;
                index += 2;
            } else {
                index++;
            }
        }
        return new int[]{count, nums.length - count * 2};
    }

    public int[] numberOfPairs2(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }
        int res = 0;
        for (int count : counts) {
            res += count > 1 ? count / 2 : 0;
        }
        return new int[]{res, nums.length - res * 2};
    }
}
