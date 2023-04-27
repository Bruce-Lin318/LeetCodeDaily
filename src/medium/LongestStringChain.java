package medium;

import util.annotation.Main;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/longest-string-chain/
 * 1048. 最长字符串链
 *
 * @author Lin
 * @date 2023/4/27
 */
public class LongestStringChain {
    @Main
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(value -> value.length()));
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < words.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (words[j].length() == words[i].length() - 1 && isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private boolean isPredecessor(String a, String b) {
        int index = 0;
        char[] chars = a.toCharArray();
        for (char c : b.toCharArray()) {
            if (c == chars[index]){
                index++;
            }
            if (index == chars.length){
                break;
            }
        }
        return index == chars.length;
    }
}
