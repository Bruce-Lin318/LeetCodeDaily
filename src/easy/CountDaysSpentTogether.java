package easy;

import util.annotation.Main;

/**
 * https://leetcode.cn/problems/count-days-spent-together/
 * 2409. 统计共同度过的日子数
 *
 * @author Lin
 * @date 2023/4/17
 */
public class CountDaysSpentTogether {
    private int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    @Main
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        for (int i = 1; i < days.length; i++) {
            days[i] = days[i] + days[i - 1];
        }
        return Math.max(0, Math.min(parse(leaveAlice), parse(leaveBob)) - Math.max(parse(arriveAlice), parse(arriveBob)) + 1);
    }

    private int parse(String date) {
        char[] chars = date.toCharArray();
        int month = (chars[0] - '0') * 10 + (chars[1] - '0') - 1;
        int day = (chars[3] - '0') * 10 + (chars[4] - '0');
        int count = month == 0 ? 0 : days[month - 1];
        return count + day;
    }
}
