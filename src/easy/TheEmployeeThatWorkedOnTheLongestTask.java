package easy;


/**
 * https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/
 * 2432. 处理用时最长的那个任务的员工
 *
 * @author Lin
 * @date 2023/5/5
 */
public class TheEmployeeThatWorkedOnTheLongestTask {
    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0];
        int max = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int time = logs[i][1] - logs[i - 1][1];
            if (time > max || (time == max && ans > logs[i][0])) {
                ans = logs[i][0];
                max = time;
            }
        }
        return ans;
    }
}
