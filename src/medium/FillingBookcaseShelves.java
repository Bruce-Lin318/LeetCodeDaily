package medium;


import util.TestUtil;
import util.annotation.Main;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/filling-bookcase-shelves/
 * 1105. 填充书架
 *
 * @author Lin
 * @date 2023/4/23
 */
public class FillingBookcaseShelves {
    @Main
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < books.length; i++) {
            int width = 0;
            int height = 0;
            for (int j = i; j >= 0; j--) {
                if ((width += books[j][0]) > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[j][1]);
                dp[i + 1] = Math.min(dp[j] +  height, dp[i + 1]);
            }
        }
        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        int[][] books = new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        TestUtil.invoke(books, 4);
    }
}
