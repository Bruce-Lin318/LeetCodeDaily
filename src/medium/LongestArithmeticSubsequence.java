package medium;

import java.util.Arrays;

/**
 * @author Lin
 * @date 2023/4/22
 */
public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int diff = max - min;
        int ans = 1;
        for (int d = -diff; d <= diff; ++d) {
            int[] f = new int[max + 1];
            Arrays.fill(f, -1);
            for (int num : nums) {
                int prev = num - d;
                if (prev >= min && prev <= max && f[prev] != -1) {
                    f[num] = Math.max(f[num], f[prev] + 1);
                    ans = Math.max(ans, f[num]);
                }
                f[num] = Math.max(f[num], 1);
            }
        }
        return ans;
    }
}
