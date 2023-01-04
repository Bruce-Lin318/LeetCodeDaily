package easy;

/**
 * https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 * 2042. 检查句子中的数字是否递增
 *
 * @author Lin
 * @date 2023/1/3
 */
public class CheckIfNumbersAreAscendingInSentence {
    public boolean areNumbersAscending(String s) {
        char[] chars = s.toCharArray();
        int num = -1;
        int index = 0;
        while (index < chars.length) {
            if (chars[index] < '0' || chars[index] > '9') {
                index++;
                continue;
            }
            int temp = 0;
            while (index < chars.length && chars[index] != ' ') {
                temp = temp * 10 + chars[index++] - '0';
            }
            if (temp <= num) {
                return false;
            }
            num = temp;
        }
        return true;
    }
}

