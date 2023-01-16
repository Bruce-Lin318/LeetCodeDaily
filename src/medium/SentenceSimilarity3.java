package medium;

/**
 * https://leetcode.cn/problems/sentence-similarity-iii/
 * 1813. 句子相似性 III
 *
 * @author Lin
 * @date 2023/1/16
 */
public class SentenceSimilarity3 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence2.length() > sentence1.length()) {
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }
        String[] strings1 = sentence1.split(" ");
        String[] strings2 = sentence2.split(" ");
        int left1 = 0, right1 = strings1.length - 1;
        int left2 = 0, right2 = strings2.length - 1;
        while (right1 >= 0 && right2 >= 0 && strings1[right1].equals(strings2[right2])) {
            right1--;
            right2--;
        }
        while (left1 < strings1.length && left2 < strings2.length && strings1[left1].equals(strings2[left2])) {
            left1++;
            left2++;
        }
        return right2 < left2;
    }
}
