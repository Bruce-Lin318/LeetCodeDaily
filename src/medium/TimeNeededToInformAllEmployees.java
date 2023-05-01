package medium;


import java.util.Arrays;

/**
 * https://leetcode.cn/problems/time-needed-to-inform-all-employees/
 * 1376. 通知所有员工所需的时间
 *
 * @author Lin
 * @date 2023/5/1
 */
public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] dp = new int[manager.length];
        for (int i = 0; i < dp.length; i++) {
            process(i, dp, manager, informTime);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private int process(int i, int[] dp, int[] manager, int[] informTime) {
        if (i == -1) {
            return 0;
        }
        if (dp[i] == 0) {
            dp[i] = informTime[i] + process(manager[i], dp, manager, informTime);
        }
        return dp[i];
    }
}
