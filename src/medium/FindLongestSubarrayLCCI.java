package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-longest-subarray-lcci/
 * 面试题 17.05.  字母与数字
 *
 * @author Lin
 * @date 2023/3/11
 */
public class FindLongestSubarrayLCCI {
    public String[] findLongestSubarray(String[] array) {
        int[] sum = new int[array.length];
        sum[0] = Character.isDigit(array[0].charAt(0)) ? 1 : -1;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + (Character.isDigit(array[i].charAt(0)) ? 1 : -1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int start = -1;
        int end = -1;
        Integer pre;
        map.put(0, -1);
        for (int i = 0; i < sum.length; i++) {
            if ((pre = map.get(sum[i])) == null) {
                map.put(sum[i], i);
            } else if (i - pre > end - start){
                start = pre;
                end = i;
            }
        }
        return Arrays.copyOfRange(array, start + 1, end + 1);
    }

    /**
     * 因为每次只用到了sum[i]，所以其实没必要保存整个前缀和数组，相比于方法一，用单个int取代了int[]，其他逻辑未变
     * 结果方法二的时空间开销都比方法一大·····我不理解
     */
    public String[] findLongestSubarray2(String[] array) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = -1;
        int end = -1;
        Integer pre;
        map.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            sum += Character.isDigit(array[i].charAt(0)) ? 1 : -1;
            if ((pre = map.get(sum)) == null) {
                map.put(sum, i);
            } else if (i - pre > end - start){
                start = pre;
                end = i;
            }
        }
        return Arrays.copyOfRange(array, start + 1, end + 1);
    }
}
