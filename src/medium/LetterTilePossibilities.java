package medium;

/**
 * https://leetcode.cn/problems/letter-tile-possibilities/
 * 1079. 活字印刷
 *
 * @author Lin
 * @date 2023/5/19
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            count[tiles.charAt(i) - 'A']++;
        }
        return dfs(count);
    }

    private int dfs(int[] count) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                sum++;
                count[i]--;
                sum += dfs(count);
                count[i]++;
            }
        }
        return sum;
    }
}
