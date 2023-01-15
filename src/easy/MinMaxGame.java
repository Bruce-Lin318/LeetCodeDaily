package easy;

/**
 * https://leetcode.cn/problems/min-max-game/
 * 2293. 极大极小游戏
 *
 * @author Lin
 * @date 2023/1/15
 */
public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        int length = nums.length;
        while (length > 1) {
            int index = 0;
            while (index < length / 2) {
                nums[index] = index % 2 == 0 ? Math.min(nums[index * 2], nums[index * 2 + 1]) : Math.max(nums[index * 2], nums[index * 2 + 1]);
                index++;
            }
            length /= 2;
        }
        return nums[0];
    }
}
