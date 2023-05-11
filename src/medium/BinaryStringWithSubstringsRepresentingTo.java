package medium;

import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 *
 * @author Lin
 * @date 2023/5/11
 */
public class BinaryStringWithSubstringsRepresentingTo {
    public boolean queryString(String s, int n) {
        TreeSet<Integer> set = new TreeSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int res = 0;
            for (int j = i; j < i + 10 && j < chars.length; j++) {
                res = res * 2 + (chars[j] - '0');
                set.add(res);
            }
        }
        set.remove(0);
        int max = 0;
        while (!set.isEmpty() && set.first() == max + 1) {
            max = set.pollFirst();
        }
        return n <= max;
    }
}
