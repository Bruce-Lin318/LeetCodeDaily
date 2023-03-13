package easy;

/**
 * https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
 * 2383. 赢得比赛需要的最少训练时长
 *
 * @author Lin
 * @date 2023/3/13
 */
public class MinimumHoursOfTrainingToWinCompetition {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i <= energy.length; i++) {
            if (initialExperience < experience[i]) {
                ans += experience[i] - initialExperience + 1;
                initialExperience = experience[i] + 1;
            }
            sum += energy[i];
            initialExperience += experience[i];
        }
        return ans + (initialEnergy > sum ? 0 : sum - initialEnergy + 1);
    }
}
