package easy;

/**
 * https://leetcode.cn/problems/circular-sentence/
 * 2490. 回环句
 *
 * @author Lin
 * @date 2023/6/30
 */
public class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] strings = sentence.split(" ");
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].charAt(0) != strings[i - 1].charAt(strings[i - 1].length() - 1)) {
                return false;
            }
        }
        return strings[0].charAt(0) == strings[strings.length - 1].charAt(strings[strings.length - 1].length() - 1);
    }
}
