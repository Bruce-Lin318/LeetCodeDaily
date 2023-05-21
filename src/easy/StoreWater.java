package easy;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/o8SXZn/
 * LCP 33. 蓄水
 *
 * @author Lin
 * @date 2023/5/21
 */
public class StoreWater {
    public int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int count = 0;
        for (int i = 0; i < bucket.length; ++i) {
            if (bucket[i] == 0 && vat[i] != 0) {
                count++;
                bucket[i]++;
            }
            if (vat[i] > 0) {
                queue.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});
            }
        }
        if (queue.isEmpty()) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        while (count < res) {
            int[] arr = queue.poll();
            int v = arr[0];
            int i = arr[1];
            res = Math.min(res, count + v);
            if (v == 1) {
                break;
            }
            int t = (vat[i] + v - 2) / (v - 1);
            count += t - bucket[i];
            bucket[i] = t;
            queue.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});
        }
        return res;
    }

}
