package medium;

/**
 * https://leetcode.cn/problems/maximal-network-rank/
 * 1615. 最大网络秩
 *
 * @author Lin
 * @date 2023/3/15
 */
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] dp = new boolean[n][n];
        int[] count = new int[n];
        for (int i = 0; i < roads.length; i++) {
            dp[roads[i][0]][roads[i][1]] = true;
            dp[roads[i][1]][roads[i][0]] = true;
            count[roads[i][0]]++;
            count[roads[i][1]]++;
        }
        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count.length; j++) {
                if (i != j) {
                    ans = Math.max(ans, count[i] + count[j] + (dp[i][j] ? -1 : 0));
                }
            }
        }
        return ans;
    }
}
