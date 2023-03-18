package medium;

/**
 * https://leetcode.cn/problems/split-two-strings-to-make-palindrome/
 * 1616. 分割两个字符串得到回文串
 *
 * @author Lin
 * @date 2023/3/18
 */
public class SplitTwoStringsToMakePalindrome {
    public boolean checkPalindromeFormation(String a, String b) {
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        return process(chars1, chars2) || process(chars2, chars1);
    }
    private boolean process(char[] chars, char[] help) {
        int index = (chars.length - 1) / 2;
        int start = chars.length % 2 == 0 ? index : index - 1;
        int end = index + 1;
        while (start >= 0 && chars[start] == chars[end]) {
            start--;
            end++;
        }
        if (start < 0) {
            return true;
        }
        return check(help, chars, start, end) || check(chars, help, start, end);
    }

    private boolean check(char[] left, char[] right, int l, int r) {
        while (r < right.length && left[l] == right[r]) {
            l--;
            r++;
        }
        return r == right.length;
    }
}
