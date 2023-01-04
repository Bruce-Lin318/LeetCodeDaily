package medium;

/**
 * https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 * 1802. 有界数组中指定下标处的最大值
 *
 * @author Lin
 * @date 2023/1/4
 */
public class MaximumValueAtGivenIndexInBoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int min = 1;
        int max = maxSum;
        int ans = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            long res = compute(n, index, mid);
            if (res < maxSum) {
                min = mid + 1;
                ans = mid;
            } else if (res > maxSum) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return ans;
    }

    private long compute(int n, int index, int value) {
        int leftNum = index;
        int rightNum = n - 1 - index;
        long start = value - 1;

        long left = leftNum < value ? (leftNum * start - leftNum * (leftNum - 1) / 2)
                : (start * (start + 1) / 2 + leftNum - start);
        long right = rightNum < value ? (rightNum * start - (rightNum * (rightNum - 1) / 2))
                : (start * (start + 1) / 2 + rightNum - start);
        return left + right + value;
    }
}
