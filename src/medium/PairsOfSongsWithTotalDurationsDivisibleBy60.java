package medium;

/**
 * https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * 1010. 总持续时间可被 60 整除的歌曲
 *
 * @author Lin
 * @date 2023/5/7
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            int t = time[i] % 60;
            res += t == 0 ? count[0] : count[60 - t];
            count[t] ++;
        }
        return res;
    }
}
