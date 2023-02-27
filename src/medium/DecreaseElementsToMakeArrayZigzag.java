package medium;

/**
 * https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
 * 1144. 递减元素使数组呈锯齿状
 *
 * @author Lin
 * @date 2023/2/27
 */
public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 1; i < n; i += 2) {
            int min = nums[i - 1];
            if (i < n - 1) {
                min = Math.min(min, nums[i + 1]);
            }
            if (min <= nums[i]) {
                sum += nums[i] - min + 1;
            }
        }
        int ans = sum;
        sum = 0;
        for (int i = 1; i < n; i += 2) {
            if (nums[i - 1] >= nums[i]) {
                sum += nums[i - 1] - nums[i] + 1;
            }
            if (i < n - 1 && nums[i + 1] >= nums[i]) {
                sum += nums[i + 1] - nums[i] + 1;
                nums[i + 1] = nums[i] - 1;
            }
        }
        return Math.min(ans, sum);
    }
}
