package easy;

/**
 * https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
 * 2335. 装满杯子需要的最短总时长
 *
 * @author Lin
 * @date 2023/2/11
 */
public class MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {
        int max = Math.max(amount[0], Math.max(amount[1], amount[2]));
        int total = amount[0] + amount[1] + amount[2];
        return total <= 2 * max ? max : (total + 1) / 2;
    }
}
