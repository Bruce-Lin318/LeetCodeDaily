package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/
 * 1072. 按列翻转得到最大值等行数
 *
 * @author Lin
 * @date 2023/5/15
 */
public class FlipColumnsForMaximumNumberOfEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][0] ^ matrix[i][j]);
            }
            String s = stringBuilder.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map.values().stream().max((a, b) -> a - b).get();
    }
}
