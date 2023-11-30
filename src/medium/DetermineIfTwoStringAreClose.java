package medium;

/**
 * https://leetcode.cn/problems/determine-if-two-strings-are-close/?envType=daily-question&envId=2023-11-30
 * 1657. 确定两个字符串是否接近
 *
 * @author Lin
 * @date 2023/11/30
 */
public class DetermineIfTwoStringAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        for (int i = 0; i < word1.length(); i++) {
            count1[charArray1[i] - 'a']++;
            count2[charArray2[i] - 'a']++;
        }


        for (int i = 0; i < count1.length; i++) {
            if (count1[i] == count2[i]) {
                continue;
            }

            if (count1[i] == 0 && count2[i] != 0 || count1[i] != 0 && count2[i] == 0) {
                return false;
            }

            for (int j = i + 1; j < count1.length; j++) {
                if(count1[j] == count2[i]){
                    int temp = count1[i];
                    count1[i] = count1[j];
                    count1[j] = temp;
                    break;
                }
            }
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}
