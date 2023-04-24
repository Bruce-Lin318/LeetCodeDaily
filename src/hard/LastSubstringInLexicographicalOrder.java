package hard;

/**
 * https://leetcode.cn/problems/last-substring-in-lexicographical-order/
 * 1163. 按字典序排在最后的子串
 *
 * @author Lin
 * @date 2023/4/24
 */
public class LastSubstringInLexicographicalOrder {
    public String lastSubstring(String s) {
        char[] chars = s.toCharArray();
        char max = 'a';
        for (char c : chars) {
            max = c > max ? c : max;
        }
        int res = 0;
        while (res < chars.length && chars[res] != max) {
            res++;
        }
        int contrast = res + 1;
        while (contrast < chars.length && chars[contrast] != max) {
            contrast++;
        }
        while (res < chars.length && contrast < chars.length) {
            int offset = 1;
            while (contrast + offset < chars.length && chars[res + offset] == chars[contrast + offset]) {
                offset++;
            }
            if (contrast + offset >= chars.length) {
                break;
            }
            if (chars[res + offset] < chars[contrast + offset]) {
                res = contrast;
                contrast = res;
            }
            contrast++;
            while (contrast < chars.length && chars[contrast] != max) {
                contrast++;
            }
        }
        return s.substring(res);
    }
}
