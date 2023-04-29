package easy;

/**
 * https://leetcode.cn/problems/remove-letter-to-equalize-frequency/
 * 2423. 删除字符使频率相同
 *
 * @author Lin
 * @date 2023/4/29
 */
public class RemoveLetterToEqualizeFrequency {
    public boolean equalFrequency(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            ++count[word.charAt(i) - 'a'];
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                count[i]--;
                if (isEqualize(count)) {
                    return true;
                }
                count[i]++;
            }
        }
        return false;
    }

    private boolean isEqualize(int[] count) {
        int num = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 && num == 0) {
                num = count[i];
            }
            if (count[i] != 0 && num != 0 && num != count[i]) {
                return false;
            }
        }
        return true;
    }
}
