package medium;

/**
 * https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 * 1234. 替换子串得到平衡字符串
 *
 * @author Lin
 * @date 2023/2/13
 */
public class ReplaceTheSubstringForBalancedString {
    public int balancedString(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[26];
        for (char c : chars) {
            nums[getIndex(c)]++;
        }
        int ave = chars.length / 4;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] > ave ? nums[i] - ave : 0;
            length += nums[i];
        }
        while (true) {
            int start = 0;
            int end = length - 1;
            int[] count = new int[26];
            for (int i = start; i <= end; i++) {
                count[chars[i] - 'A']++;
            }
            if (check(count, nums)) {
                return length;
            }
            while (end < chars.length - 1) {
                count[getIndex(chars[start++])]--;
                count[getIndex(chars[++end])]++;
                if (check(count, nums)) {
                    return length;
                }
            }
            length++;
        }
    }

    private int getIndex(char c) {
        return c - 'A';
    }

    private boolean check(int[] count, int[] target) {
        return count[getIndex('Q')] >= target[getIndex('Q')]
                && count[getIndex('W')] >= target[getIndex('W')]
                && count[getIndex('E')] >= target[getIndex('E')]
                && count[getIndex('R')] >= target[getIndex('R')];
    }
}