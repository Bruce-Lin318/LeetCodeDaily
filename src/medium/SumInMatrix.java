package medium;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sum-in-a-matrix/
 * 2679. 矩阵中的和
 *
 * @author Lin
 * @date 2023/7/4
 */
public class SumInMatrix {
    public int matrixSum(int[][] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        for (int j = 0; j < nums[0].length; j++) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i][j]);
            }
            res += max;
        }
        return res;
    }

}
