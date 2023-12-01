package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/first-completely-painted-row-or-column/description/?envType=daily-question&envId=2023-12-01
 * 2661. 找出叠涂元素
 *
 * @author Lin
 * @date 2023/12/01
 */
public class FirstCompletelyPaintedRowColumn {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> valueMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                valueMap.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];

        int rowMax = mat.length;
        int colMax = mat[0].length;

        for (int i = 0; i < arr.length; i++) {
            int[] index = valueMap.get(arr[i]);
            row[index[0]]++;
            col[index[1]]++;
            if (row[index[0]] == colMax || col[index[1]] == rowMax) {
                return i;
            }
        }
        return  -1;

    }
}
