package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/arithmetic-subarrays/
 * 1630. 等差子数组
 *
 * @author Lin
 * @date 2023/3/23
 */
public class ArithmeticSubArrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            if (r[i] - l[i] < 2) {
                ans.add(true);
                continue;
            }
            int left = l[i];
            int right = r[i];
            int[] subArr = Arrays.copyOfRange(nums, left, right + 1);
            Arrays.sort(subArr);
            boolean bans = true;
            //s[i+1] - s[i] == s[1] - s[0]
            for (int j = 1; j < subArr.length; j++) {
                if (subArr[j] - subArr[j - 1] != subArr[1] - subArr[0]) {
                    bans = false;
                    break;
                }
            }
            ans.add(bans);
        }
        return ans;
    }
}
