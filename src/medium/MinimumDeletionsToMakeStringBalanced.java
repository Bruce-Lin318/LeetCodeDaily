package medium;

/**
 * https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 * 1653. 使字符串平衡的最少删除次数
 *
 * @author Lin
 * @date 2023/3/6
 */
public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int a = 0, b = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            a = Math.min(a, b) + chars[i] - 'a';
            b = b + 'b' - chars[i];
        }
        return Math.min(a, b);
    }
}
