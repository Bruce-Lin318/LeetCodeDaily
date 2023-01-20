package medium;

import java.util.*;

/**
 * https://leetcode.cn/problems/finding-the-users-active-minutes/
 * 1817. 查找用户活跃分钟数
 *
 * @author Lin
 * @date 2023/1/20
 */
public class FindingTheUsersActiveMinutes {
    /**
     * 排序，逐个统计同一ID的活跃时间数，不需要使用Map和Set统计去重
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Arrays.sort(logs, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        int id = logs[0][0], time = 1;
        for (int i = 1; i < logs.length; i++) {
            int[] log = logs[i];
            if (log[0] == id && log[1] != logs[i - 1][1]) {
                time++;
            } else if (log[0] != id) {
                ans[time - 1]++;
                id = log[0];
                time = 1;
            }
        }
        ans[time - 1]++;
        return ans;
    }

    /**
     * 用Map和Set统计去重
     */
    public int[] findingUsersActiveMinutes2(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int[] time : logs) {
            if (!map.containsKey(time[0])) {
                map.put(time[0], new HashSet());
            }
            map.get(time[0]).add(time[1]);
        }
        for (Set<Integer> times : map.values()) {
            int time = times.size();
            if (time <= k) {
                ans[time - 1]++;
            }
        }
        return ans;
    }
}
