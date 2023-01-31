package easy;

/**
 * https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
 * 2319. 判断矩阵是否是一个 X 矩阵
 *
 * @author Lin
 * @date 2023/1/31
 */
public class CheckIfMatrixIsXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == j || i + j == grid.length - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
