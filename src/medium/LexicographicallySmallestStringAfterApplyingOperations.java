package medium;

/**
 * https://leetcode.cn/problems/lexicographically-smallest-string-after-applying-operations/
 * 1625. 执行操作后字典序最小的字符串
 *
 * @author Lin
 * @date 2023/3/19
 */
public class LexicographicallySmallestStringAfterApplyingOperations {
    private char[] chars;
    public String findLexSmallestString(String s, int a, int b) {
        chars = s.toCharArray();
        int n = chars.length, index = 0;
        String res = s;
        do {
            if (b % 2 == 1) {
                add(index, a);
            }
            add((index + 1) % n, a);
            String t = String.valueOf(chars).substring(index, n) + String.valueOf(chars).substring(0, index);
            if (t.compareTo(res) < 0) {
                res = t;
            }
            index = (index + b) % n;
        } while (index != 0);
        return res;
    }

    private void add(int start, int a) {
        int num = chars[start] - '0';
        if (a == 5) {
            num = num >= 5 ? num - 5 : num;
        } else {
            num = a % 2 == 1 ? 0 : num % 2;
        }
        int n = chars.length;
        while (chars[start] - '0' != num) {
            for (int i = start % 2; i < n; i += 2) {
                chars[i] = (char) ('0' + (chars[i] - '0' + a) % 10);
            }
        }
    }
}
