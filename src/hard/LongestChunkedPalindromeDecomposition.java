package hard;

import util.annotation.Main;

/**
 * https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/
 * 1147. 段式回文
 *
 * @author Lin
 * @date 2023/4/12
 */
public class LongestChunkedPalindromeDecomposition {

    @Main
    public int longestDecomposition(String text) {
        char[] chars = text.toCharArray();
        int res = 1;
        int start = 0;
        int end = chars.length - 1;
        while (end > start) {
            int length = process(chars, start, end);
            if (length == 0) {
                return res;
            }
            res += 2;
            start += length;
            end -= length;
        }
        return res + (start > end ? -1 : 0);
    }

    private int process(char[] chars, int start, int end) {
        int right = end;
        while (true) {
            while (right >= 0 && chars[right] != chars[start]) {
                right--;
            }
            if (right < chars.length / 2) {
                return 0;
            }
            int cur = right;
            int left = start;
            while (right <= end && chars[right] == chars[left]) {
                left++;
                right++;
            }
            if (right <= end) {
                right = cur - 1;
                continue;
            }
            return end - right + 1;
        }
    }
}
