package medium;

import util.TestUtil;
import util.annotation.Main;

/**
 * https://leetcode.cn/problems/minimum-path-cost-in-a-grid/?envType=daily-question&envId=2023-11-22
 * 2304. 网格中的最小路径代价
 *
 * @author Lin
 * @date 2023/11/22
 */
public class MinPathCostInGrid {
    @Main
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        // 初始化dp
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // 初始化第一行
        for (int i = 0; i < col; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int pre = 0; pre < col; pre++) {
                    // 从上一行的 pre 列到当前位置的最小代价
                    // value = 当前节点 + pre节点 + 路径代价
                    int value = grid[i][j] + dp[i - 1][pre] + moveCost[grid[i - 1][pre]][j];
                    dp[i][j] = Math.min(dp[i][j], value);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            res = Math.min(res, dp[row - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        // [[5,3],[4,0],[2,1]]
        int[][] grid = new int[][]{{5, 3}, {4, 0}, {2, 1}};
        // [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
        int[][] moveCost = new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        TestUtil.invoke(grid, moveCost);
    }
}
