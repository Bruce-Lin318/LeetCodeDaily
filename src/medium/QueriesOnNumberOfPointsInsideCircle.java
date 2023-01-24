package medium;

/**
 * https://leetcode.cn/problems/queries-on-number-of-points-inside-a-circle/
 * 1828. 统计一个圆中点的数目
 *
 * @author Lin
 * @date 2023/1/24
 */
public class QueriesOnNumberOfPointsInsideCircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            for (int j = 0; j < points.length; j++) {
                int[] point = points[j];
                if (Math.pow(point[0] - query[0], 2) + Math.pow(point[1] - query[1], 2) <= Math.pow(query[2], 2)) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
