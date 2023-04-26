package medium;

/**
 * https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * 1031. 两个非重叠子数组的最大和
 *
 * @author Lin
 * @date 2023/4/26
 */
public class MaximumSumOfTwoNonOverlappingSubarray {
    /**
     * 暴力穷举，数据规模不大，也OK
     */
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int firstL = -1;
        int firstR = firstL + firstLen;
        int ans = 0;
        while (firstR < nums.length) {
            int pre = getSecondMax(-1, firstL, nums, secondLen);
            int next = getSecondMax(firstR, nums.length - 1, nums, secondLen);
            ans = Math.max(ans, getSum(firstL++, firstR++, nums) + Math.max(pre, next));
        }
        return ans;
    }

    private int getSum(int l, int r, int[] nums) {
        return l == -1 ? nums[r] : nums[r] - nums[l];
    }

    /**
     * 求(l, r]区间内的可能最大和
     */
    private int getSecondMax(int l, int r, int[] nums, int secondLen) {
        if (r - l < secondLen) {
            return 0;
        }
        int ans = 0;
        for (int i = l; i < nums.length && i + secondLen <= r; i++) {
            ans = Math.max(ans, getSum(i, i + secondLen, nums));
        }
        return ans;
    }

    /**
     * 滚动数组
     */
    public int maxSumTwoNoOverlap2(int[] nums, int firstLen, int secondLen) {
        return Math.max(process(nums, firstLen, secondLen), process(nums, secondLen, firstLen));
    }

    private int process(int[] nums, int firstLen, int secondLen) {
        int sumL = 0;
        for (int i = 0; i < firstLen; i++) {
            sumL += nums[i];
        }
        int sumR = 0;
        for (int i = firstLen; i < firstLen + secondLen; i++) {
            sumR += nums[i];
        }
        int maxL = sumL;
        int ans = sumL + sumR;
        for (int i = 1; i + firstLen + secondLen <= nums.length; i++) {
            sumL += nums[i + firstLen - 1] - nums[i - 1];
            maxL = Math.max(maxL, sumL);
            sumR += nums[i + firstLen + secondLen - 1] - nums[i + firstLen - 1];
            ans = Math.max(ans, maxL + sumR);
        }
        return ans;
    }
}
