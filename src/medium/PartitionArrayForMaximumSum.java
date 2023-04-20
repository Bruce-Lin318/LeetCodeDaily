package medium;

/**
 * https://leetcode.cn/problems/partition-array-for-maximum-sum/
 * 1043. 分隔数组以得到最大和
 *
 * @author Lin
 * @date 2023/4/19
 */
public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            int max = arr[i];
            for (int j = 0; j < k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                int pre = i - j - 1 < 0 ? 0 : dp[i - j - 1];
                dp[i] = Math.max(dp[i], pre + max * (j + 1));
            }
        }
        return dp[arr.length - 1];
    }
}
