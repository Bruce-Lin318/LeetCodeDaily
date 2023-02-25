package medium;

/**
 * https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/
 * 1247. 交换字符使得字符串相同
 *
 * @author Lin
 * @date 2023/2/25
 */
public class MinimumSwapsToMakeStringsEqual {
    public int minimumSwap(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int x = 0;
        int y = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[i]) {
                continue;
            }
            if (chars1[i] == 'x') {
                x++;
            } else {
                y++;
            }
        }
        return (x + y) % 2 == 1 ? -1 : (x + 1) / 2 + (y + 1) / 2;
    }
}
