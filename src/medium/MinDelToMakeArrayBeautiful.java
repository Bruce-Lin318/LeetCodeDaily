package medium;

/**
 * https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/?envType=daily-question&envId=2023-11-21
 * 2216. 美化数组的最少删除数
 *
 * @author Lin
 * @date 2023/11/21
 */
public class MinDelToMakeArrayBeautiful {

    public int minDeletion(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                int j = i + 1;
                while (j < nums.length && nums[j] == nums[i]) {
                    j++;
                }
                res += j - i - 1;
                i = j;
            } else {
                i++;
            }
        }
        return ((nums.length - res) % 2) != 0 ? res + 1 : res;
    }
}
