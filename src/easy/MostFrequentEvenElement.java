package easy;

import util.annotation.Main;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/most-frequent-even-element/
 * 2404. 出现最频繁的偶数元素
 *
 * @author Lin
 * @date 2023/4/13
 */
public class MostFrequentEvenElement {
    @Main
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);;
        int index = 0;
        int max = 0;
        int res = -1;
        while (index < nums.length) {
            while (index < nums.length && nums[index] % 2 != 0) {
                index++;
            }
            int cur = index;
            while (index < nums.length && nums[index] == nums[cur]) {
                index++;
            }
            if (cur < nums.length && (index - cur) > max) {
                max = index - cur;
                res = nums[cur];
            }
        }
        return res;
    }
}
