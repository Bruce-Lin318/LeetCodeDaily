package easy;

/**
 * https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 * 2373. 矩阵中的局部最大值
 *
 * @author Lin
 * @date 2023/3/1
 */
public class LargestLocalValuesInMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = max(grid, i, j);
            }
        }
        return ans;
    }

    private int max(int[][] grid, int row, int col) {
        int max = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
