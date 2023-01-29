package easy;

/**
 * https://leetcode.cn/problems/count-asterisks/
 * 2315. 统计星号
 *
 * @author Lin
 * @date 2023/1/29
 */
public class CountAsterisks {
    public int countAsterisks(String s) {
        char[] chars = s.toCharArray();
        boolean isFair = false;
        int ans = 0;
        for (char c : chars) {
            if (c == '|') {
                isFair = !isFair;
            } else {
                ans += !isFair && c == '*' ? 1 : 0;
            }
        }
        return ans;
    }
}
