package easy;

/**
 * https://leetcode.cn/problems/decode-the-message/
 * 2325. 解密消息
 *
 * @author Lin
 * @date 2023/2/1
 */
public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        char[] table = new char[26];
        char[] keys = key.toCharArray();
        char index = 'a';
        for (char c : keys) {
            if (c != ' ' && table[c - 'a'] == 0) {
                table[c - 'a'] = index++;
            }
        }
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' && table[chars[i] - 'a'] != 0) {
                chars[i] = table[chars[i] - 'a'];
            }
        }
        return new String(chars);
    }
}
