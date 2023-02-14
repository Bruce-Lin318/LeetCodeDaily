package medium;

/**
 * https://leetcode.cn/problems/longest-well-performing-interval/
 * 1124. 表现良好的最长时间段
 *
 * @author Lin
 * @date 2023/2/14
 */
public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int ans = 0;
        int sum = 0;
        int[] index = new int[hours.length + 2];
        for (int i = 1; i <= hours.length; ++i) {
            sum -= hours[i - 1] > 8 ? 1 : -1;
            if (sum < 0) {
                ans = i;
            } else {
                if (index[sum + 1] > 0) {
                    ans = Math.max(ans, i - index[sum + 1]);
                }
                if (index[sum] == 0) {
                    index[sum] = i;
                }
            }
        }
        return ans;
    }
}
