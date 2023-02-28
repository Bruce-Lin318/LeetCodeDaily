package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-similar-items/
 * 2363. 合并相似的物品
 *
 * @author Lin
 * @date 2023/2/28
 */
public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] w = new int[1001];
        for (int[] item : items1) {
            w[item[0]] = item[1];
        }
        for (int[] item : items2) {
            w[item[0]] = item[1] + w[item[0]];
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            if (w[i] != 0) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(w[i]);
                res.add(list);
            }
        }
        return res;
    }

}
