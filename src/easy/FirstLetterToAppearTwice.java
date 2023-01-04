package easy;

/**
 * https://leetcode.cn/problems/first-letter-to-appear-twice/
 * 2351. 第一个出现两次的字母
 *
 * @author Lin
 * @date 2023/1/1
 */
public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(0 != (num & 1 << (c - 'a'))) {
                return c;
            }
            num = num | 1 << (c - 'a');
        }
        return 'a';
    }
}
