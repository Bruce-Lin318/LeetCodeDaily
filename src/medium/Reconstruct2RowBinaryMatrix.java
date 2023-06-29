package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/reconstruct-a-2-row-binary-matrix/
 * 1253. 重构 2 行二进制矩阵
 *
 * @author Lin
 * @date 2023/1/24
 */
public class Reconstruct2RowBinaryMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                l1.add(1);
                l2.add(1);
                upper--;
                lower--;
            } else if (colsum[i] == 1) {
                if (upper > lower) {
                    l1.add(1);
                    l2.add(0);
                    upper--;
                } else {
                    l1.add(0);
                    l2.add(1);
                    lower--;
                }
            } else {
                l1.add(0);
                l2.add(0);
            }
        }
        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(l1);
        res.add(l2);
        return res;
    }
}
