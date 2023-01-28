package medium;

/**
 * https://leetcode.cn/problems/ways-to-make-a-fair-array/
 * 1664. 生成平衡数组的方案数
 *
 * @author Lin
 * @date 2023/1/28
 */
public class WaysToMakeFairArray {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] odd = new int[n + 1], even = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            odd[i] = odd[i + 1];
            even[i] = even[i + 1];
            if (i % 2 == 0) {
                even[i] += nums[i];
            } else {
                odd[i] += nums[i];
            }
        }

        int ans = 0, evenSum = 0, oddSum = 0;
        for (int i = 0; i < n; i++) {
            ans += evenSum + odd[i + 1] == oddSum + even[i + 1] ? 1 : 0;
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        return ans;
    }
}
