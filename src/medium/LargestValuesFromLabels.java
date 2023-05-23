package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/largest-values-from-labels/
 * 1090. 受标签影响的最大值
 *
 * @author Lin
 * @date 2023/5/23
 */
public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Integer[] index = new Integer[values.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> values[b] - values[a]);
        Map<Integer, Integer> count = new HashMap<>();
        int used = 0;
        int sum = 0;
        for (int i = 0; i < index.length && used < numWanted; i++) {
            if (count.getOrDefault(labels[index[i]], 0) >= useLimit) {
                continue;
            }
            sum += values[index[i]];
            used++;
            count.put(labels[index[i]], count.getOrDefault(labels[index[i]], 0) + 1);
        }
        return sum;
    }
}
