package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/count-nice-pairs-in-an-array/
 * 1814. 统计一个数组中好对子的数目
 *
 * @author Lin
 * @date 2023/1/17
 */
public class CountNicePairsInAnArray {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for(int num: nums) {
            int value = num - rev(num);
            int count = map.getOrDefault(value, 0);
            res = (res + count) % 1000000007;
            map.put(value, count + 1);
        }
        return res;
    }

    private int rev(int num) {
        int res = 0;
        while(num != 0) {
            res = res * 10 + num % 10;
            num = num / 10;
        }
        return res;
    }
}
