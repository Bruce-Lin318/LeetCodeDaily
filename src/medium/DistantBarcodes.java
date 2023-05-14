package medium;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/distant-barcodes/
 * 1054. 距离相等的条形码
 *
 * @author Lin
 * @date 2023/5/14
 */
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] map = new int[10001];
        for (int i = 0; i < barcodes.length; i++) {
            map[barcodes[i]]++;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                queue.add(new int[]{i, map[i]});
            }
        }
        for (int i = 0; i < barcodes.length - 1; i += 2) {
            int[] ints1 = queue.poll();
            int[] ints2 = queue.poll();
            barcodes[i] = ints1[0];
            barcodes[i + 1] = ints2[0];
            if (ints1[1]-- > 1) {
                queue.add(ints1);
            }
            if (ints2[1]-- > 1) {
                queue.add(ints2);
            }
        }
        if (!queue.isEmpty()) {
            barcodes[barcodes.length - 1] = queue.peek()[0];
        }
        return barcodes;
    }
}
