package medium;

import util.TestUtil;
import util.annotation.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/flower-planting-with-no-adjacent/
 * 1042. 不邻接植花
 *
 * @author Lin
 * @date 2023/4/15
 */
public class FlowerPlantingWithNoAdjacent {
    @Main
    public int[] gardenNoAdj2(int n, int[][] paths) {
        List<Integer>[] dp = new List[n + 1];
        for (int i = 0; i < paths.length; i++) {
            int min = Math.min(paths[i][0], paths[i][1]);
            int max = Math.max(paths[i][0], paths[i][1]);
            if (dp[min] == null) {
                dp[min] = new ArrayList<>();
            }
            dp[min].add(max);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 3; j >= 0; j--) {
                if ((ans[i] & (1 << j)) == 0) {
                    ans[i] = j + 1;
                    break;
                }
            }
            if (dp[i + 1] != null) {
                for (int next : dp[i + 1]) {
                    ans[next - 1] |= (1 << (ans[i] - 1));
                }
            }
        }
        return ans;
    }
}
