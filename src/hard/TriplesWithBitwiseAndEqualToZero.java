package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/
 * 982. 按位与为零的三元组
 *
 * @author Lin
 * @date 2023/3/4
 */
public class TriplesWithBitwiseAndEqualToZero {
    public int countTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            for (int j : nums) {
                int t = i & j;
                map.put(t, map.getOrDefault(t, 0) + 1);
            }
        }
        int ans = 0;
        for (int i : nums) {
            for (Integer j : map.keySet()) {
                if ((i & j) == 0) {
                    ans += map.get(j);
                }
            }
        }
        return ans;
    }
}
