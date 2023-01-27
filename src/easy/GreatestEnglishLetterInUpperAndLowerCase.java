package easy;

/**
 * https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/
 * 2309. 兼具大小写的最好英文字母
 *
 * @author Lin
 * @date 2023/1/27
 */
public class GreatestEnglishLetterInUpperAndLowerCase {
    public String greatestLetter(String s) {
        int lower = 0, upper = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                lower |= 1 << (c - 'a');
            } else {
                upper |= 1 << (c - 'A');
            }
        }
        for (int i = 25; i >= 0; i--) {
            if ((lower & upper & (1 << i)) != 0) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}
