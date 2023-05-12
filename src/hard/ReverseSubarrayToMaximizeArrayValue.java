package hard;


/**
 * https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value/
 * 1330. 翻转子数组得到最大的数组值
 *
 * @author Lin
 * @date 2023/5/12
 */
public class ReverseSubarrayToMaximizeArrayValue {
    public int maxValueAfterReverse(int[] nums) {
        int sum = 0;
        int ans = 0;
        // 区分正负 ± nums[i] ± nums[i - 1] - | nums[i] - nums[i - 1] |
        int min = Integer.MIN_VALUE / 2;
        int[][] max = new int[][]{{min, min}, {min, min}};
        for (int i = 1; i < nums.length; i++) {
            int abs = Math.abs(nums[i] - nums[i - 1]);
            sum += abs;
            ans = Math.max(ans, max(Math.abs(nums[i - 1] - nums[nums.length - 1]),
                    Math.abs(nums[i] - nums[0]),
                    max[0][0] - nums[i - 1] - nums[i],
                    max[0][1] - nums[i - 1] + nums[i],
                    max[1][0] + nums[i - 1] - nums[i],
                    max[1][1] + nums[i - 1] + nums[i]) - abs);
            max[0][0] = Math.max(max[0][0], nums[i] + nums[i - 1] - abs);
            max[0][1] = Math.max(max[0][1], -nums[i] + nums[i - 1] - abs);
            max[1][0] = Math.max(max[1][0], nums[i] - nums[i - 1] - abs);
            max[1][1] = Math.max(max[1][1], -nums[i] - nums[i - 1] - abs);
        }
        return sum + ans;
    }

    private int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}
