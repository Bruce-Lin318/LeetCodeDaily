package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 * 1658. 将 x 减到 0 的最小操作数
 * 思路：将从数组两边取值x转换为在数组内部找出最长（sum - x）子串
 * @author Lin
 * @date 2023/1/7
 */
public class MinimumOperationsToReduceToZero {
    /**
     * 滑动窗口
     */
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        if (sum == x) {
            return nums.length;
        }
        int left = 0;
        int right = 0;
        int res = -1;
        sum = nums[0];
        while (left < nums.length) {
            while (sum < sum - x && right < nums.length - 1) {
                sum += nums[++right];
            }
            if (sum == sum - x) {
                res = Math.max(res, right - left + 1);
            }
            sum -= nums[left++];
        }
        return res == -1 ? -1 : nums.length - res;
    }

    /**
     * 前缀和 + 哈希查找
     * hash还是比较慢
     */
    public int minOperations2(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
        // sums[j] - sums[i] = target
        for (int i = 0; i < sums.length; i++) {
            map.put(sums[i], i);
            if (sums[i] == target) {
                res = Math.max(res, i + 1);
            }
            if (map.containsKey(sums[i] - target)) {
                res = Math.max(res, i - map.get(sums[i] - target));
            }
        }
        return res == -1 ? -1 : nums.length - res;
    }
}
