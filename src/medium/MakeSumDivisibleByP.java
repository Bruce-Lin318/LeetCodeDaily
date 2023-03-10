package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/make-sum-divisible-by-p/
 * 1590. 使数组和能被 P 整除
 *
 * @author Lin
 * @date 2023/3/10
 */
public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        long diff = sum[sum.length - 1] % p;
        // sum[j] - sum[i] = diff + p * x
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        int ans = nums.length;
        Integer pre = null;
        for (int i = 0; i < sum.length; i++) {
            map.put(sum[i] % p, i);
            if ((pre = map.get((sum[i] - diff) % p)) != null) {
                ans = Math.min(ans, i - pre);
            }
        }
        return ans >= nums.length ? -1 : ans;
    }

    /**
     * 对数器校验使用，纯暴力
     */
    public int minSubarray2(int[] nums, int p) {
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        long s = sum[sum.length - 1];
        int ans = sum.length;
        for (int i = sum.length - 1; i >= 0; i--) {
            if ((s - sum[i]) % p == 0) {
                ans = Math.min(ans, i + 1);
            }
            for (int j = 0; j < i; j++) {
                if ((s - (sum[i] - sum[j])) % p == 0L) {
                    Math.min(ans, i - j);
                }
            }
        }
        return ans == nums.length ? -1 : ans;
    }
}
