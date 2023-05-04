package hard;


/**
 * https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/
 * 2106. 摘水果
 *
 * @author Lin
 * @date 2023/5/4
 */
public class MaximumFruitsHarvestedAfterAtMostSteps {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < fruits.length) {
            sum += fruits[right][1];
            while (left <= right &&
                    Math.min(Math.abs(startPos - fruits[left][0]), Math.abs(startPos - fruits[right][0]))
                            + fruits[right][0] - fruits[left][0] > k) {
                sum -= fruits[left++][1];
            }
            ans = Math.max(sum, ans);
            right++;
        }
        return ans;
    }
}
