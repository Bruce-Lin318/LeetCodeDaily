package easy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/counting-words-with-a-given-prefix/
 * 2185. 统计包含给定前缀的字符串
 *
 * @author Lin
 * @date 2023/1/8
 */
public class CountingWordsWithGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words).filter(s -> s.startsWith(pref)).count();
    }

    public int prefixCount2(String[] words, String pref) {
        int res = 0;
        char[] pre = pref.toCharArray();
        for (String word : words) {
            if (word.length() < pref.length()) {
                continue;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            while (index < pre.length && chars[index] == pre[index]) {
                index++;
            }
            res += index == pre.length ? 1 : 0;
        }
        return res;
    }
}
