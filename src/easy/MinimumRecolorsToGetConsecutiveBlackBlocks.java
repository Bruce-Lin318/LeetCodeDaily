package easy;

/**
 * https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 * 2379. 得到 K 个黑块的最少涂色次数
 *
 * @author Lin
 * @date 2023/3/9
 */
public class MinimumRecolorsToGetConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (chars[i] == 'W') {
                count++;
            }
        }
        int start = 0;
        int end = k - 1;
        int ans = count;
        while (end < chars.length - 1) {
            if (chars[start++] == 'W') {
                count--;
            }
            if (chars[++end] == 'W') {
                count++;
            }
            ans = Math.min(ans, count);
        }
        return ans;
    }
}
