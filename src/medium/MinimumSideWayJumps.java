package medium;

/**
 * https://leetcode.cn/problems/minimum-sideway-jumps/
 * 1824. 最少侧跳次数
 *
 * @author Lin
 * @date 2023/1/21
 */
public class MinimumSideWayJumps {
    /**
     * 计算第i层只需要i - 1层的数据，所以0 ~ i - 2部分的数据不用记录
     * 使用滚动数组，只记录i - 1层的数据，空间复杂O(1)
     */
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        int[] dp = new int[]{1, 0, 1};
        for (int i = 2; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < dp.length; j++) {
                if (obstacles[i - 1] == j + 1) {
                    dp[j] = Integer.MAX_VALUE;
                }
                min = obstacles[i] != j + 1 ? Math.min(dp[j], min) : min;
            }
            for (int j = 0; j < dp.length; j++) {
                dp[j] = obstacles[i] != j + 1 ? Math.min(dp[j], min + 1) : Integer.MAX_VALUE;
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    /**
     * dp,本质模拟，无法起跳和无法到达的地点标记为-1
     * 空间复杂O(N)，但是空间消耗比上面少····不知道为啥
     */
    public int minSideJumps2(int[] obstacles) {
        int[][] dp = new int[obstacles.length - 1][3];
        for (int i = 0; i <= 2; i++) {
            dp[1][i] = obstacles[1] == i + 1 ? -1 : (i == 1 ? 0 : 1);
        }
        for (int i = 2; i < dp.length; i++) {
            if (obstacles[i] != 0) {
                dp[i][obstacles[i] - 1] = -1;
            }
            for (int j = 0; j < dp[i].length; j++) {
                // 无法到达不计算
                if (dp[i][j] == -1) {
                    continue;
                }
                int count = Integer.MAX_VALUE;
                for (int k = 0; k < dp[i - 1].length; k++) {
                    // 无法起跳不计算
                    if (dp[i - 1][k] == -1) {
                        continue;
                    }
                    if (k == j) {
                        count = Math.min(count, dp[i - 1][k]);
                    } else {
                        int jump = (obstacles[i] - 1) == k && (obstacles[i - 1] - 1) == j ? 2 : 1;
                        count = Math.min(count, dp[i - 1][k] + jump);
                    }
                }
                dp[i][j] = count;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int count : dp[dp.length - 1]) {
            if (count != -1) {
                ans = Math.min(ans, count);
            }
        }
        return ans;
    }
}
