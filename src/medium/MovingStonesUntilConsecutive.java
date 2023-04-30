package medium;

/**
 * https://leetcode.cn/problems/moving-stones-until-consecutive/
 * 1033. 移动石子直到连续
 *
 * @author Lin
 * @date 2023/4/30
 */
public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(Math.min(a, b), c);
        int z = Math.max(Math.max(a, b), c);
        int y = a + b + c - x - z;
        int dis1 = z - y - 1;
        int dis2 = y - x - 1;
        int min = dis1 == 1 || dis2 == 1 ? 1 : (dis1 == 0 ? 0 : 1) + (dis2 == 0 ? 0 : 1);
        int max = dis1 + dis2;
        return new int[]{min, max};
    }
}
