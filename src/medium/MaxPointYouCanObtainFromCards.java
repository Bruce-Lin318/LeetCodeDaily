package medium;

/**
 * https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/
 * 1423. 可获得的最大点数
 *
 * @author Lin
 * @date 2023/12/03
 */
public class MaxPointYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += cardPoints[i];
        }

        int sum = res;
        for (int i = k - 1; i >= 0; i--) {
            sum -= cardPoints[i];
            sum += cardPoints[cardPoints.length - 1 - (k - 1 - i)];
            res = Math.max(res, sum);
        }
        return res;
    }
}
