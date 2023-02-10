package hard;

/**
 * https://leetcode.cn/problems/dice-roll-simulation/
 * 1223. 掷骰子模拟
 *
 * @author Lin
 * @date 2023/2/10
 */
public class DiceRollSimulation {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = (int) (Math.pow(10, 9) + 7);
        int number = rollMax.length;
        // 第i次扔出j的序列数
        int[][] dp = new int[n][number];
        for (int i = 0; i < number; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < number; j++) {
                long count = 0L;
                for (int k = 0; k < number; k++) {
                    count += dp[i - 1][k];
                }
                int index = i - rollMax[j] - 1;
                if (index >= 0) {
                    for (int k = 0; k < number; k++) {
                        // 防止count为负数
                        count -= dp[index][k] - mod;
                    }
                    count += dp[index][j];
                } else if (index == -1) {
                    // 特殊情况：当前骰子之前的所有数均为j且刚好满员
                    count -= 1;
                }
                dp[i][j] = (int) (count % mod);
            }
        }

        int ans = 0;
        for (int i = 0; i < number; i++) {
            ans = (ans + dp[n - 1][i]) % mod;
        }
        return ans;
    }

}
